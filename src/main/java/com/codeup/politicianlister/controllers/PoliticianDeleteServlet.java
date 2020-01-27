package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.PoliticianDeleteServlet", urlPatterns = "/politicians/delete")
public class PoliticianDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("signed_in");
        System.out.println(user.getId());
        DaoFactory.getPoliticiansDao().delete((String) request.getAttribute("name"));
        response.sendRedirect("/comrades");
    }
}
