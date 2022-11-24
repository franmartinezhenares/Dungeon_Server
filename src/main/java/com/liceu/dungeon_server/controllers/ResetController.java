package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.services.PlayerService;
import com.liceu.dungeon_server.utils.GameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/reset")
public class ResetController extends HttpServlet {
    PlayerService playerService = new PlayerService();
    GameUtils gameUtils = new GameUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Maze mazeReset = (Maze)session.getAttribute("sessionMaze");

        int mazeID = mazeReset.getMazeID();
        Maze maze =gameUtils.createMaze(mazeID);
        Player player = playerService.createPlayer(maze.getRoomFromID(1));

        Date date = new Date();
        long startMS = date.getTime();
        session.setAttribute("startTime", startMS);

        session.setAttribute("sessionPlayer", player);
        session.setAttribute("sessionMaze", maze);

        resp.sendRedirect("/nav");
    }
}
