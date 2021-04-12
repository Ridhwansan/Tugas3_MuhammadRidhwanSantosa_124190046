package com.example.teamlist;

import java.util.ArrayList;

public class TeamData {
    private static String[] nama = new String[]{"Team Nigma","Team Alliance","Team Evil Geniuses","Team OG","Team Secret","Team Na'vi"};

    private static int [] gambar = new int[]{R.drawable.nigma,R.drawable.alliance,R.drawable.evil,R.drawable.og,
            R.drawable.secret,R.drawable.navi};
    public static ArrayList<TeamModel> getListData(){
        TeamModel teamModel = null;
        ArrayList<TeamModel> list = new ArrayList<TeamModel>();
        for (int i = 0;i<nama.length;i++){
            teamModel = new TeamModel();
            teamModel.setGambarTeam(gambar[i]);
            teamModel.setNamaTeam(nama[i]);
            list.add(teamModel);
        }
        return list;
    }
}
