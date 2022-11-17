package com.liceu.dungeon_server.utils;

import com.liceu.dungeon_server.model.*;
import com.liceu.dungeon_server.services.KeyService;
import org.json.simple.JSONObject;

public class GameUtils {

    KeyService keyService = new KeyService();

    public Maze createMaze(int mazeID) {
        BuilderUtils builderUtils = new BuilderUtils();

        switch (mazeID) {
            case 1:

                for (int i = 1; i <= 3 ; i++) {
                    builderUtils.buildRoom(i);
                }
                Key bronzeKey = keyService.createKey("bronzeKey");

                builderUtils.buildCorridor(1, 2, Maze.Directions.EAST);
                builderUtils.buildDoor(2, 3, Maze.Directions.SOUTH);
                builderUtils.putKeyInRoom(2, bronzeKey);
                builderUtils.putCoinsInRoom(2);

                builderUtils.setExit(3);

                break;

            case 2:
                System.out.println("No disponible");
        }


        return builderUtils.getMaze();

    }

    public void go(Player player, Maze.Directions direction) {
        Room room = player.getCurrentRoom();
        RoomSide roomSide = room.getDirection(direction);
        roomSide.enter(player);
    }

    public String getJsonInfo(Room room, Player player) {
        JSONObject root = new JSONObject();
        JSONObject roomInfo = new JSONObject();
        roomInfo.put("N", room.getDirection(Maze.Directions.NORTH).toString());
        roomInfo.put("S", room.getDirection(Maze.Directions.SOUTH).toString());
        roomInfo.put("E", room.getDirection(Maze.Directions.EAST).toString());
        roomInfo.put("W", room.getDirection(Maze.Directions.WEST).toString());
        root.put("walls", roomInfo);

        JSONObject roomItems = new JSONObject();

        if(room.hasKey()) {
            roomItems.put("Key", room.getKey().toString());
        }
        if(room.hasCoin()) {
            roomItems.put("Coin", room.getCoin().toString());
        }
        root.put("item", roomItems);

        JSONObject playerInfo = new JSONObject();
        playerInfo.put("currentRoom", player.getCurrentRoom().getRoomID());
//        player.put("Inventory", "[...]");
        root.put("player", playerInfo);
//        JSONArray inventory = new JSONArray();
//        inventory.add("llave");
//        inventory.add("llave");
//        inventory.add("llave");
//        player.put("Inventory", inventory);

        return root.toJSONString();
    }

}
