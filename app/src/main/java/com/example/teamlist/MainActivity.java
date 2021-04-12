package com.example.teamlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCetak;
    private ArrayList<TeamModel> listTeam = new ArrayList<>();
    private TeamAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCetak = findViewById(R.id.mainRV);
        rvCetak.setHasFixedSize(true);
        listTeam.addAll(TeamData.getListData());

        showRecyclerList();

    }

    private void showRecyclerList() {
        setOnClickListener();
        rvCetak.setLayoutManager(new LinearLayoutManager(this));
        TeamAdapter teamAdapter = new TeamAdapter(this,listener);
        teamAdapter.setTeamModels(listTeam);
        rvCetak.setAdapter(teamAdapter);

    }

    private void setOnClickListener() {
        listener = new TeamAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                intent.putExtra("nama",listTeam.get(position).getNamaTeam());
                startActivity(intent);
            }
        };
    }
}