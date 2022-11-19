package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.DAO.MySQL.WinnerDAOMySQL;
import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    WinnerDAO winnerDAO = new WinnerDAOMySQL();

    public void createWinner(String name, int mazeID, long time) {
        Winner winner = new Winner();
        winner.setWinnerName(name);
        winner.setMazeSolved(mazeID);
        winner.setTime(time);
        winnerDAO.insert(winner);
    }

    public List<Winner> getAllWinners() {
        return winnerDAO.getWinnersList();
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
