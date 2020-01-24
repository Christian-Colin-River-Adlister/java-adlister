package com.codeup.comradlister.controllers;

import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CountryIndexServlet", urlPatterns = "/country")
public class CountryServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Country country = DaoFactory.getCountriesDao().findByName(request.getParameter("name"));
        request.setAttribute("country", country);
        request.setAttribute("parties",DaoFactory.getCountriesDao().getPartiesFromId(country.getId()));
        request.getRequestDispatcher("/WEB-INF/comrades/country.jsp").forward(request, response);
    }
}
