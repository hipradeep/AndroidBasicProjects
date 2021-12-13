package com.hipradeep.learnandroid.androidbasics.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipradeep.learnandroid.R;
import com.hipradeep.learnandroid.androidbasics.models.UserModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewAdapter> {

    List<UserModel> list;
    Context context;

    public RecyclerViewAdapter(List<UserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_simple, parent, false);
        return new MyViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewAdapter holder, int position) {

        holder.iv_profile.setImageResource(list.get(position).getImage());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_mobile.setText(list.get(position).getMobile());
        holder.tv_address.setText(list.get(position).getAddress());

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Image Click", Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Click", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "Long Click on Item", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewAdapter extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_name, tv_mobile, tv_address;
        public MyViewAdapter(@NonNull View itemView) {
            super(itemView);

            iv_profile=itemView.findViewById(R.id.iv_profile);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_mobile=itemView.findViewById(R.id.tv_mobile);
            tv_address=itemView.findViewById(R.id.tv_address);

        }
    }
}
