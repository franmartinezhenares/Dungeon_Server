package com.liceu.dungeon_server.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int roomID;
    private Item item;
    private boolean exit = false;
    private Map<Maze.Directions, RoomSide> directions = new HashMap<>();

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
}
