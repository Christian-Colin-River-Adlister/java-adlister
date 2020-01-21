package com.codeup.comradlister.controllers;

import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateComradServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Comrad comrad = new Comrad(
            request.getParameter("name"),
            request.getParameter("description"),
            user.getId()
        );
        DaoFactory.getComradsDao().insert(comrad);
        response.sendRedirect("/ads");
    }
}
