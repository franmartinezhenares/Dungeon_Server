package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;
import com.liceu.dungeon_server.model.RoomSide;

public class GameService {

    private static Maze createMaze() {
        BuilderService builderService = new BuilderService();

        for (int i = 1; i <= 3 ; i++) {
            builderService.buildRoom(i);
        }

        builderService.buildDoor(1, 2, Maze.Directions.WEST);
        builderService.buildDoor(2, 3, Maze.Directions.WEST);

        builderService.setExit(3);

        return builderService.getMaze();
    }

    private static void go(Player player, Maze.Directions direction) {
        Room room = player.getCurrentRoom();
        RoomSide roomSide = room.getDirection(direction);
        roomSide.enter(player);
    }
}
