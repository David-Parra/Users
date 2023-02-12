package com.example.users.Model;

import static com.example.users.Model.UsersClient.getClient;

import androidx.annotation.NonNull;

import com.example.users.Interface.ViewInterface;
import com.example.users.Interface.WebService;
import com.example.users.Presenter.ViewPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Server implements ViewInterface.Model {

    ViewInterface.Presenter presenter;

    public Server(ViewPresenter viewPresenter) {
        this.presenter = viewPresenter;
    }


    @Override
    public void getUsers() {

        WebService service = getClient().create(WebService.class);
        Call<List<Users>> usersCall = service.listUsers();

        usersCall.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(@NonNull Call<List<Users>> call, @NonNull Response<List<Users>> response) {
                List<Users> list1;
                list1 = response.body();
                presenter.showUsers(list1);
            }

            @Override
            public void onFailure(@NonNull Call<List<Users>> call, @NonNull Throwable t) {
            }
        });
    }
}
