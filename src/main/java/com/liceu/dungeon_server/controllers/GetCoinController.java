package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Coin;
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

@WebServlet("/getcoin")
public class GetCoinController extends HttpServlet {
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("sessionPlayer");
        Room room = player.getCurrentRoom();
        String message = "";

        if(room.hasCoin()) {
            Coin coin = new Coin();
            player.addToInventory(coin);
            message = "You got a Coin";
            req.setAttribute("sessionPlayer", player);
            room.removeCoin();

            String roomJson = gameUtils.getJsonInfo(room, player, message);
            req.setAttribute("currentRoom", roomJson);

//            resp.sendRedirect("/nav");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);

        } else {
//            player = (Player) session.getAttribute("sessionPlayer");
//            room = player.getCurrentRoom();
//            req.setAttribute("sessionPlayer", player);
//
//            message = "Do not cheat!";
//
//            String roomJson = gameUtils.getJsonInfo(room, player, message);
//            req.setAttribute("currentRoom", roomJson);

            resp.setStatus(401);
            req.setAttribute("error", "There is no coins in this room");



            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(req, resp);


//            resp.sendRedirect("/nav");
        }

//        String roomJson = gameUtils.getJsonInfo(room, player, message);
//        req.setAttribute("currentRoom", roomJson);

//        resp.sendRedirect("/nav");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
//        dispatcher.forward(req, resp);
    }
}
