package com.dckroff.todoapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.dckroff.todoapp.R;
import com.dckroff.todoapp.model.Todo;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    private ArrayList<Todo> todoList;

    public void setFilteredList(ArrayList<Todo> filteredList) {
        this.todoList = filteredList;
        notifyDataSetChanged();
    }

    public TodoAdapter(Context context, ArrayList<Todo> todoList) {
        this.inflater = LayoutInflater.from(context);
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_uncompleted_todo, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Todo todo = this.todoList.get(position);

        holder.tvTodoTitle.setText(todo.getTitle());
        holder.tvTodoCompleteDate.setText(todo.getCompletedDate());

        switch (todo.getPriority()) {
            case 1:
                holder.tvTodoPriorityTitle.setText("High");
                holder.cvPriorityBg.setCardBackgroundColor(Color.parseColor("#FF0000"));
                break;
            case 2:
                holder.tvTodoPriorityTitle.setText("Medium");
                holder.cvPriorityBg.setCardBackgroundColor(Color.parseColor("#FF8A00"));
                break;
            case 3:
                holder.tvTodoPriorityTitle.setText("Low");
                holder.cvPriorityBg.setCardBackgroundColor(Color.parseColor("#00B000"));
                break;
        }

        if (todo.isCompleted()) {
            holder.ivBgImage.setVisibility(View.VISIBLE);
            holder.tvTodoPriorityTitle.setText("Completed ✅");
            holder.tvTodoCompleteDate.setVisibility(View.VISIBLE);
            Glide.with(inflater.getContext()).load(todo.getImageUrl()).centerCrop().placeholder(R.drawable.img).into(holder.ivBgImage);
        }

        holder.itemView.setOnClickListener(view -> {
            // TODO
        });

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTodoPriorityTitle, tvTodoTitle, tvTodoCompleteDate;
        MaterialCardView cvPriorityBg;
        ImageView ivBgImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTodoPriorityTitle = itemView.findViewById(R.id.tv_todo_priority);
            tvTodoTitle = itemView.findViewById(R.id.tv_todo_text);
            cvPriorityBg = itemView.findViewById(R.id.cv_priority_bg);
            tvTodoCompleteDate = itemView.findViewById(R.id.tv_todo_complete_date);
            ivBgImage = itemView.findViewById(R.id.iv_bg_image);
        }
    }
}