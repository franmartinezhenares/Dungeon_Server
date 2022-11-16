package com.liceu.dungeon_server.services;

import com.liceu.dungeon_server.model.Key;

public class KeyService {

    public Key createKey(String keyName) {
        Key key = new Key();
        key.setKeyName(keyName);
        return key;
    }
}
