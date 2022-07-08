package com.model.simpreserv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;


public class SendEmail {

    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();


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

        // Get the Session object.
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(emailAddressTo, password);
                            }
                        });

        session.setDebug(true); // Used to debug SMTP issues

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Set from address of the email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailAddressTo)); // Set email recipient

            message.setSubject(msgSubject); // Set email message subject

            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();

            try {
                File file = new  File("src\\main\\java\\com\\file\\SimpReserv.txt");

                attachmentPart.attachFile(file);
                textPart.setText(msgText);
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e){
                e.printStackTrace();
            }
            message.setContent(multipart);
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
