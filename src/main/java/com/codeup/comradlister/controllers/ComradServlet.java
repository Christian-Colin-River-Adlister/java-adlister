package com.codeup.comradlister.controllers;

import com.codeup.comradlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ComradServlet", urlPatterns = "/comrade")
public class ComradServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("comrade", DaoFactory.getComradsDao().findByName(request.getParameter("name")));
        request.getRequestDispatcher("/WEB-INF/comrades/comrade.jsp").forward(request, response);
    }
}