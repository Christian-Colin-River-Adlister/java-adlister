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

@WebServlet(name = "controllers.CreatePartyServlet", urlPatterns = "/party/create")
public class CreatePartyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("signed_in") == null) {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Party party = new Party(
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("wiki_link"),
                Long.parseLong(request.getParameter("country")),
                request.getParameter("flag_url")
        );
        DaoFactory.getPartiesDao().insert(party);
        response.sendRedirect("/profile");
    }

}
