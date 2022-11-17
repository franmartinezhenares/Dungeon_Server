package com.liceu.dungeon_server.model;

import java.util.ArrayList;
import java.util.List;

public class Key implements Item{
    private String keyName;

    private int keyValue;
    private List<Door> keyList = new ArrayList<>();

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public int getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    public void setDoor(Door door) {
        this.keyList.add(door);
    }

    public List<Door> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<Door> keyList) {
        this.keyList = keyList;
    }

    @Override
    public String toString() {
        return this.keyName;
    }
}
