package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.models.Politician;
import com.codeup.politicianlister.models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.PoliticianServlet", urlPatterns = "/politician")
public class PoliticianServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("comrade", DaoFactory.getComradsDao().findByName("Stalin"));
        request.setAttribute("users", DaoFactory.getUsersDao().all());
        request.getRequestDispatcher("/WEB-INF/main/politicians.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Politician politician = DaoFactory.getPoliticiansDao().findByName(request.getParameter("name"));
        List<Country> countries = DaoFactory.getCountriesDao().all();
        request.setAttribute("politician", politician);
        request.setAttribute("countries",countries);
        request.getRequestDispatcher("/WEB-INF/main/politician.jsp").forward(request, response);
    }
}
