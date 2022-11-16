package com.liceu.dungeon_server.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int roomID;

    private List<Item> roomItems = new ArrayList<>();
    private boolean exit = false;
    private Map<Maze.Directions, RoomSide> directions = new HashMap<>();

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(List<Item> roomItems) {
        this.roomItems = roomItems;
    }

    public void setItem(Item item) {
        this.roomItems.add(item);
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public Map<Maze.Directions, RoomSide> getDirections() {
        return directions;
    }

    public void setDirections(Map<Maze.Directions, RoomSide> directions) {
        this.directions = directions;
    }

    public void setDirection(Maze.Directions direction, RoomSide roomSide) {
        this.directions.put(direction, roomSide);
    }

    public RoomSide getDirection(Maze.Directions direction) {
        return this.directions.get(direction);
    }

}
