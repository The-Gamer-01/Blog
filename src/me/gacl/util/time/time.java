package me.gacl.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class time {

    public static String dateTostring(Date date){
        String nowTime=new String();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        nowTime=sdf.format(date);
        return nowTime;
    }

    public static Date stringTodate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate=simpleDateFormat.parse(date);
        return nowDate;
    }

    public static Date toYMDDate(Date date) throws ParseException {
        String time=dateTostring(date);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        Date ans=format.parse(time);
        return ans;
    }

}
