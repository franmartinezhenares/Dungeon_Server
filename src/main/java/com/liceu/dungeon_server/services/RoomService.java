package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RoomService {
    public static Room createRoom(int roomID) {
        Room room = new Room();
        room.setRoomID(roomID);
        return room;
    }

}
