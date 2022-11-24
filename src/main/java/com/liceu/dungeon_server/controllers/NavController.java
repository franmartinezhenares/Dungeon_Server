package com.liceu.dungeon_server.controllers;

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
import java.util.Date;

@WebServlet("/nav")
public class NavController extends HttpServlet {
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dir = req.getParameter("dir");

        HttpSession session = req.getSession();

        Player player = (Player) session.getAttribute("sessionPlayer");

        Room room = player.getCurrentRoom();

        String message = "";

        message = (String)session.getAttribute("message");
        if(message == null) message = "";

        String roomJson = gameUtils.getJsonInfo(room, player,message);
        session.setAttribute("message", null);
        req.setAttribute("currentRoom", roomJson);


        if(dir != null) {
            message = gameUtils.go(player, Maze.Directions.valueOf(dir));
            req.setAttribute("message", message);
            room = player.getCurrentRoom();
            roomJson = gameUtils.getJsonInfo(room, player, message);
            req.setAttribute("currentRoom", roomJson);
        }

        if(room.isExit()) {
            long startTime = (long)session.getAttribute("startTime");
            Date date = new Date();
            long endTime = date.getTime();
            long totalTime = endTime - startTime;

            session.setAttribute("totalTime", totalTime);


            message = "You win!!";
            req.setAttribute("message", message);
            player.setWinner(true);
            req.setAttribute("sessionPlayer", player);
            roomJson = gameUtils.getJsonInfo(room, player, message);
            req.setAttribute("currentRoom", roomJson);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);
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
