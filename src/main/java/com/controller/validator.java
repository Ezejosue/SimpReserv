package com.controller;

public class validator {
  private static final String PATTERNLETTERS = "^[a-zA-Z]+$";
  private static final String PATTERNNUMBERS = "^\\d+$";
  private static final String PATTERNEMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  public boolean validateLetters(String textString){
    return false;
  }

  public boolean validateNumbers(String textString){
    return false;
  }

  public boolean validateEmail(String textString){
    return false;
  }
}
