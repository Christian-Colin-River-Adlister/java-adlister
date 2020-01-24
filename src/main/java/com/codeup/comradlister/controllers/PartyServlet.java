package com.codeup.comradlister.controllers;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.dao.MySQLPartiesDao;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.PartyServlet", urlPatterns = "/party")
public class PartyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("comrade", DaoFactory.getComradsDao().findByName());
//        request.setAttribute("users", DaoFactory.getUsersDao().all());
//        request.getRequestDispatcher("/WEB-INF/comrades/comrades.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Party party = DaoFactory.getPartiesDao().findByName(request.getParameter("name"));
        List<Comrad> comrads = DaoFactory.getPartiesDao().getPartyComrads(party.getId());
        request.setAttribute("party", party);
        request.setAttribute("comrads", comrads);
        request.getRequestDispatcher("/WEB-INF/comrades/party.jsp").forward(request, response);
    }
}
