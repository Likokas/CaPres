package com.example.capres.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.capres.R;
import com.example.capres.model.Event;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<Event> eventList;

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvPrestasi.setText(event.getPrestasi());
        if (event.getApproved().equals("0")){
            holder.tvStatus.setText("Pending");
        }else if (event.getApproved().equals("1")){
            holder.tvStatus.setText("Approve");
        }else {
            holder.tvStatus.setText("Decline");
        }
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPrestasi, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrestasi = itemView.findViewById(R.id.tv_user_nama_prestasi);
            tvStatus = itemView.findViewById(R.id.tv_status);

        }
    }
}