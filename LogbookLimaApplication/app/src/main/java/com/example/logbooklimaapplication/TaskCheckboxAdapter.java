package com.example.logbooklimaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logbooklimaapplication.model.Task;

import java.util.ArrayList;

public class TaskCheckboxAdapter extends RecyclerView.Adapter<TaskCheckboxAdapter.CategoryViewHolder>{

    private final Context context;
    private ArrayList<Task> listTask;

    public TaskCheckboxAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public void setListTask(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    @NonNull
    @Override
    public TaskCheckboxAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_taskcheckbox, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskCheckboxAdapter.CategoryViewHolder holder, int position) {
        holder.taskCheck.setText(getListTask().get(position).getNamaTask());
        holder.taskCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTask().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        CheckBox taskCheck;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCheck = itemView.findViewById(R.id.checkbox_task);
        }
    }
}
