package com.example.logbooklimaapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logbooklimaapplication.model.Sprint;

import java.util.ArrayList;

public class SprintAdapter extends RecyclerView.Adapter<SprintAdapter.CategoryViewHolder> {

    private final Context context;
    private ArrayList<Sprint> listSprint;

    public SprintAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Sprint> getListSprint() {
        return listSprint;
    }

    public void setListSprint(ArrayList<Sprint> listSprint) {
        this.listSprint = listSprint;
    }

    @NonNull
    @Override
    public SprintAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sprint, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull SprintAdapter.CategoryViewHolder holder, final int position) {
        holder.tvTitle.setText(getListSprint().get(position).getTitle());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Sprint sprint = getListSprint().get(position);
//                Intent intent = new Intent(context, MainActivity.class);
////                intent.putExtra(DetailSprintActivity.EXTRA_MOVIE, sprint);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return getListSprint().size();
    }

    public class CategoryViewHolder  extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
