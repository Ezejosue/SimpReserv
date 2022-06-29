import lombok.Getter;
import lombok.Setter;

public class Email {

  @Getter @Setter private String email;
  @Getter @Setter private String password;
  @Getter @Setter private String user;
  @Getter @Setter private String mailSender;

  public Email() {}

  public void getUserData() {}

  public void sendEmail() {}
}
