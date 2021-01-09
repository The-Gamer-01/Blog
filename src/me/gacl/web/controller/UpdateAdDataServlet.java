package me.gacl.web.controller;

import me.gacl.util.Ads.Ads;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateAdDataServlet")
public class UpdateAdDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String head=request.getParameter("head");
        String p=request.getParameter("p");
        String AdHyperlink=request.getParameter("AdHyperlink");
        String AdBackgroud="/AdImg/"+request.getSession().getAttribute("img");
        try {
            Ads.addAd(head,p,AdBackgroud,AdHyperlink);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
