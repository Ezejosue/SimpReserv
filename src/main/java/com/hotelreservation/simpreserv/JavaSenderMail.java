package com.hotelreservation.simpreserv;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaSenderMail {
  private String emailAddressTo = new String();
  private String msgSubject = new String();
  private String msgText = new String();

  final String USER_NAME = "test503sv@gmail.com"; // Username of the Google(gmail) account
  final String PASSSWORD = "kfgpcvqewfcxfvqj"; // Password of the Google(gmail) account
  final String FROM_ADDRESS = "test503sv@gmail.com"; // From address

  public JavaSenderMail() {}

  public static void main(String[] args) {
    JavaSenderMail email = new JavaSenderMail();
    // Sending test email
    email.createAndSendEmail(
        "test503sv@gmail.com",
        "Test email subject",
        "Congratulations !!! \nThis is test email sent by java class.");
  }

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

    Session session =
        Session.getInstance(
            props,
            new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("test503sv@gmail.com", "kfgpcvqewfcxfvqj");
              }
            });

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("test503sv@gmail.com")); // Set from address of the email
      message.setContent(msgText, "text/html"); // set content type of the email

      message.setRecipients(
          Message.RecipientType.TO,
          InternetAddress.parse("test503sv@gmail.com")); // Set email recipient

      message.setSubject("Hello World"); // Set email message subject
      Transport.send(message); // Send email message

      System.out.println("sent email successfully!");

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
