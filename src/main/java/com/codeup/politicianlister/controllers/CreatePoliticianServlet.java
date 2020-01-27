package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.Config.Config;
import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.dao.MySQLPoliticianDao;
import com.codeup.politicianlister.dao.MySQLPartiesDao;
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

@WebServlet(name = "controllers.CreatePoliticianServlet", urlPatterns = "/politician/create")
public class CreatePoliticianServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("signed_in");
        System.out.println(user.getId());
        Config config = new Config();
        MySQLPartiesDao mySQLPartiesDao = new MySQLPartiesDao(config);
        MySQLPoliticianDao mySQLPoliticianDao = new MySQLPoliticianDao(config);
        List<Politician> allPoliticians = mySQLPoliticianDao.all();
        List<Party> politicianParties = new ArrayList<>();
        String parties = request.getParameter("partyArea");
        System.out.println(parties);
        String[] partiesSplit = parties.split(",");
        for (String s : partiesSplit) {
            Party found = mySQLPartiesDao.findByName(s);
            if(found != null){
                politicianParties.add(found);
            }
        }
        Politician politician = new Politician(
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("wiki_link"),
                user.getId()
        );
        DaoFactory.getPoliticiansDao().insert(politician);
        politician = DaoFactory.getPoliticiansDao().findByName(request.getParameter("name"));
        for (Party party : politicianParties) {
            DaoFactory.getPoliticiansDao().insertPoliticianParty(politician, party);
        }
        response.sendRedirect("/politicians");
    }

}
