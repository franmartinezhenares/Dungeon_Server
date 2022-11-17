package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Door;
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

@WebServlet("/open")
public class OpenController extends HttpServlet {
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("sessionPlayer");
        Room room = player.getCurrentRoom();

        String open = req.getParameter("open");

        Door door = (Door)room.getDirection(Maze.Directions.valueOf(open));

        door.open();

        req.setAttribute("sessionPlayer", player);

        String roomJson = gameUtils.getJsonInfo(room, player, "Has abierto");
        req.setAttribute("currentRoom", roomJson);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
