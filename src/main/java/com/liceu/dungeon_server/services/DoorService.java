package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Door;
import com.liceu.dungeon_server.model.Key;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;

public class DoorService {
    public Door createDoor(Room roomFrom, Room roomTo, boolean open) {
        Door door = new Door();
        door.setRoomFrom(roomFrom);
        door.setRoomTo(roomTo);
        door.setOpen(open);
        return door;
    }

    public Door createDoor(Room roomFrom, Room roomTo, Key key) {
        Door door = new Door();
        door.setRoomFrom(roomFrom);
        door.setRoomTo(roomTo);
        key.setDoor(door);
        return door;
    }

    public void open(Door door) { door.open(); }

    public String enter(Player player, Door door) {
        String message = "";
        if (!door.isOpen()) {
//            door.open();
            message = "Puerta cerrada";
            System.out.println(message);
        }
        if (door.isOpen()) {
            Room goTo = getOtherRoom(player.getCurrentRoom(), door);
            player.setCurrentRoom(goTo);
        }
        return message;
    }

    public static Room getOtherRoom(Room currentRoom, Door door) {
        if(door.getRoomFrom().getRoomID() == currentRoom.getRoomID()) {
            return door.getRoomTo();
        }
        return door.getRoomFrom();
    }
}
