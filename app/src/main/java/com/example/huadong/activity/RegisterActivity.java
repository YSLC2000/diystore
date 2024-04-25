package com.example.huadong.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.huadong.R;
import com.example.huadong.been.DataInfo;
import com.example.huadong.untils.OrderDataBase;

public class RegisterActivity extends AppCompatActivity {
    private EditText eEtUsername;
    private EditText eEtPassword;
    private EditText eEtRepassword;
    private Button eBtnRegister;
    private Toolbar back;
    private DataInfo s=new DataInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        Event();
        s.dataInfo(RegisterActivity.this);
    }

    private void init() {
        eEtUsername = findViewById(R.id.id_et_username);
        eEtRepassword = findViewById(R.id.id_et_repassword);
        eEtPassword = findViewById(R.id.id_et_password);
        eBtnRegister = findViewById(R.id.id_btn_register);
        back =findViewById(R.id.toolbar_back);
    }

    /**
     * 注册逻辑
     */
    private void Event() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        eBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(RegisterActivity.this, "点击了这里", Toast.LENGTH_SHORT).show();
                String username = eEtUsername.getText().toString();
                String password = eEtPassword.getText().toString();
                String rePassword = eEtRepassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!rePassword.equals(password)){
                    Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    int row = OrderDataBase.getInstance(RegisterActivity.this).register(username,password);
                    if(row > 0){
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });
    }
}