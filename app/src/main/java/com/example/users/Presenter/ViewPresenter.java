package com.example.users.Presenter;

import com.example.users.Interface.ViewInterface;
import com.example.users.Model.Server;
import com.example.users.View.MainActivity;

import java.util.List;

public class ViewPresenter implements ViewInterface.Presenter{

    ViewInterface.View view;
    ViewInterface.Model model;


    public ViewPresenter(MainActivity mainActivity) {
        this.view = mainActivity;
        this.model = new Server(this);
    }

    @Override
    public void getUsers() {
        model.getUsers();
    }

    @Override
    public void showUsers() {
        view.showUsers();
    }
}
