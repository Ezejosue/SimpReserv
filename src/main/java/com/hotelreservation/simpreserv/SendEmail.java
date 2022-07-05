package com.hotelreservation.simpreserv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();

    final String to = "tonyvasqueza002@gmail.com"; // Username of the Google(gmail) account
    final String password = "gbwmxuejoacoxowm"; // Password of the Google(gmail) account
    final String from = "tonyvasqueza002@gmail.com"; // From address

    public SendEmail() {}

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        // Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(to, password);
                            }
                        });

        session.setDebug(true); // Used to debug SMTP issues

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Set from address of the email
            message.setContent(msgText, "text/html"); // set content type of the email

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to)); // Set email recipient

            message.setSubject("Hello World"); // Set email message subject
            Transport.send(message); // Send email message

            System.out.println("Sent message successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }
}
