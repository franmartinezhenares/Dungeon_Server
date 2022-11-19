package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {


    List<Winner> winnersList = new ArrayList<>();

    public void createWinner(String name, int mazeID, String time) {
        Winner winner = new Winner();
        winner.setWinnerName(name);
        winner.setMazeSolved(mazeID);
        winner.setTime(time);
        winnersList.add(winner);
    }

    public List<Winner> getWinnersList() {
        return winnersList;
    }

    public void setWinnersList(List<Winner> winnersList) {
        this.winnersList = winnersList;
    }

}
