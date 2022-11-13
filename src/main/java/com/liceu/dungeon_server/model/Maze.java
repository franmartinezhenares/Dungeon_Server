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
}
