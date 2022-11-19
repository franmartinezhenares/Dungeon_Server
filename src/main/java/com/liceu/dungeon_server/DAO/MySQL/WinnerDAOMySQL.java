package com.liceu.dungeon_server.DAO.MySQL;

import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.util.ArrayList;
import java.util.List;

public class WinnerDAOMySQL implements WinnerDAO {
    public static List<Winner> winnersList = new ArrayList<>();
    @Override
    public void create(Winner winner) {
        winnersList.add(winner);
    }

    @Override
    public List<Winner> getWinnersList() {
        return winnersList;
    }
}
