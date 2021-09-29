package com.hipradeep.viewpagerexample.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipradeep.viewpagerexample.R;

public class ViewPagerRecyclerAdapter extends RecyclerView.Adapter<ViewPagerRecyclerAdapter.MyViewHolder> {

    private String[] number = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private Context ctx;

    public ViewPagerRecyclerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_viewpager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(number[position]);

    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }

        public void bind(String s) {

            textView.setText(s);
        }
    }
}
