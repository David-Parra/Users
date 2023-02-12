package com.example.users.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.users.Model.Users;
import com.example.users.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<Users> mData;
    private List<Users> usersList;

    public UserAdapter(List<Users> list, Context context) {
        this.context = context;
        mData = list;
        this.mInflater = LayoutInflater.from(context);

        usersList = new ArrayList<>();
        usersList.addAll(mData);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardview_users, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Users item = mData.get(position);
        String id = "ID: "+item.getId();

        holder.email.setText(item.getEmail());
        holder.name.setText(item.getName());
        holder.username.setText(item.getUsername());
        holder.phone.setText(item.getPhone());
        holder.website.setText(item.getWebsite());
        holder.userid.setText(id);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, username, email, phone, website, userid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            userid = itemView.findViewById(R.id.userid);
        }
    }

}
