package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterViewHolder> {

    Context context;
    ArrayList<GithubModel> arrayList;

    public UsersAdapter(Context context, ArrayList<GithubModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public UsersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new UsersAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterViewHolder holder, int position) {
        GithubModel model = arrayList.get(position);
        holder.tvLogin.setText(model.getLogin());
        holder.tvText.setText(model.getReposUrl());

        Picasso.with(context).load(model.getAvatarUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class UsersAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvLogin, tvText;

        public UsersAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_item_recycler_view);
            tvLogin = itemView.findViewById(R.id.login_item_recycler_view);
            tvText = itemView.findViewById(R.id.text_item_recycler_view);
        }
    }
}
