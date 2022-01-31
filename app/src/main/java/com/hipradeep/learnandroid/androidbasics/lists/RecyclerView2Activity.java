package com.hipradeep.learnandroid.androidbasics.lists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.androidbasics.lists.v2.PageIndicatorView;
import com.hipradeep.learnandroid.androidbasics.lists.v2.PageRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView2Activity extends AppCompatActivity {

    private PageRecyclerView mRecyclerView = null;
    private List<String> dataList = null;
    private PageRecyclerView.PageAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);
        initData();

        mRecyclerView =  findViewById(R.id.recyclerView);

        mRecyclerView.setIndicator( findViewById(R.id.indicator));

        mRecyclerView.setPageSize(3, 3);

        mRecyclerView.setPageMargin(30);

        mRecyclerView.setAdapter(myAdapter = mRecyclerView.new PageAdapter(dataList, new PageRecyclerView.CallBack() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(RecyclerView2Activity.this).inflate(R.layout.item, parent, false);
                return new MyHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((MyHolder) holder).tv.setText(dataList.get(position));
            }

            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(RecyclerView2Activity.this, "123"
                        + dataList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(RecyclerView2Activity.this, "012"
                        + dataList.get(position), Toast.LENGTH_SHORT).show();
                myAdapter.remove(position);
            }
        }));

    }
    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(String.valueOf(i));
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tv = null;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
        }
    }
}