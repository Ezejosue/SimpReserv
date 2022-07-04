package entity;

public interface UserControllerInterface {
  public boolean validatePassword(String password, String password1);

  public boolean validateUser(String user, String user1);

  public int validateTypeOfUser(int userType);
}
