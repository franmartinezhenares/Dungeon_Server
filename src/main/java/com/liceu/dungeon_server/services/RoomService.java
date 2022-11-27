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

    public boolean getRoomCoin(Player player, Room room) {
        if(room.hasCoin()) {
            Coin coin = new Coin();
            player.addToInventory(coin);
            room.removeCoin();
            return true;
        }
        return false;
    }

    public String getRoomKey(Player player, Room room) {
        String message = "";
        if(room.hasKey()) {
            Key key = (Key)room.getKey();
            int keyValue = key.getKeyValue();
            int playerCoins = player.getPlayerCoins();

            if(keyValue <= playerCoins) {
                message = "You got a Key";
                player.addToInventory(key);
                for (int i = 0; i < key.getKeyValue() ; i++) {
                    player.removePlayerCoins();
                }

                room.removeKey();
            } else {
                message = "Not enough coins";
            }
        }
        return message;
    }

}
