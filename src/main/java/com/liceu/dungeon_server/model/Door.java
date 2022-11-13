package com.liceu.dungeon_server.model;

public class Door implements RoomSide{

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
    public void enter(Player player) { }
//
//    private Room getOtherRoom (Room currentRoom) {
//        if (roomFrom.getRoomID() == currentRoom.getRoomID()) {
//            return roomTo;
//        }
//        return roomFrom;
//    }


}
