package com.liceu.dungeon_server.model;

public class Wall implements RoomSide{
    @Override
    public String enter(Player player) {
        return "No se puede pasar a través de una pared";
    }

    public String toString() {
        return "Wall";
    }
}
