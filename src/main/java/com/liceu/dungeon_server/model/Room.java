package com.liceu.dungeon_server.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int roomID;

    private Item[] roomItems = {null, null};
    private boolean exit = false;
    private Map<Maze.Directions, RoomSide> directions = new HashMap<>();

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }



    public void setKey(Key key) {
        this.roomItems[0] = key;
    }
    public boolean hasKey() {
        return this.roomItems[0] != null;
    }
    public Item getKey() {
        return this.roomItems[0];
    }
    public void removeKey() {
        this.roomItems[0] = null;
    }

    public void setCoin(Coin coin) {
        this.roomItems[1] = coin;
    }
    public boolean hasCoin() {
        return this.roomItems[1] != null;
    }
    public Item getCoin() {
        return this.roomItems[1];
    }

    public void removeCoin() {
        this.roomItems[1] = null;
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
