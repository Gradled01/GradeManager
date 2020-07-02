package com.good;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.ViewHolder>{


    private List<User> mUserList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //用来创建ViewHolder实例，再将加载好的布局传入构造函数，最后返回ViewHolder实例
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public GradeAdapter(List<User> userList){
        mUserList=userList;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //用于对RecyclerView的子项进行赋值，会在每个子项滚动到屏幕内的时候执行
        User user=mUserList.get(position);
        //holder.fruitImage.setImageResource(user.getImageID());
        holder.username.setText(user.getUsername());

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
       // ImageView fruitImage;
        TextView username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //fruitImage=itemView.findViewById(R.id.fruit_image);
            username=itemView.findViewById(R.id.username);
        }
    }


}
