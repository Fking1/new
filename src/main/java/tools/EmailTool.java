package tools;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailTool {
    public static String hostName="smtp.sina.com";
    public static String authentication="fang455039690";
    public static String ownerPassword="fang1234";
    public static String from="fang455039690@sina.com";
    public static String domain;
    public static String permitCode;
    public Boolean sendEmail(String to,String theme,String emailContent) throws EmailException {
        boolean result = false;
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setCharset("UTF-8");
        simpleEmail.setHostName(hostName);
        simpleEmail.setAuthentication(authentication,ownerPassword);
        simpleEmail.setFrom(from);
        simpleEmail.setMsg("点击链接完成注册");
        simpleEmail.setSubject("点击注册");
        simpleEmail.addTo(to);
        //设置主题
        simpleEmail.setSubject(theme);
        //设置邮件内容
        simpleEmail.setMsg(emailContent);
        //发送邮件
        simpleEmail.send();

        result = true;
        return result;
    }
}
