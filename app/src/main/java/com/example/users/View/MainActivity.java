package com.example.users.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.users.Interface.ViewInterface;
import com.example.users.Model.Users;
import com.example.users.Presenter.ViewPresenter;
import com.example.users.R;
import com.example.users.View.Adapter.UserAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, ViewInterface.View {

    androidx.appcompat.widget.SearchView searchView;
    ViewInterface.Presenter presenter;
    RecyclerView recyclerView;
    UserAdapter listAdapter;
    ProgressBar progressBar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recyclerUsers);
        progressBar = findViewById(R.id.progressbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        presenter = new ViewPresenter(this);
        searchView.setOnQueryTextListener(this);

        registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private final BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

            if (isConnected)
                getUsers();
        }
    };


    @Override
    public void getUsers() {
        presenter.getUsers();
    }

    @Override
    public void showUsers(List<Users> list) {
        progressBar.setVisibility(View.GONE);
        listAdapter = new UserAdapter(list, this);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String text) {
        listAdapter.filterUser(text);
        return false;
    }
}