package com.liceu.dungeon_server.model;

import java.util.HashMap;
import java.util.Map;

public class Maze {

    int mazeID;

    public enum Directions { NORTH, SOUTH, EAST, WEST;}
    Map<Integer, Room> rooms = new HashMap<>();

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public int getMazeID() {
        return mazeID;
    }

    public void setMazeID(int mazeID) {
        this.mazeID = mazeID;
    }

    public void addRoom(int roomID, Room room) {
        this.rooms.put(roomID, room);
    }

    public Room getRoomFromID(int roomID) {
        return this.rooms.get(roomID);
    }
}
