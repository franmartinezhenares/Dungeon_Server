package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Door;
import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Room;
import com.liceu.dungeon_server.model.Wall;

public class BuilderService {

    private Maze maze = new Maze();

    public void buildRoom(int nRoom) {
        Room room = RoomService.createRoom(nRoom);
        room.setDirection(Maze.Directions.NORTH, new Wall());
        room.setDirection(Maze.Directions.SOUTH, new Wall());
        room.setDirection(Maze.Directions.EAST, new Wall());
        room.setDirection(Maze.Directions.WEST, new Wall());
        maze.addRoom(nRoom, room);
    }

    public void buildDoor(int roomFrom, int roomTo, Maze.Directions direction) {
        Door door = buildDoorInternal(roomFrom, roomTo, direction);
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Maze.Directions direction) {
        Room room1 = maze.getRoomFromID(roomFrom);
        Room room2 = maze.getRoomFromID(roomTo);
        Door door = DoorService.createDoor(room1, room2);
        room1.setDirection(direction, door);
        room2.setDirection(getOppositeDirection(direction), door);
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

    public void setExit(int roomID) {
        this.maze.getRoomFromID(roomID).setExit(true);
    }

    public Maze getMaze() {
        return this.maze;
    }

}
