package com.example.hang.recycleviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Contributor> contributors;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public CircleImageView profileImage;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.contributor_name);
            description = v.findViewById(R.id.contributor_description);
            profileImage = v.findViewById(R.id.contributor_profile_image);
        }
    }

    public MyAdapter(List<Contributor> data) {
        contributors = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_about_contributor, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contributor con = contributors.get(position);
        holder.name.setText(con.getName());
        holder.description.setText(con.getDescription());
        holder.profileImage.setImageResource(con.getProfileImage());
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }
}
