package com.example.users.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.users.Interface.ViewInterface;
import com.example.users.Model.Users;
import com.example.users.Presenter.ViewPresenter;
import com.example.users.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewInterface.View {

    ViewInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ViewPresenter(this);
        getUsers();
    }


    @Override
    public void getUsers() {
        presenter.getUsers();
    }

    @Override
    public void showUsers(List<Users> list1) {
    }
}