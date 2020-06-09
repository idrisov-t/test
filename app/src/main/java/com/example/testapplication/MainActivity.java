package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tvLogin, tvText;
    ImageView image;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUsers();
    }

    public void loadUsers(){
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        tvLogin = findViewById(R.id.login_item_recycler_view);
        tvText = findViewById(R.id.text_item_recycler_view);
        image = findViewById(R.id.image_item_recycler_view);

        NetworkRequest.getRequest()
                .getGithubApi()
                .getGithubModel()
                .enqueue(new Callback<ArrayList<GithubModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GithubModel>> call, Response<ArrayList<GithubModel>> response) {
                        ArrayList<GithubModel> githubModels = response.body();

                        usersAdapter = new UsersAdapter(MainActivity.this, githubModels);
                        recyclerView.setAdapter(usersAdapter);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<GithubModel>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Не удалось", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

//