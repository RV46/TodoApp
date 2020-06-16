package com.example.easy_todo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MvvmViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> userLiveData;
    ArrayList<User> userArrayList;

    public MvvmViewModel() {
        userLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        populateList();
        userLiveData.setValue(userArrayList);
    }

    public void populateList(){

        User user = new User();
        user.setTitle(" App Info and contact ");
        user.setDescription(" Easy Todo " +
                "\n Created By: RAVI G " +
                "\n Added fully Crud Operations " +
                "\n Login and Registration with some validation " +
                "\n Contact: rv46@tbc.edu.np");
        user.setDescription2("© 2020 Ravi G. EasyTodo All Rights Reserved.");
        userArrayList = new ArrayList<>();
        userArrayList.add(user);

    }
}