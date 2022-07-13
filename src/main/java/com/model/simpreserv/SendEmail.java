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

    private String emailAddressTo;
    private String msgSubject;
    private String msgText;


    static final String PASS = "zHd0hN1Vwb"; // Password of the From address
    static final String FROM = "testmail@bird.com.sv"; // From address
    static final String FILE_PATH = "src\\main\\java\\com\\file\\SimpReserv.txt"; // File attached


    public SendEmail() {/*Constructor*/}

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        // Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ehlo", "false");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.checkserveridentity", "true");
        props.put("mail.smtp.host", "mail.bird.com.sv");

        // Get the Session object.
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASS);
            }
        });

        session.setDebug(false); // Used to debug SMTP issues

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM)); // Set from address of the email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailAddressTo)); // Set email recipient

            message.setSubject(msgSubject); // Set email message subject

            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();


            try {


                File file = new File(FILE_PATH);

                attachmentPart.attachFile(file);
                textPart.setText(msgText);
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {
                e.printStackTrace();
            }

            message.setContent(multipart);
            Transport.send(message); // Send email message

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }

    }
}
