package me.gacl.util.email;

import com.sun.mail.util.MailSSLSocketFactory;
import me.gacl.dao.impl.UserTools;

import javax.mail.*;
import javax.mail.internet.*;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.Properties;

public class emailimpl implements iemail{

    @Override
    public void findpawd(String emailid, String text) throws GeneralSecurityException, MessagingException {

    }

    @Override
    public void findpawd(String emailid, String text, String pawd) throws GeneralSecurityException, MessagingException {
        String localhost="localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth","true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("843497509@qq.com", "dmribcemiaocbeda"); //发件人邮件用户名、密码
            }
        });
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(localemail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailid));
        message.setSubject("这是一个找回密码邮箱");
        String content="<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "    <h1>这是一封找回密码邮件,激活请点击以下链接以将您的密码修改</h1>\n" +
                "    <h3><a href=\"http://localhost:8080/Blog/SendToFindPawdServlet?text=" +text+"&pawd="+pawd+
                "\">点击激活</a></h3>\n" +
                "</body>\n" +
                "</html>";
        message.setContent(content,
                "text/html;charset=UTF-8" );
        Transport.send(message);
    }

    @Override
    public void sendemail(String emailid,String text) throws MessagingException, GeneralSecurityException {
        System.out.println("邮箱地址："+emailid);
        String localhost="localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth","true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("843497509@qq.com", "dmribcemiaocbeda"); //发件人邮件用户名、密码
            }
        });
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(localemail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailid));
        message.setSubject("这是一个验证邮箱");
        String content="<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "    <h1>这是一封激活邮件,激活请点击以下链接</h1>\n" +
                "    <h3><a href=\"http://localhost:8080/Blog/SendemailServlet?text=" +text+
                "\">点击激活</a></h3>\n" +
                "</body>\n" +
                "</html>";
        message.setContent(content,
                "text/html;charset=UTF-8" );
        Transport.send(message);
    }

    public boolean checkEmail(String email) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE email=?";
        UserTools tools=new UserTools();
        return tools.Select(sql,email).next();
    }

    public boolean checkStatus(String email) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE email=? AND status=0";
        UserTools tool=new UserTools();
        return tool.Select(sql,email).next();
    }
}
