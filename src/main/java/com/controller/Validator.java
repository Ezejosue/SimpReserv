package com.controller;

import com.enums.ReservationStatus;
import com.enums.RoomStatus;
import com.model.simpreserv.Client;
import com.model.simpreserv.Reservation;
import com.model.simpreserv.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
  private static final String PATTERNLETTERS = "^[a-zA-Z]+$";
  private static final String PATTERNNUMBERS = "^\\d+$";
  private static final String PATTERNEMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

  private static final String PATTERCARNET ="[C][A][0-9][0-9]";

  private static final String RETURNMENUMSG = "Presione Enter para regresar al menu.";
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

  public Date formatDate(String date) throws ParseException {
    return new SimpleDateFormat("dd/MM/yyyy").parse(date);
  }

  public LocalDate dateToLocalDate(Date date){
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public long countDays(Date dateStart, Date dateEnd){
    long difInOut = Math.abs(dateStart.getTime() - dateEnd.getTime());
    return TimeUnit.DAYS.convert(difInOut, TimeUnit.MILLISECONDS);
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

  public boolean validateClientExists(Client client){
    if (client.getName() != null)
      return true;
    else {
      System.out.println("Cliente no existe o dato incorrecto ingresado. Intente nuevamente.");
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

  public boolean validateClientHasReservation(int clientId){
    Reservation reserva = new Reservation();
    reserva = reserva.searchReservationByClientId(clientId);
    if ((reserva.getId() > 0) && (reserva.getReservationStatus().compareTo(ReservationStatus.CANCELLED) != 0)) {
      System.out.println("Cliente ya tiene reservacion activa.");
      System.out.println("**** " + reserva.toString());
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return true;
    }
    else {
      System.out.println("No existen reservaciones activas para este cliente, presione Enter continuar.");
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

  public boolean validateRoomAvailable(Room room){
    if (room.getRoomStatus().compareTo(RoomStatus.AVAILABLE) == 0){
      return true;
    } else {
      System.out.println("La habitacion no se encuentra disponible.");
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

  public boolean validateRoomExists(Room room){
    if (room.getRoomNumber() > 0){
      return true;
    } else {
      System.out.println("Numero de habitacion incorrecto o no existe.");
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

  public boolean validateReservationById(Reservation reserva){
    if ((reserva != null)) {
      return true;
    } else {
      System.out.println("No se encontro reservacion con ese id.");
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

  public boolean validateReservationByName(Reservation reserva){
    if ((reserva.getId() > 0)) {
      return true;
    } else {
      System.out.println("No se encontro reservacion con ese nombre.");
      System.out.println(RETURNMENUMSG);
      new java.util.Scanner(System.in).nextLine();
      return false;
    }
  }

}
