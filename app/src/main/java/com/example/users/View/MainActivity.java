package com.example.users.View;

import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity implements ViewInterface.View {

    ViewInterface.Presenter presenter;
    RecyclerView recyclerView;
    UserAdapter listAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        presenter = new ViewPresenter(this);
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
}