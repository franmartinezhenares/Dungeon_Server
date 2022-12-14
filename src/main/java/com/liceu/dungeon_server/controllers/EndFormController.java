package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Maze;
import com.liceu.dungeon_server.model.Player;
import com.liceu.dungeon_server.services.WinnerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/endform")
public class EndFormController extends HttpServlet {
    WinnerService winnerService = new WinnerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Maze maze = (Maze) session.getAttribute("sessionMaze");
        Player player = (Player)session.getAttribute("sessionPlayer");


        String name = req.getParameter("player_name");

        if(name.length() < 1 || name.length() > 12) {
            req.setAttribute("error", "Error de login");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        player.setWinner(false);
        session.setAttribute("sessionPlayer", player);

        long totalTime = (long)session.getAttribute("totalTime");

        winnerService.createWinner(name, maze.getMazeName(), totalTime);

        resp.sendRedirect("/winners");
    }
}
