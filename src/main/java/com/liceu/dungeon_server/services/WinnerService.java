package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.DAO.MySQL.WinnerDAOMySQL;
import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    WinnerDAO winnerDAO = new WinnerDAOMySQL();

    public void createWinner(String name, int mazeID, String time) {
        Winner winner = new Winner();
        winner.setWinnerName(name);
        winner.setMazeSolved(mazeID);
        winner.setTime(time);
        winnerDAO.create(winner);
    }

    public List<Winner> getAllWinners() {
        return winnerDAO.getWinnersList();
    }



}
