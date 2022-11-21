package com.liceu.dungeon_server.model;

public class Wall implements RoomSide{
    @Override
    public String enter(Player player) {
        return "You can't cross a Wall";
    }

    public String open(Player player) {
        return "You can't open a Wall";
    }
    public String toString() {
        return "Wall";
    }
}
