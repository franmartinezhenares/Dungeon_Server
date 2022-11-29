package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.*;

public class DoorService {
    KeyService keyService = new KeyService();
    public Door createDoor(Room roomFrom, Room roomTo, boolean open) {
        Door door = new Door();
        door.setRoomFrom(roomFrom);
        door.setRoomTo(roomTo);
        door.setOpen(open);
        return door;
    }

    public String enter(Player player, Door door) {
        String message = "";
        if (!door.isOpen()) {
            message = "Closed Door";
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

    public String doorInstance(RoomSide roomSide, Player player) {
        String message = "";
        if(roomSide instanceof Door) {
            Door door = (Door) roomSide;
            if(door.isOpen()) {
                message = "There is a Corridor";
            } else {
                if(keyService.getDoorKey(door, player.getInventory())) {
                    door.open();
                    message = "You opened the Door";
                } else {
                    message = "You don't have the Key";
                }
            }
        }
        return message;
    }
}
