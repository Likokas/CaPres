package com.example.capres.adapter;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.capres.R;
import com.example.capres.model.Event;
import com.example.capres.ui.user.UserDetailActivity;

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
        final Event event = eventList.get(position);
        holder.tvPrestasi.setText(event.getPrestasi());
        if(event.getApproved().equals("0")){
            holder.tvStatus.setText("PENDING");
        }else if (event.getApproved().equals("1")){
            holder.tvStatus.setText("APPROVE");
        }else {
            holder.tvStatus.setText("DECLINE");
        }

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserDetailActivity.class);
                intent.putExtra("data", event);
                context.startActivity(intent);
                Log.e("dataevent", event.toString());
            }
        });
    }



    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPrestasi, tvStatus;
        private CardView cardview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrestasi = itemView.findViewById(R.id.tv_user_nama_prestasi);
            tvStatus = itemView.findViewById(R.id.tv_status);
            cardview = itemView.findViewById(R.id.cardViewA);
        }
    }
}