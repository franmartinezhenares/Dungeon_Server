package com.liceu.dungeon_server.filters;

import com.liceu.dungeon_server.model.Player;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/endform", "/winners"})
public class WinnersFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        Player player = (Player)session.getAttribute("sessionPlayer");

        if(player == null || !player.isWinner()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
            dispatcher.forward(req, res);
            return;
        }

//        if(player.isWinner()) &&  {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
//            dispatcher.forward(req, res);
//            return;
//        }
        chain.doFilter(req, res);
    }
}
