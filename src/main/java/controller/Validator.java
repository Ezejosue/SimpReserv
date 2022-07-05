package controller;

import java.text.SimpleDateFormat;

public class Validator implements entity.Validator {

  @Override
  public String formatDate(String date) {
    new SimpleDateFormat("dd/MM/yyyy").format(date);
    return date;
  }
}
