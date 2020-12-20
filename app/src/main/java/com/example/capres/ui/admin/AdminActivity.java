package com.example.capres.ui.admin;

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
import com.example.capres.ui.login.LoginActivity;
import com.example.capres.ui.login.LoginViewModel;
import com.example.capres.ui.user.UserActivity;
import com.example.capres.util.SharedPreferenceHelper;

public class AdminActivity extends AppCompatActivity {

    Button btn_logout;
    private AdminViewModel viewModel;
    private SharedPreferenceHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);

        viewModel = ViewModelProviders.of(this).get(AdminViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);

        btn_logout = findViewById(R.id.btn_admin_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.logout().observe(AdminActivity.this, tokenResponse -> {
                    if (tokenResponse != null){
                        helper.removeAccessToken();
                        Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(AdminActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}