package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Item;
import com.liceu.dungeon_server.model.Room;

public class RoomService {
    public static Room createRoom(int roomID) {
        Room room = new Room();
        room.setRoomID(roomID);
        return room;
    }
}
