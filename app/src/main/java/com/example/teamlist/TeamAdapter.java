package com.example.teamlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TeamModel> teamModels;
    private RecyclerViewClickListener listener;


    public TeamAdapter(Context context, RecyclerViewClickListener listener) {
        this.context = context;
    }

    public ArrayList<TeamModel> getTeamModels() {
        return teamModels;
    }

    public void setTeamModels(ArrayList<TeamModel> teamModels, RecyclerViewClickListener listener) {
        this.teamModels = teamModels;
        this.listener = listener;
    }

    @NonNull
    @Override

    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(getTeamModels().get(position).getGambarTeam()).into(holder.gambar);
        holder.text.setText(getTeamModels().get(position).getNamaTeam());
    }

    @Override
    public int getItemCount() {
        return getTeamModels().size();
    }

    public void setTeamModels(ArrayList<TeamModel> listTeam) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView gambar;
        private TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.cetak_Gambar);
            text = itemView.findViewById(R.id.cetak_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
        listener.onClick(itemView, getAdapterPosition());
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}
