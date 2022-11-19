package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.utils.GameUtils;
import com.liceu.dungeon_server.services.PlayerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/start")
public class StartController extends HttpServlet {

    GameUtils gameService = new GameUtils();
    PlayerService playerService = new PlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Inicio del juego, bienvenida, formulario de inicio (selección de mapa)

        HttpSession session = req.getSession();
        String selectedMaze = req.getParameter("maze_select");

        System.out.println("Selected: " + selectedMaze);

        req.setAttribute("mazeID", selectedMaze);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int mazeID = Integer.parseInt(req.getParameter("maze_select"));

        Maze maze =gameService.createMaze(mazeID);
        Player player = playerService.createPlayer(maze.getRoomFromID(1));

        Date date = new Date();
        long startMS = date.getTime();
        session.setAttribute("startTime", startMS);

        session.setAttribute("sessionPlayer", player);
        session.setAttribute("sessionMaze", maze);

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
//        dispatcher.forward(req, resp);

        resp.sendRedirect("/nav");

    }
}
