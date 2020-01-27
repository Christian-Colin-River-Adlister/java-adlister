package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Party;

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
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Party party = DaoFactory.getPartiesDao().findByName(request.getParameter("name"));
        List<Politician> politicians = DaoFactory.getPartiesDao().getPartyComrads(party.getId());
        request.setAttribute("party", party);
        request.setAttribute("politicians", politicians);
        request.getRequestDispatcher("/WEB-INF/main/party.jsp").forward(request, response);
    }
}
