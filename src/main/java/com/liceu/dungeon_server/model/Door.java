package com.liceu.dungeon_server.model;

import com.liceu.dungeon_server.services.DoorService;

public class Door implements RoomSide{

    DoorService doorService = new DoorService();

    private Room roomFrom;
    private Room roomTo;
    private boolean open = false;

    public Room getRoomFrom() {
        return roomFrom;
    }

    public void setRoomFrom(Room roomFrom) {
        this.roomFrom = roomFrom;
    }

    public Room getRoomTo() {
        return roomTo;
    }

    public void setRoomTo(Room roomTo) {
        this.roomTo = roomTo;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


    public void open() { this.open = true; }

    @Override
    public String enter(Player player) {
        return doorService.enter(player, this);
    }

    @Override
    public String toString() {
        boolean type = this.open;
        if(type) {
            return "Corridor";
        }
        return "Door";
    }
}
