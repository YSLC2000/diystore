package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huadong.R;
import com.example.huadong.been.UserInfo;
import com.example.huadong.untils.OrderDataBase;

public class LoginActivity extends AppCompatActivity {
    private EditText etn_username;
    private EditText etn_password;
    private Button button;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etn_username.getText().toString();
                String password = etn_password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    UserInfo login_enter_name = OrderDataBase.getInstance(LoginActivity.this).login(user);
                    if (login_enter_name != null) {
                        if (user.equals(login_enter_name.getUsername()) && password.equals(login_enter_name.getPassword())) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            UserInfo.setsUserInfo(login_enter_name);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "账户或者密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private void init() {
        register = findViewById(R.id.id_tv_register);
        button = findViewById(R.id.id_btn_login);
        etn_password = findViewById(R.id.id_et_password);
        etn_username = findViewById(R.id.id_et_username);
    }

}