package com.liceu.dungeon_server.utils;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;
import com.liceu.dungeon_server.model.RoomSide;
import org.json.simple.JSONObject;

public class GameService {

    public static Maze createMaze(int mazeID) {
        BuilderService builderService = new BuilderService();

        switch (mazeID) {
            case 1:

                for (int i = 1; i <= 3 ; i++) {
                    builderService.buildRoom(i);
                }

                builderService.buildDoor(1, 2, Maze.Directions.WEST);
                builderService.buildDoor(2, 3, Maze.Directions.NORTH);

                builderService.setExit(3);
                break;

            case 2:
                System.out.println("No disponible");
        }


        return builderService.getMaze();

    }

    private static void go(Player player, Maze.Directions direction) {
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
