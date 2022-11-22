package com.liceu.dungeon_server.controllers;

import com.liceu.dungeon_server.model.Winner;
import com.liceu.dungeon_server.services.WinnerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/winners")
public class WinnersController extends HttpServlet {
    WinnerService winnerService = new WinnerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Winner> winnersList = winnerService.getAllWinners();

        req.setAttribute("winnerslist", winnersList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/winners.jsp");
        dispatcher.forward(req, resp);
    }
}
