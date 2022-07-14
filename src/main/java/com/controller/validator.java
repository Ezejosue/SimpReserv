package com.controller;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validator {
  private static final String PATTERNLETTERS = "^[a-zA-Z]+$";
  private static final String PATTERNNUMBERS = "^\\d+$";
  private static final String PATTERNEMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

  private static final String PATTERCARNET ="[C][A][0-9][0-9]";
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

  public boolean validateNumbers(double textString){
    String text = String.valueOf(textString);
    Pattern pattern = Pattern.compile(PATTERNNUMBERS);
    Matcher matcher = pattern.matcher(text);
    if (matcher.matches()){
      return true;
    } else {
      System.out.println("Solo se permiten numeros");
      return false;
    }  }

  public boolean validateEmail(String textString){
    Pattern pattern = Pattern.compile(PATTERNEMAIL);
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

  public boolean validateGender(String gender){
    if (gender.equals("M")||gender.equals("F")){
      return true;
    } else{
      System.out.println("Coloque una opcion correcta");
      return false;
    }
  }

  public boolean validateCarnet(String carnet){
    Pattern pattern = Pattern.compile(PATTERCARNET);
    Matcher matcher = pattern.matcher(carnet);
    if (matcher.matches()){
      return true;
    } else {
      System.out.println("El formato del carnet es incorrecto!! Ejemplo CA01");
      return false;
    }
  }
}
