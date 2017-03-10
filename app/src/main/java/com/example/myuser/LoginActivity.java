package com.example.myuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Asus on 2017/3/9.
 */
public class LoginActivity extends AppCompatActivity{
    private EditText edtUser,edtPass;
    private Button btnLogin;
    private TextView tvRegister;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        edtUser= (EditText) findViewById(R.id.edtUser);
        edtPass= (EditText) findViewById(R.id.edtPass);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=edtUser.getText().toString().trim();
                String pass=edtPass.getText().toString().trim();
                checkLogin(user,pass);
            }
        });
        tvRegister= (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegisterActivity();
            }
        });
    }

    private void checkLogin(String user, String pass) {
        BmobUser bmobUser=new BmobUser();
        bmobUser.setUsername(user);
        bmobUser.setPassword(pass);
        bmobUser.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_SHORT).show();
                    goToMain();
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    Toast.makeText(LoginActivity.this,"fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToMain() {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToRegisterActivity() {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
