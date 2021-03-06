package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getSession().setAttribute("parties", DaoFactory.getPartiesDao().all());
        request.getSession().setAttribute("countries", DaoFactory.getCountriesDao().all());
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
