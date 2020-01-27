package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.PoliticianIndexServlet", urlPatterns = "/politicians")
public class PoliticianIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("politicians", DaoFactory.getPoliticiansDao().all());
        request.setAttribute("users", DaoFactory.getUsersDao().all());
        request.getRequestDispatcher("/WEB-INF/main/politicians.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
