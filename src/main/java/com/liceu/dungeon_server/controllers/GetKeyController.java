package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Key;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.model.Room;
import com.liceu.dungeon_server.utils.GameUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getkey")
public class GetKeyController extends HttpServlet {
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("sessionPlayer");
        Room room = player.getCurrentRoom();

        if(room.hasKey()) {
            Key key = (Key)room.getKey();
            int keyValue = key.getKeyValue();
            int playerCoins = player.getPlayerCoins();
            if(keyValue <= playerCoins) {
                player.addToInventory(key);
                player.removePlayerCoins(key.getKeyValue());
                req.setAttribute("sessionPlayer", player);
                room.removeKey();
            } else {
                System.out.println("No tienes suficientes monedas");
            }
        }
        String roomJson = gameUtils.getJsonInfo(room, player);
        req.setAttribute("currentRoom", roomJson);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
