package me.gacl.util.Ads;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Ad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ads {
    static UserTools tool=new UserTools();
    public static ArrayList<Ad> getAds() throws SQLException, ClassNotFoundException {
        ArrayList<Ad> ads=new ArrayList<>();
        String sql="SELECT * FROM ads";
        ResultSet set=tool.Select(sql);
        while (set.next()){
            Ad ad=new Ad();
            ad.setAdBackgroud(set.getString("AdBackgroud"));
            ad.setAdHead(set.getString("AdHead"));
            ad.setAdId(set.getInt("AdId"));
            ad.setAdP(set.getString("AdP"));
            ad.setAdHyperlink(set.getString("AdHyperlink"));
            ads.add(ad);
        }
        System.out.println("ads:");
        for(Ad a:ads){
            System.out.println(a.getAdBackgroud());
            System.out.println(a.getAdHead());
        }
        return ads;
    }

    public static void addAd(String AdHead,String AdP,String AdBackgroud,String AdHyperlink) throws SQLException, ClassNotFoundException {
        String sql="INSERT ads (AdHead,AdP,AdBackgroud,AdHyperlink) VALUES (?,?,?,?)";
        tool.Add(sql,AdHead,AdP,AdBackgroud,AdHyperlink);
    }

    public static void deleteAd(String AdId) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM ads WHERE AdId=?";
        tool.Delete(sql,AdId);
    }
}
