package com.example.capres.adapter;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.capres.R;
import com.example.capres.model.Event;
import com.example.capres.ui.admin.AdminDetailActivity;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ViewHolder> {

    private Context context;
    private List<Event> eventList;

    public AdminAdapter(Context context) {
        this.context = context;
    }

    public void setEventList(List<Event> eventList) { //menyimpan data yang dikirim
        this.eventList = eventList;
        notifyDataSetChanged();//deteksi perubahan data
    }

    @NonNull
    @Override
    public AdminAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //yang mengatur output cardview
        View view = LayoutInflater.from(context).inflate(R.layout.admin_adapter, parent, false);
        return new AdminAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.ViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvAPrestasi.setText(event.getPrestasi());
        if (event.getApproved().equals("1")){
            holder.btn_approve.setVisibility(View.INVISIBLE);
            holder.btn_decline.setVisibility(View.INVISIBLE);
        }else if (event.getApproved().equals("2")){
            holder.btn_approve.setVisibility(View.INVISIBLE);
            holder.btn_decline.setVisibility(View.INVISIBLE);
        }else if (event.getApproved().equals("0")){
            holder.btn_approve.setVisibility(View.VISIBLE);
            holder.btn_decline.setVisibility(View.VISIBLE);
        }

        holder.cardviewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminDetailActivity.class);
                intent.putExtra("dataA", event);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAPrestasi, tvStatus;
        private ImageButton btn_approve, btn_decline;
        private CardView cardviewA;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAPrestasi = itemView.findViewById(R.id.tv_admin_nama_prestasi);
            cardviewA = itemView.findViewById(R.id.cardViewA);
            btn_approve = itemView.findViewById(R.id.ib_approve);
            btn_decline = itemView.findViewById(R.id.ib_decline);

        }
    }
}