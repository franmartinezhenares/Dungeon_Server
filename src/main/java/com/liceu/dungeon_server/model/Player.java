package com.liceu.dungeon_server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    public int getPlayerCoins() {
        int total = 0;
        for(Item i : this.inventory) {
            if(Objects.equals(i.toString(), "Coin")) {
                total++;
            }
        }
        return total;
    }

    public void removePlayerCoins(int num) {

        for (int i = 0; i < num; i++) {
            for(Item item : this.inventory) {
                if(Objects.equals(item.toString(), "Coin")) {
                    this.inventory.remove(item);
                }
            }
        }
    }
}
