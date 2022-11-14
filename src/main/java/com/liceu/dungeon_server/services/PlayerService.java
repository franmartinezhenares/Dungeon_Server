package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;

import java.util.ArrayList;

public class PlayerService {
    public static Player createPlayer() {
        Player player = new Player();
//        player.setCurrentRoom(Maze.get);
        player.setInventory(new ArrayList<>());
        return player;
    }
}
