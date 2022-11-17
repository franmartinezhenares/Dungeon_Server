package com.liceu.dungeon_server.utils;

import com.liceu.dungeon_server.model.*;
import com.liceu.dungeon_server.services.DoorService;
import com.liceu.dungeon_server.services.RoomService;

public class BuilderUtils {

    private Maze maze = new Maze();
    DoorService doorService = new DoorService();

    public void buildRoom(int nRoom) {
        Room room = RoomService.createRoom(nRoom);
        room.setDirection(Maze.Directions.NORTH, new Wall());
        room.setDirection(Maze.Directions.SOUTH, new Wall());
        room.setDirection(Maze.Directions.EAST, new Wall());
        room.setDirection(Maze.Directions.WEST, new Wall());
        maze.addRoom(nRoom, room);
    }

    public void buildDoor(int roomFrom, int roomTo, Maze.Directions direction) {
        Door door = buildDoorInternal(roomFrom, roomTo, direction, false);
    }

    public void buildDoor(int roomFrom, int roomTo, Maze.Directions direction, Key key) {
        Door door = buildDoorInternal(roomFrom, roomTo, direction, false, key);
    }

    public void buildCorridor(int roomFrom, int roomTo, Maze.Directions direction) {
        Door door = buildDoorInternal(roomFrom, roomTo, direction, true);
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Maze.Directions direction, boolean open) {
        Room room1 = maze.getRoomFromID(roomFrom);
        Room room2 = maze.getRoomFromID(roomTo);
        Door door = doorService.createDoor(room1, room2, open);
        room1.setDirection(direction, door);
        room2.setDirection(getOppositeDirection(direction), door);
        return door;
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Maze.Directions direction, boolean open, Key key) {
        Room room1 = maze.getRoomFromID(roomFrom);
        Room room2 = maze.getRoomFromID(roomTo);
        Door door = doorService.createDoor(room1, room2, open);
        room1.setDirection(direction, door);
        room2.setDirection(getOppositeDirection(direction), door);
        key.setDoor(door);
        return door;
    }

    private Maze.Directions getOppositeDirection(Maze.Directions direction) {
        switch(direction) {
            case NORTH: return Maze.Directions.SOUTH;
            case SOUTH: return Maze.Directions.NORTH;
            case WEST: return Maze.Directions.EAST;
            case EAST: return Maze.Directions.WEST;
        }
        throw new RuntimeException("Dirección no reconocida");
    }

    public void putKeyInRoom(int RoomID, Key key) {

        Room room =maze.getRoomFromID(RoomID);
        room.setKey(key);
    }

    public void putCoinInRoom(int RoomID) {
        Room room =maze.getRoomFromID(RoomID);
        Coin coin = new Coin();
        room.setCoin(coin);
    }

    public void setExit(int roomID) {
        this.maze.getRoomFromID(roomID).setExit(true);
    }

    public Maze getMaze() {
        return this.maze;
    }

}
