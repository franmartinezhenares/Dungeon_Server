package com.liceu.dungeon_server.DAO.MySQL;

import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerDAOMySQL implements WinnerDAO {
    public static List<Winner> winnersList = new ArrayList<>();
    @Override
    public void insert(Winner winner) {
        winnersList.add(winner);
    }

    @Override
    public List<Winner> getWinnersList() {
        Collections.sort(winnersList);
        return winnersList;
    }
}
