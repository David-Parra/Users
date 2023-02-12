package com.example.users.Interface;

import com.example.users.Model.Users;

import java.util.List;

public interface ViewInterface {

    interface View {

        void getUsers();

        void showUsers(List<Users> list1);
    }

    interface Presenter {

        void getUsers();


        void showUsers(List<Users> list1);

    }

    interface Model {

        void getUsers();

    }


}