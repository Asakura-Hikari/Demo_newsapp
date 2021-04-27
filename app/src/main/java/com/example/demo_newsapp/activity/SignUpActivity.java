package com.example.demo_newsapp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo_newsapp.R;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name_signup, password_signup, password_signup_con;
    private Button signup_btn, toLogin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    public void init(){
//        Bomb Initialization
        Bmob.initialize(this,"988ae71f79851ac817431bee093c1279");
        name_signup = findViewById(R.id.name_signup);
        password_signup = findViewById(R.id.password_signup);
        password_signup_con = findViewById(R.id.password_signup_con);
        signup_btn = findViewById(R.id.signup_btn);
        toLogin_btn = findViewById(R.id.toLogin_btn);
        signup_btn.setOnClickListener(this);
        toLogin_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_btn:
                signupUser(name_signup.getText().toString(), password_signup.getText().toString());
                break;
            case R.id.toLogin_btn:
                toLoginUser(name_signup.getText().toString(), password_signup.getText().toString());
        }
    }

    private void signupUser(String nameSignUp, String passwordSignUp){
        BmobUser user = new BmobUser();
        user.setUsername(nameSignUp);
        user.setPassword(passwordSignUp);
        user.signUp(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(SignUpActivity.this,bmobUser.getUsername()+"Sign up successfully",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SignUpActivity.this, "Sign up failed：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void toLoginUser(String nameSignUp, String passwordSignUp){
        BmobUser user = new BmobUser();
        user.setUsername(nameSignUp);
        user.setPassword(passwordSignUp);
        user.signUp(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(SignUpActivity.this,bmobUser.getUsername()+"Sign up successfully",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SignUpActivity.this, "Sign up failed：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}