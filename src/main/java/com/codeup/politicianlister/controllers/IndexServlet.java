package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("politicians", DaoFactory.getPoliticiansDao().all());
        request.getSession().setAttribute("users", DaoFactory.getUsersDao().all());
        request.getSession().setAttribute("countries",DaoFactory.getCountriesDao().all());
        request.getSession().setAttribute("parties",DaoFactory.getPartiesDao().all());
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
