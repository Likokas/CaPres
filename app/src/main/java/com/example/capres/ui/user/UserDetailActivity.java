package com.example.capres.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.capres.R;
import com.example.capres.model.Event;

public class UserDetailActivity extends AppCompatActivity {
    TextView tvnama, tvnamaevent, tvtanggal, tvpembimbing, tvketeranganevent, tvlinkgdrive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_detail);
        Intent intent = getIntent();
        Event event = intent.getParcelableExtra("data");

        Log.e("datanya", event.getEvent());

        tvnama = findViewById(R.id.tvA_nama);
        tvnamaevent= findViewById(R.id.tvA_nama_event);
        tvtanggal= findViewById(R.id.tvA_tanggal_input);
        tvpembimbing= findViewById(R.id.tvA_pembimbing);
        tvketeranganevent= findViewById(R.id.tvA_keterangan_event);
        tvlinkgdrive= findViewById(R.id.tvA_link_gdrive);


        tvnama.setText(event.getUser());
        tvnamaevent.setText(event.getEvent());
        tvtanggal.setText(event.getTanggal());
        tvpembimbing.setText(event.getDosen());
        tvketeranganevent.setText(event.getPoint());
        tvlinkgdrive.setText(event.getBukti());

    }


}