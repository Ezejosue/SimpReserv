package com.controller;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator {
  private static final String PATTERNLETTERS = "^[a-zA-Z]+$";
  private static final String PATTERNNUMBERS = "^\\d+$";
  private static final String PATTERNEMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  public boolean validateLetters(String textString){
    Pattern pattern = Pattern.compile(PATTERNLETTERS);
    Matcher matcher = pattern.matcher(textString);
    if (matcher.matches()){
      return true;
    } else {
      System.out.println("Solo se permiten letras");
      return false;
    }
  }

  public boolean validateNumbers(String textString){
    return false;
  }

  public boolean validateEmail(String textString){
    Pattern pattern = Pattern.compile(PATTERNLETTERS);
    Matcher matcher = pattern.matcher(textString);
    if (matcher.matches()){
      return true;
    } else {
      System.out.println("Formato del correo incorrecto");
      return false;
    }
  }

  public String formatDate(String date) {
    new SimpleDateFormat("dd/MM/yyyy").format(date);
    return date;
  }
}
