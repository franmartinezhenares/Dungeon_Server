package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Door;
import com.liceu.dungeon_server.model.Item;
import com.liceu.dungeon_server.model.Key;

import java.util.List;

public class KeyService {

    public Key createKey(String keyName, int keyValue) {
        Key key = new Key();
        key.setKeyName(keyName);
        key.setKeyValue(keyValue);
        return key;
    }

    public boolean getDoorKey(Door door, List<Item> keyList) {
        for (Item item : keyList) {
            if (item instanceof Key){
                Key key = (Key) item;
                if (key.getKeyList().contains(door)){
                    return true;
                }
            }
        }
        return false;
    }
}
