package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Party;
import com.codeup.politicianlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.PoliticianUpdateServlet", urlPatterns = "/politicians/update")
public class PoliticianUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("signed_in");
        List<Party> politicianParties = new ArrayList<>();
        String parties = request.getParameter("partyArea");
        String[] partiesSplit = parties.split(",");
        for (String s : partiesSplit) {
            Party found = DaoFactory.getPartiesDao().findByName(s);
            if(found != null){
                politicianParties.add(found);
            }
        }

        Politician politician = new Politician((String) request.getAttribute("name"), (String) request.getAttribute("description"), (String) request.getAttribute("wiki_link"), (String) request.getAttribute("head_shot_url"),(Long) request.getAttribute("user_id"));

        DaoFactory.getPoliticiansDao().insert(politician);
        for (Party party : politicianParties) {
            DaoFactory.getPoliticiansDao().insertPoliticianParty(politician, party);
        }
        response.sendRedirect("/politicians");
    }
}
