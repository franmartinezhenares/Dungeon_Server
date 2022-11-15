package com.liceu.dungeon_server.model;

public class Wall implements RoomSide{
    @Override
    public void enter(Player player) {
        System.out.println("No se puede pasar a través de una pared");
    }

    public String toString() {
        return "Wall";
    }
}
