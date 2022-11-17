package com.liceu.dungeon_server.controllers;


import com.liceu.dungeon_server.model.Coin;
import com.liceu.dungeon_server.model.Maze;
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

@WebServlet("/nav")
public class NavController extends HttpServlet {
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dir = req.getParameter("dir");
        String get = req.getParameter("get");

        HttpSession session = req.getSession();

        Player player = (Player) session.getAttribute("sessionPlayer");
//        Maze maze = (Maze) session.getAttribute("sessionMaze");

        Room room = player.getCurrentRoom();

        String roomJson = gameUtils.getJsonInfo(room, player);
        req.setAttribute("currentRoom", roomJson);

        if(dir != null) {
            gameUtils.go(player, Maze.Directions.valueOf(dir));
            room = player.getCurrentRoom();
            roomJson = gameUtils.getJsonInfo(room, player);
            req.setAttribute("currentRoom", roomJson);
        }

        if(get != null) {
            if(get.equals("coin")) {

                RequestDispatcher dispatcher = req.getRequestDispatcher("/getcoin");
                dispatcher.forward(req, resp);
            }
            if(get.equals("key")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/getkey");
                dispatcher.forward(req, resp);
            }
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
