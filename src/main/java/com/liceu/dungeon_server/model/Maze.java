package com.liceu.dungeon_server.model;

import java.util.HashMap;
import java.util.Map;

public class Maze {

    public enum Directions { NORTH, SOUTH, EAST, WEST }
    Map<Integer, Room> rooms = new HashMap<>();

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(int nRoom, Room room) {
        this.rooms.put(nRoom, room);
    }

    public Room getRoomFromID(int roomID) {
        return this.rooms.get(roomID);
    }
}