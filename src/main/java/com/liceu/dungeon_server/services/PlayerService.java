package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;

import java.util.ArrayList;

public class PlayerService {
    public static Player createPlayer(Room startRoom) {
        Player player = new Player();
        player.setCurrentRoom(startRoom);
        player.setInventory(new ArrayList<>());
        return player;
    }
}
