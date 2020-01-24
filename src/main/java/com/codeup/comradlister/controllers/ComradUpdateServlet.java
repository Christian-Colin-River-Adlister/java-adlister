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

@WebServlet(name = "controllers.ComradUpdateServlet", urlPatterns = "/comrades/update")
public class ComradUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("signed_in");
        List<Party> comradeParties = new ArrayList<>();
        String parties = request.getParameter("partyArea");
        String[] partiesSplit = parties.split(",");
        for (String s : partiesSplit) {
            Party found = DaoFactory.getPartiesDao().findByName(s);
            if(found != null){
                comradeParties.add(found);
            }
        }

        Comrad comrad = new Comrad((String) request.getAttribute(""), (String) request.getAttribute(""), (String) request.getAttribute(""), (Long) request.getAttribute(""));

        DaoFactory.getComradsDao().insert(comrad);
        for (Party party : comradeParties) {
            DaoFactory.getComradsDao().insertComradeParty(comrad, party);
        }
        response.sendRedirect("/comrades");
    }
}
