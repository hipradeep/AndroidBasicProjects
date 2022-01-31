package com.hipradeep.learnandroid.androidbasics.lists.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PageRecyclerView extends RecyclerView {

    private Context mContext = null;

    private PageAdapter myAdapter = null;

    private int shortestDistance;
    private float slideDistance = 0;
    private float scrollX = 0;

    private int spanRow = 1;
    private int spanColumn = 3;
    private int totalPage = 0;
    private int currentPage = 1;

    private int pageMargin = 0;

    private PageIndicatorView mIndicatorView = null;

    private int realPosition = 0;

    private int scrollState = 0;

    private AutoGridLayoutManager mAutoGridLayoutManager;

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    public PageRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        defaultInit(context);
    }

    // 默认初始化
    private void defaultInit(Context context) {
        this.mContext = context;
        this.mAutoGridLayoutManager = new AutoGridLayoutManager(
                mContext, spanRow, AutoGridLayoutManager.HORIZONTAL, false);
        setLayoutManager(mAutoGridLayoutManager);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public void setPageSize(int spanRow, int spanColumn) {
        this.spanRow = spanRow <= 0 ? this.spanRow : spanRow;
        this.spanColumn = spanColumn <= 0 ? this.spanColumn : spanColumn;

        this.mAutoGridLayoutManager = new AutoGridLayoutManager(
                mContext, this.spanRow, AutoGridLayoutManager.HORIZONTAL, false);
        setLayoutManager(mAutoGridLayoutManager);
    }


    public void setPageMargin(int pageMargin) {
        this.pageMargin = pageMargin;
    }

    public void setIndicator(PageIndicatorView indicatorView) {
        this.mIndicatorView = indicatorView;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        shortestDistance = getMeasuredWidth() / 3;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        this.myAdapter = (PageAdapter) adapter;
        update();
    }


    private void update() {
        int temp = ((int) Math.ceil(myAdapter.dataList.size() / (double) (spanRow * spanColumn)));
        if (temp != totalPage) {
            mIndicatorView.initIndicator(temp);

            if (temp < totalPage && currentPage == totalPage) {
                currentPage = temp;
                smoothScrollBy(-getWidth(), 0);
            }
            mIndicatorView.setSelectedPage(currentPage - 1);
            totalPage = temp;
        }


        if (totalPage > 1 ){
            mIndicatorView.setVisibility(VISIBLE);
        }else {
            mIndicatorView.setVisibility(GONE);
        }
        mAutoGridLayoutManager.setTotalPages(temp);
    }

    @Override
    public void onScrollStateChanged(int state) {
        switch (state) {
            case 2:
                scrollState = 2;
                break;
            case 1:
                scrollState = 1;
                break;
            case 0:
                if (slideDistance == 0) {
                    break;
                }
                scrollState = 0;
                if (slideDistance < 0) { // 上页
                    currentPage = (int) Math.ceil(scrollX / getWidth());
                    if (currentPage * getWidth() - scrollX < shortestDistance) {
                        currentPage += 1;
                    }
                } else {
                    currentPage = (int) Math.ceil(scrollX / getWidth()) + 1;
                    if (currentPage <= totalPage) {
                        if (scrollX - (currentPage - 2) * getWidth() < shortestDistance) {

                            currentPage -= 1;
                        }
                    } else {
                        currentPage = totalPage;
                    }
                }

                smoothScrollBy((int) ((currentPage - 1) * getWidth() - scrollX), 0);

                mIndicatorView.setSelectedPage(currentPage - 1);
                slideDistance = 0;
                break;
        }
        super.onScrollStateChanged(state);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        scrollX += dx;
        if (scrollState == 1) {
            slideDistance += dx;
        }

        super.onScrolled(dx, dy);
    }


    public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<?> dataList = null;
        private CallBack mCallBack = null;
        private int itemWidth = 0;
        private int itemCount = 0;

        public PageAdapter(List<?> data, CallBack callBack) {
            this.dataList = data;
            this.mCallBack = callBack;
            itemCount = dataList.size() + spanRow * spanColumn;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (itemWidth <= 0) {
                // 计算Item的宽度
                itemWidth = (parent.getWidth() - pageMargin * 2) / spanColumn;
            }

            RecyclerView.ViewHolder holder = mCallBack.onCreateViewHolder(parent, viewType);

            holder.itemView.measure(0, 0);
            holder.itemView.getLayoutParams().width = itemWidth;
            holder.itemView.getLayoutParams().height = holder.itemView.getMeasuredHeight();

            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (spanColumn == 1) {

                holder.itemView.getLayoutParams().width = itemWidth + pageMargin * 2;
                holder.itemView.setPadding(pageMargin, 0, pageMargin, 0);
            } else {
                int m = position % (spanRow * spanColumn);
                if (m < spanRow) {

                    holder.itemView.getLayoutParams().width = itemWidth + pageMargin;
                    holder.itemView.setPadding(pageMargin, 0, 0, 0);
                } else if (m >= spanRow * spanColumn - spanRow) {

                    holder.itemView.getLayoutParams().width = itemWidth + pageMargin;
                    holder.itemView.setPadding(0, 0, pageMargin, 0);
                } else {

                    holder.itemView.getLayoutParams().width = itemWidth;
                    holder.itemView.setPadding(0, 0, 0, 0);
                }
            }

            countRealPosition(position);

            holder.itemView.setTag(realPosition);

            setListener(holder);

            if (realPosition < dataList.size()) {
                holder.itemView.setVisibility(View.VISIBLE);
                mCallBack.onBindViewHolder(holder, realPosition);
            } else {
                holder.itemView.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public int getItemCount() {
            return itemCount;
        }

        private void countRealPosition(int position) {

            int m = position % (spanRow * spanColumn);
            switch (m) {
                case 1:
                case 5:
                    realPosition = position + 2;
                    break;
                case 3:
                case 7:
                    realPosition = position - 2;
                    break;
                case 2:
                    realPosition = position + 4;
                    break;
                case 6:
                    realPosition = position - 4;
                    break;
                case 0:
                case 4:
                case 8:
                    realPosition = position;
                    break;
            }
        }

        private void setListener(ViewHolder holder) {

            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.onItemClickListener(v, (Integer) v.getTag());
                }
            });

            holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mCallBack.onItemLongClickListener(v, (Integer) v.getTag());
                    return true;
                }
            });
        }

        public void remove(int position) {
            if (position < dataList.size()) {

                dataList.remove(position);
                itemCount--;

                notifyItemRemoved(position);

                notifyItemRangeChanged((currentPage - 1) * spanRow * spanColumn, currentPage * spanRow * spanColumn);

                update();
            }
        }

    }

    public interface CallBack {

        RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

        void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

        void onItemClickListener(View view, int position);
        void onItemLongClickListener(View view, int position);

    }

}