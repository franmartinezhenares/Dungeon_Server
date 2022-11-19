package com.liceu.dungeon_server.DAO;

import com.liceu.dungeon_server.model.Winner;

import java.util.List;

public interface WinnerDAO {

    public void insert(Winner winner);

    public List<Winner> getWinnersList();
}
