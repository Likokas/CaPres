package com.example.capres.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.capres.R;
import com.example.capres.ui.admin.AdminEventActivity;
import com.example.capres.ui.user.UserEventActivity;
import com.example.capres.util.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    Button btn_loginAsAdmin;
    TextInputLayout emailTIL, passwordTIL;

    private LoginViewModel viewModel;
    private SharedPreferenceHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);

        btn_login = findViewById(R.id.btn_login);
        btn_loginAsAdmin = findViewById(R.id.btn_loginAsAdmin);
        emailTIL = findViewById(R.id.til_email);
        passwordTIL = findViewById(R.id.til_pass);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailTIL.getEditText().getText().toString().trim().isEmpty() && !passwordTIL.getEditText().getText().toString().trim().isEmpty()){
                    String email = emailTIL.getEditText().getText().toString().trim();
                    String password = passwordTIL.getEditText().getText().toString().trim();
                    viewModel.login(email,password).observe(LoginActivity.this, tokenResponse -> {
                        if (tokenResponse != null){
                            helper.saveAccessToken(tokenResponse.getAccessToken());
                            Intent intent = new Intent(LoginActivity.this, UserEventActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        btn_loginAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emailTIL.getEditText().getText().toString().trim().isEmpty() && !passwordTIL.getEditText().getText().toString().trim().isEmpty()){
                    String email = emailTIL.getEditText().getText().toString().trim();
                    String password = passwordTIL.getEditText().getText().toString().trim();
                    viewModel.loginAdmin(email,password).observe(LoginActivity.this, tokenResponse -> {
                        if (tokenResponse != null){
                            helper.saveAccessToken(tokenResponse.getAccessToken());
                            Intent intent = new Intent(LoginActivity.this, AdminEventActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}