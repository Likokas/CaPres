package com.example.capres.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.capres.R;
import com.example.capres.adapter.UserAdapter;
import com.example.capres.model.Event;
import com.example.capres.ui.login.LoginActivity;
import com.example.capres.util.SharedPreferenceHelper;

import java.util.List;

public class UserEventActivity extends AppCompatActivity {

    RecyclerView rv_user;
    Button btn_logout;
    private UserViewModel viewModel;
    private SharedPreferenceHelper helper;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);

        rv_user = findViewById(R.id.rv_user);
        rv_user.setLayoutManager(new LinearLayoutManager(UserEventActivity.this));
        userAdapter = new UserAdapter(UserEventActivity.this);



        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);

        viewModel.getEvents().observe(this,observeViewModel);

        btn_logout = findViewById(R.id.btn_user_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.logout().observe(UserEventActivity.this, tokenResponse -> {
                    if (tokenResponse != null){
                        helper.removeAccessToken();
                        Intent intent = new Intent(UserEventActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(UserEventActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private Observer<List<Event>> observeViewModel = new Observer<List<Event>>() {
        @Override
        public void onChanged(List<Event> events) {
            if (events != null){
                userAdapter.setEventList(events);
                userAdapter.notifyDataSetChanged();
                rv_user.setAdapter(userAdapter);
                Log.e("data1", events.toString());
            }
        }
    };
}