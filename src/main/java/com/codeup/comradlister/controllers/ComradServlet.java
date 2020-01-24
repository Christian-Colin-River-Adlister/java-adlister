package com.codeup.comradlister.controllers;

import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ComradServlet", urlPatterns = "/comrade")
public class ComradServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("comrade", DaoFactory.getComradsDao().findByName("Stalin"));
        request.setAttribute("users", DaoFactory.getUsersDao().all());
        request.getRequestDispatcher("/WEB-INF/comrades/comrades.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Comrad comrad = DaoFactory.getComradsDao().findByName(request.getParameter("name"));
        List<Country> countries = DaoFactory.getCountriesDao().all();
        request.setAttribute("comrade", comrad);
        request.setAttribute("countries",countries);
        request.getRequestDispatcher("/WEB-INF/comrades/comrade.jsp").forward(request, response);
    }
}
