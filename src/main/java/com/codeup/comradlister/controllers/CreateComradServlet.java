package com.codeup.comradlister.controllers;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.dao.MySQLComradsDao;
import com.codeup.comradlister.dao.MySQLPartiesDao;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;
import com.codeup.comradlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.CreateComradServlet", urlPatterns = "/comrades/create")
public class CreateComradServlet extends HttpServlet {
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
        MySQLComradsDao mySQLComradsDao = new MySQLComradsDao(config);
        List<Comrad> allComrades = mySQLComradsDao.all();
        List<Party> comradeParties = new ArrayList<>();
        String parties = request.getParameter("partyArea");
        System.out.println(parties);
        String[] partiesSplit = parties.split(",");
        for (String s : partiesSplit) {
            Party found = mySQLPartiesDao.findByName(s);
            if(found != null){
                comradeParties.add(found);
            }
        }
        Comrad comrad = new Comrad(
                (long)allComrades.size()+1,
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("wiki_link"),
                user.getId()
        );
        DaoFactory.getComradsDao().insert(comrad);
        for (Party party : comradeParties) {
            DaoFactory.getComradsDao().insertComradeParty(comrad, party);
        }
        response.sendRedirect("/comrades");
    }

}
