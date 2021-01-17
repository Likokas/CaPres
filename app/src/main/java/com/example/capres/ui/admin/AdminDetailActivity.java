package com.example.capres.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.capres.R;
import com.example.capres.model.Event;

public class AdminDetailActivity extends AppCompatActivity {

    TextView tvA_nama_prestasi, tvA_nama, tvA_nama_event, tvA_tanggal_input, tvA_link_gdrive, tvA_keterangan_event, tvA_pembimbing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_detail);


        Intent intent = getIntent();
        Event event = intent.getParcelableExtra("dataA");

        tvA_nama_prestasi = findViewById(R.id.tvA_nama_prestasi);
        tvA_nama = findViewById(R.id.tvA_nama);
        tvA_nama_event = findViewById(R.id.tvA_nama_event);
        tvA_tanggal_input = findViewById(R.id.tvA_tanggal_input);
        tvA_link_gdrive = findViewById(R.id.tvA_link_gdrive);
        tvA_keterangan_event = findViewById(R.id.tvA_keterangan_event);
        tvA_pembimbing = findViewById(R.id.tvA_pembimbing);



        tvA_nama_prestasi.setText(event.getPrestasi());
        tvA_nama.setText(event.getUser());
        tvA_nama_event.setText(event.getEvent());
        tvA_tanggal_input.setText(event.getTanggal());
        tvA_link_gdrive.setText(event.getBukti());
        tvA_keterangan_event.setText(event.getPoint());
        tvA_pembimbing.setText(event.getDosen());



    }
}