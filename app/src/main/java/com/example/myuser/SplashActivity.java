package com.example.myuser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.v3.BmobUser;

/**
 * Created by Asus on 2017/3/9.
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (isLogin()){
        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            delayToLogin();
        }
    }

    private void delayToLogin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    private boolean isLogin() {
        BmobUser bmobUser=BmobUser.getCurrentUser();
        if (bmobUser!=null){
            return true;
        }else {
            return false;
        }
    }
}
