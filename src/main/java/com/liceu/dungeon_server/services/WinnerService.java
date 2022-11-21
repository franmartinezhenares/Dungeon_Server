package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.DAO.MySQL.WinnerDAOMySQL;
import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerService {
    WinnerDAO winnerDAO = new WinnerDAOMySQL();

    public void createWinner(String name, String mazeName, long time) {
        Winner winner = new Winner();
        winner.setWinnerName(name);
        winner.setMazeSolved(mazeName);
        winner.setTime(time);
        winnerDAO.insert(winner);
    }

    public List<Winner> getAllWinners() {
        List<Winner> winList = winnerDAO.getWinnersList();
        Collections.sort(winList);
        return winList;
    }

    public String formatTime(long timeInMs) {
        int minutes = (int)Math.floor(timeInMs/60000);
        int seconds = (int)Math.floor((timeInMs/1000) - (minutes*60));
        String minutesStr = "" + minutes;
        String secondsStr = "" + seconds;
        if(minutes < 10) minutesStr = "0" + minutes;
        if(seconds < 10) secondsStr = "0" + seconds;

        return minutesStr + "'" + secondsStr + '"';
    }



}
