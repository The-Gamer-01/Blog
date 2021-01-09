package Manage.controller;


import me.gacl.domain.Ad;
import me.gacl.util.Ads.Ads;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Manage/DeleteAdServlet")
public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String AdId=request.getParameter("AdId");
        try {
            Ads.deleteAd(AdId);
            ArrayList<Ad> ads=(ArrayList<Ad>)request.getSession().getAttribute("ads");
            for(Ad ad:ads){
                if(ad.getAdId()==Integer.valueOf(AdId)){
                    ads.remove(ad);
                }
            }
            request.getSession().setAttribute("ads",ads);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
