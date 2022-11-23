package com.liceu.dungeon_server.filters;

import com.liceu.dungeon_server.model.Player;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/nav", "/getcoin", "/getkey", "/open"})
public class NavigationFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        Player player = (Player)session.getAttribute("sessionPlayer");

        if(player == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
            dispatcher.forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}
