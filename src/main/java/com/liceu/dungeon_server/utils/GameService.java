package com.liceu.dungeon_server.utils;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;
import com.liceu.dungeon_server.model.RoomSide;

public class GameService {

    public static Maze createMaze(int mazeID) {
        BuilderService builderService = new BuilderService();

        switch (mazeID) {
            case 1:

                for (int i = 1; i <= 3 ; i++) {
                    builderService.buildRoom(i);
                }

                builderService.buildDoor(1, 2, Maze.Directions.WEST);
                builderService.buildDoor(2, 3, Maze.Directions.WEST);

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
}
