package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Door;
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
//    public static Door createDoor(Room roomFrom, Room roomTo) {
//        Door door = new Door();
//        door.setRoomFrom(roomFrom);
//        door.setRoomTo(roomTo);
//        return door;
//    }

    public void open(Door door) { door.open(); }

    public static void enter(Player player, Door door) {
        if (!door.isOpen()) {
            door.open();
//            System.out.println("Puerta cerrada");
        }
        if (door.isOpen()) {
            Room goTo = getOtherRoom(player.getCurrentRoom(), door);
            player.setCurrentRoom(goTo);
        }
    }

    public static Room getOtherRoom(Room currentRoom, Door door) {
        if(door.getRoomFrom().getRoomID() == currentRoom.getRoomID()) {
            return door.getRoomTo();
        }
        return door.getRoomFrom();
    }
}
