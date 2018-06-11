package com.example.hang.recycleviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Contributor> contributors;
    private ContactListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public CircleImageView profileImage;
        public LinearLayout contribContacts;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.contributor_name);
            description = v.findViewById(R.id.contributor_description);
            profileImage = v.findViewById(R.id.contributor_profile_image);
            contribContacts = v.findViewById(R.id.contributor_contacts);
        }
    }

    public MyAdapter(List<Contributor> data, ContactListener listener) {
        contributors = data;
        this.listener = listener;
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

        holder.contribContacts.removeAllViews();
        if (con.getEmail() != null) {
            ContactButton email = new ContactButton(holder.itemView.getContext());
            email.setText(holder.itemView.getContext().getString(R.string.send_email));
            email.bold();
            email.setOnClickListener(v -> listener.onMailClicked(con.getEmail()));
            holder.contribContacts.addView(email);
        }

        ArrayList<Contact> contacts = con.getContacts();
        for (Contact contact : contacts) {
            ContactButton c = new ContactButton(holder.itemView.getContext());
            c.setText(contact.getLabel());
            c.setOnClickListener(v -> listener.onContactClicked(contact));
            holder.contribContacts.addView(c);
        }
    }

    @Override
    public int getItemCount() {
        return contributors.size();
    }
}
