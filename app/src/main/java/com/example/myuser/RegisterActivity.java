package com.example.myuser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Asus on 2017/3/10.
 */

public class RegisterActivity extends AppCompatActivity{
    private EditText edtRegisterUser,edtRegisterPass,edtRegisterPassAgain;
    private Button btnRegister;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    private void initViews() {
        edtRegisterUser= (EditText) findViewById(R.id.edtRegisterUser);
        edtRegisterPass= (EditText) findViewById(R.id.edtRegisterPass);
        edtRegisterPassAgain= (EditText) findViewById(R.id.edtRegisterPassAgain);
        btnRegister= (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=edtRegisterUser.getText().toString().trim();
                String pass=edtRegisterPass.getText().toString().trim();
                String passAgain=edtRegisterPassAgain.getText().toString().trim();
                checkRegister(user,pass,passAgain);
            }
        });
    }

    private void checkRegister(String user, String pass, String passAgain) {
        if (pass.equals(passAgain)){
            BmobUser bmobUser=new BmobUser();
            bmobUser.setUsername(user);
            bmobUser.setPassword(pass);
            bmobUser.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser s, BmobException e) {
                    if(e==null){
                        Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this,"fail",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
            Toast.makeText(RegisterActivity.this,"密码不一致",Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
