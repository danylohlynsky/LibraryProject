package com.group4.service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSender {

    public static void sendEmail(List<String> emailAddresses, String title, String message) {
        try {
            final Properties properties = new Properties();
            properties.setProperty("mail.transport.protocol", "smtps");
            properties.setProperty("mail.smtps.auth", "true");
            properties.setProperty("mail.smtps.host", "smtp.gmail.com");
            properties.setProperty("mail.smtps.user", "javaclublibrary@gmail.com");

            Session session = Session.getDefaultInstance(properties);
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("javaclublibrary@gmail.com"));
            for (String emailAddress : emailAddresses)
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            mimeMessage.setSubject(title);
            mimeMessage.setText(message);

            Transport tr = session.getTransport();
            tr.connect(null, "qwerty111_");
            tr.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            tr.close();
        }
        catch (Exception e) {
            System.out.println("Email sender exception");
        }
    }
}
