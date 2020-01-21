package com.codeup.comradlister.controllers;

import com.codeup.comradlister.Config.Config;
import com.codeup.comradlister.dao.DaoFactory;
import com.codeup.comradlister.dao.MySQLPartiesDao;
import com.codeup.comradlister.models.Comrad;
import com.codeup.comradlister.models.Party;
import com.codeup.comradlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        List<Party> comradeParties = null;
        Config config = new Config();
        MySQLPartiesDao mySQLPartiesDao = new MySQLPartiesDao(config);
        List<Party> allParties = mySQLPartiesDao.all();
        String partyIndex = (String)request.getSession().getAttribute("partyIndex");
        for(int i = 0; i > partyIndex.length();i++){
            comradeParties.add(allParties.get(partyIndex.charAt(i)));
        }
        Comrad comrad = new Comrad(
            request.getParameter("name"),
            request.getParameter("description"),
            user.getId(),
            comradeParties
        );
        DaoFactory.getComradsDao().insert(comrad);
        response.sendRedirect("/ads");
    }
}
