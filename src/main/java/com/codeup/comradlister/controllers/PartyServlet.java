package com.codeup.comradlister.controllers;

import com.codeup.comradlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.PartyServlet", urlPatterns = "/party")
public class PartyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("comrade", DaoFactory.getComradsDao().findByName());
//        request.setAttribute("users", DaoFactory.getUsersDao().all());
//        request.getRequestDispatcher("/WEB-INF/comrades/comrades.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("party", DaoFactory.getPartiesDao().findByName(request.getParameter("name")));
        request.getRequestDispatcher("/WEB-INF/comrades/party.jsp").forward(request, response);
    }
}
