package com.example.users.Interface;

import com.example.users.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("users")
    Call<List<Users>> listUsers();

}
