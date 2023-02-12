package com.example.users.Interface;

import java.util.List;

public interface ViewInterface {

    interface View {

        void getUsers();

        void showUsers();
    }

    interface Presenter {

        void getUsers();


        void showUsers();

    }

    interface Model {

        void getUsers();

    }


}