package com.codeup.politicianlister.controllers;

import com.codeup.politicianlister.dao.DaoFactory;
import com.codeup.politicianlister.models.Party;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "controllers.PartyUpdateServlet", urlPatterns = "/parties/update")
public class PartyUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        User user = (User) request.getSession().getAttribute("signed_in");
        Party updated = new Party((String) request.getAttribute("name"), (String) request.getAttribute("description"),(String) request.getAttribute("wiki_link"), (Long) request.getAttribute("country_id"));
        DaoFactory.getPartiesDao().update(updated);
        response.sendRedirect("/parties");
    }
}
