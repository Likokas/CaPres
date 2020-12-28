package com.example.capres.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.capres.R;
import com.example.capres.adapter.UserAdapter;
import com.example.capres.model.Event;
import com.example.capres.ui.admin.AdminActivity;
import com.example.capres.ui.admin.AdminViewModel;
import com.example.capres.ui.login.LoginActivity;
import com.example.capres.util.SharedPreferenceHelper;

import java.util.List;

public class UserActivity extends AppCompatActivity {

    RecyclerView rv_user;
    Button btn_logout;
    private UserAdapter adapterUser;
    private UserViewModel viewModel;
    private SharedPreferenceHelper helper;
//    List<Event>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);

//        rv_user = findViewById(R.id.rv_user);
//        rv_user.setLayoutManager(new LinearLayoutManager(UserActivity.this));
//        UserAdapter userAdapter = new UserAdapter(UserActivity.this);
//        userAdapter.setEventList(list);
//        rv_user.setAdapter(userAdapter);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);

        btn_logout = findViewById(R.id.btn_user_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.logout().observe(UserActivity.this, tokenResponse -> {
                    if (tokenResponse != null){
                        helper.removeAccessToken();
                        Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(UserActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}