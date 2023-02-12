package com.example.users.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recyclerUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        presenter = new ViewPresenter(this);
        searchView.setOnQueryTextListener(this);

        getUsers();
    }


    @Override
    public void getUsers() {
        presenter.getUsers();
    }

    @Override
    public void showUsers(List<Users> list) {
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