package com.example.capres.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
import com.example.capres.adapter.AdminAdapter;
import com.example.capres.model.Event;
import com.example.capres.ui.login.LoginActivity;
import com.example.capres.util.SharedPreferenceHelper;

import java.util.List;

public class AdminEventActivity extends AppCompatActivity {

    RecyclerView rv_admin;
    Button btn_logout;
    private AdminViewModel viewModel;
    private SharedPreferenceHelper helper;
    private AdminAdapter adminAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);

        rv_admin = findViewById(R.id.rv_admin);
        rv_admin.setLayoutManager(new LinearLayoutManager(AdminEventActivity.this));

        viewModel = ViewModelProviders.of(this).get(AdminViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);

        viewModel.getEvents().observe(this,observeViewModel);

        adminAdapter = new AdminAdapter(AdminEventActivity.this);

        btn_logout = findViewById(R.id.btn_admin_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.logout().observe(AdminEventActivity.this, tokenResponse -> {
                    if (tokenResponse != null){
                        helper.removeAccessToken();
                        Intent intent = new Intent(AdminEventActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(AdminEventActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
    private Observer<List<Event>> observeViewModel = new Observer<List<Event>>() {
        @Override
        public void onChanged(List<Event> events) {
            if (events != null){
                adminAdapter.setEventList(events);
                adminAdapter.notifyDataSetChanged();
                rv_admin.setAdapter(adminAdapter);
            }
        }
    };
}