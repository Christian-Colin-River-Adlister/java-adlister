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

@WebServlet(name = "controllers.PartyDeleteServlet", urlPatterns = "/parties/delete")
public class PartyDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("signed_in");
        System.out.println(user.getId());
        DaoFactory.getPartiesDao().delete((String) request.getAttribute("name"));
        response.sendRedirect("/parties");
    }
}
