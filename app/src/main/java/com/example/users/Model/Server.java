package com.example.users.Model;

import com.example.users.Interface.ViewInterface;
import com.example.users.Presenter.ViewPresenter;

public class Server implements ViewInterface.Model {

    ViewInterface.Presenter presenter;

    public Server(ViewPresenter viewPresenter) {
        this.presenter = viewPresenter;
    }


    @Override
    public void getUsers() {

    }
}
