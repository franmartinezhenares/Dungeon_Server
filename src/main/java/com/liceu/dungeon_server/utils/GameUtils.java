package com.liceu.dungeon_server.utils;

import com.liceu.dungeon_server.model.*;
import com.liceu.dungeon_server.services.KeyService;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GameUtils {

    KeyService keyService = new KeyService();

    public Maze createMaze(int mazeID) {
        BuilderUtils builderUtils = new BuilderUtils();
        Key bronzeKey = keyService.createKey("bronzeKey", 1);
        Key silverKey = keyService.createKey("silverKey", 2);
        Key goldKey = keyService.createKey("goldKey", 2);

        switch (mazeID) {
            case 1:

                builderUtils.setMazeID(1);
                builderUtils.setMazeName("Tutorial Maze");

                for (int i = 1; i <= 6 ; i++) {
                    builderUtils.buildRoom(i);
                }

                builderUtils.buildCorridor(1, 2, Maze.Directions.WEST);
                builderUtils.buildDoor(2, 3, Maze.Directions.WEST, bronzeKey);
                builderUtils.buildCorridor(3, 4, Maze.Directions.WEST);
                builderUtils.buildDoor(4, 5, Maze.Directions.WEST, silverKey);
                builderUtils.buildDoor(5, 6, Maze.Directions.WEST, goldKey);

                builderUtils.putKeyInRoom(2, bronzeKey);
                builderUtils.putKeyInRoom(4, silverKey);
                builderUtils.putKeyInRoom(5, goldKey);
                builderUtils.putCoinInRoom(1);
                builderUtils.putCoinInRoom(2);
                builderUtils.putCoinInRoom(3);
                builderUtils.putCoinInRoom(4);
                builderUtils.putCoinInRoom(5);

                builderUtils.setExit(6);

                break;

            case 2:
                builderUtils.setMazeID(2);
                builderUtils.setMazeName("Peres Maze");

                for (int i = 1; i <= 6 ; i++) {
                    builderUtils.buildRoom(i);
                }
                builderUtils.buildCorridor(1, 5, Maze.Directions.EAST);
                builderUtils.buildCorridor(1, 2, Maze.Directions.NORTH);
                builderUtils.putKeyInRoom(2, bronzeKey);
                builderUtils.buildCorridor(1, 4, Maze.Directions.SOUTH);
                builderUtils.buildDoor(5, 6, Maze.Directions.EAST, bronzeKey);
                builderUtils.putKeyInRoom(6, silverKey);
                builderUtils.buildDoor(1, 3, Maze.Directions.WEST, silverKey);
                builderUtils.putCoinInRoom(1);
                builderUtils.putCoinInRoom(4);
                builderUtils.putCoinInRoom(6);

                builderUtils.setExit(3);
                break;

            case 3:
                builderUtils.setMazeID(3);
                builderUtils.setMazeName("Mad Fran Maze");

                for (int i = 1; i <= 14 ; i++) {
                    builderUtils.buildRoom(i);
                }
                builderUtils.buildCorridor(1, 2, Maze.Directions.EAST);
                builderUtils.buildCorridor(2, 3, Maze.Directions.EAST);
                builderUtils.buildCorridor(3, 6, Maze.Directions.SOUTH);
                builderUtils.buildCorridor(6, 7, Maze.Directions.EAST);
                builderUtils.buildCorridor(7, 4, Maze.Directions.NORTH);
                builderUtils.buildCorridor(7, 10, Maze.Directions.EAST);
                builderUtils.putKeyInRoom(3, bronzeKey);
                builderUtils.buildDoor(1, 5, Maze.Directions.SOUTH, bronzeKey);
                builderUtils.buildCorridor(5, 8, Maze.Directions.SOUTH);
                builderUtils.buildCorridor(8, 9, Maze.Directions.EAST);
                builderUtils.putKeyInRoom(7, silverKey);
                builderUtils.buildDoor(10, 14, Maze.Directions.EAST, silverKey);
                builderUtils.buildCorridor(14, 13, Maze.Directions.WEST);
                builderUtils.buildCorridor(13, 12, Maze.Directions.WEST);
                builderUtils.putKeyInRoom(14, goldKey);
                builderUtils.buildDoor(12, 11, Maze.Directions.WEST, goldKey);
                builderUtils.putCoinInRoom(2);
                builderUtils.putCoinInRoom(4);
                builderUtils.putCoinInRoom(7);
                builderUtils.putCoinInRoom(8);
                builderUtils.putCoinInRoom(9);
                builderUtils.putCoinInRoom(12);

                builderUtils.setExit(11);
                break;
        }


        return builderUtils.getMaze();

    }

    public String go(Player player, Maze.Directions direction) {
        Room room = player.getCurrentRoom();
        RoomSide roomSide = room.getDirection(direction);
        return roomSide.enter(player);
    }

    public long endGame(Room room, Player player, long startTime) {
        if (room.isExit()) {
            Date date = new Date();
            long endTime = date.getTime();
            long totalTime = endTime - startTime;
            player.setWinner(true);
            return totalTime;
        }
        return 0;
    }

    public String getJsonInfo(Room room, Player player, String message) {
        JSONObject root = new JSONObject();
        JSONObject roomInfo = new JSONObject();
        roomInfo.put("N", room.getDirection(Maze.Directions.NORTH).toString());
        roomInfo.put("S", room.getDirection(Maze.Directions.SOUTH).toString());
        roomInfo.put("E", room.getDirection(Maze.Directions.EAST).toString());
        roomInfo.put("W", room.getDirection(Maze.Directions.WEST).toString());
        roomInfo.put("RoomID", room.getRoomID());
        roomInfo.put("Message", message);
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
        playerInfo.put("inventory", player.getInventory().toString());

        int playerCoins = player.getPlayerCoins();
        List<String> playerKeys = new ArrayList<>();
        for(Item i : player.getInventory()) {
            if(!Objects.equals(i.toString(), "Coin")) {
                playerKeys.add(i.toString());
            }
        }

        playerInfo.put("playerCoins", playerCoins);
        playerInfo.put("playerKeys", playerKeys);
        playerInfo.put("playerWinner", player.isWinner());
        root.put("player", playerInfo);

        return root.toJSONString();
    }

}
