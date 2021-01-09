package me.gacl.util.email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

public interface iemail {
    /**
     * 发件人的邮箱地址
     */
    public static final String localemail="843497509@qq.com";
    /**
     * 常用host参数
     */
    public static String host="smtp.qq.com";
    /**
     * 服务密码
     */
    public static String pawd="dmribcemiaocbeda";

    void findpawd(String emailid, String text) throws GeneralSecurityException, MessagingException;

    void findpawd(String emailid, String text, String pawd) throws GeneralSecurityException, MessagingException;

    /**
     * 发送邮件
     * @param emailid
     */
    public void sendemail(String emailid,String text) throws MessagingException, GeneralSecurityException;
    public boolean checkEmail(String email) throws SQLException, ClassNotFoundException;
}
