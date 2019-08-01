package com.example.ilealnod.mvvmproject;

import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ilealnod.mvvmproject.Commands.userLogin;
import com.example.ilealnod.mvvmproject.ViewModel.UserModel;
import com.example.ilealnod.mvvmproject.databinding.ActivityMainBinding;
import com.example.ilealnod.mvvmproject.model.User;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserModel userModel = new UserModel(new User("Email", "Password"));
        activityMainBinding.setLogin(userModel);
        activityMainBinding.setUserloginevent(new userLogin() {
            @Override
            public void onClickLogin() {
                Toast.makeText(MainActivity.this,""+activityMainBinding.getLogin().getEmail(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}