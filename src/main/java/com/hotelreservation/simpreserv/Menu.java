package com.hotelreservation.simpreserv;

import java.util.Scanner;

public class Menu {
  Scanner sc = new Scanner(System.in);

  Clear cls = new Clear();

  public void loggingMenu(String user, String pass) {
    User users = new User();
    if (users.login(user, pass) == 1) {
      userMenu();
    } else if (users.login(user, pass) == 2) {
      employeeMenu();
    } else {
      System.out.println("Error, clave o usuario incorrectos, o no existen");
    }
  }

  public void login() {
    System.out.println("Ingresa tu usuario: ");
    String user = sc.next();

    System.out.println("Ingresa tu clave: ");
    String password = sc.next();

    loggingMenu(user, password);
  }
  public void register() {
    System.out.println("Ingresa tu usuario: ");
    String user = sc.next();

    System.out.println("Ingresa tu clave: ");
    String password = sc.next();

    System.out.println("Ingresa el tipo de usuario: 1: para cliente y 2: para empleado");
    int typeOfUser = sc.nextInt();

    User users = new User();

    if (users.register(user,password,typeOfUser)==1){
      System.out.println("Ya existe ese usuario");
      initialize();
    } else if(users.register(user,password,typeOfUser)==2) {
      System.out.println("Usuario creado correctamente!!");
      login();
    } else{
      System.out.println("Hubo un error al crear el usuario");
      System.exit(0);
    }

  }
  public void initialize() {

    System.out.println(
        "****************************************************************************");
    System.out.println(
        "******                         SimpReserv 1.0                         ******");
    System.out.println(
        "****************************************************************************");
    System.out.println(
        "******       Bienvenido al sistema de registro del Hotel Hilton       ******");
    System.out.println(
        "******       Selecciona una opción                                    ******");
    System.out.println(
        "****************************************************************************");
    System.out.println(
        "******           1-Iniciar Sesión                                     ******");
    System.out.println(
        "******           2-Registarse                                         ******");
    System.out.println(
        "******           3-Salir                                              ******");
    System.out.println(
        "****************************************************************************");

    int option = 0;
    option = sc.nextInt();
    if (option == 1) {

      login();

    } else if (option==2){
        register();
    }else {
      System.exit(0);
    }
  }

  public void userMenu() {
    int close = 0;
    do {
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******                         SimpReserv 1.0                         ******");
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******       Bienvenido al sistema de registro del Hotel Hilton       ******");
      System.out.println(
          "******       Estas son las opciones disponible para servirte mejor    ******");
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******           1-Reservar Habitacion                                ******");
      System.out.println(
          "******           2-Cancelar reserva                                   ******");
      System.out.println(
          "******           3-Solicitar Membrecia                                ******");
      System.out.println(
          "******           4-Cancelar Membrecia                                 ******");
      System.out.println(
          "******           5-Salir                                              ******");
      System.out.println(
          "****************************************************************************");

      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          { // Reservar Habitacion
            System.out.println("Seleccionar fecha de llegada");
            System.out.println("Seleccionar tiempo de estadia");
            System.out.println("Seleccionar habitacion");

            System.out.println("Seleccione el metodo de pago");
            System.out.println("1-Tarjeta de Credito/Debito");
            System.out.println("2-Paypal/Zelle");
            System.out.println("3-Puntos accumulados");
            break;
          }
        case 2:
          { // Cancelar reserva
            System.out.println("Esta seguro de que quiere cancelar su reserva");
            System.out.println("1-Si");
            System.out.println("1-No");
            break;
          }
        case 3:
          { // Solicitar Membrecia
            System.out.println("Seleccione el tipo de membresia");
            System.out.println("1-Silver");
            System.out.println("2-Gold");
            System.out.println("3-Planinium");
            System.out.println(
                "Su membrecia ha sido solicitada. Revise su correo electronico para mas informacion");
            break;
          }
        case 4:
          { // Cancelar Membrecia
            System.out.println("Esta seguro de que quiere cancelar su Membresia");
            System.out.println("1-Si");
            System.out.println("1-No");
            System.out.println("Su membrecia ha sido cancelada exitosamente");
            break;
          }
        case 5:
          { // Cerrar la applicacion
            System.out.println("La aplicacion se ha cerrado con exito");
            opt = 0;
            break;
          }
      }
    } while (close != 0);
  }

  public void employeeMenu() {
    int close = 0;
    do {
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******                         SimpReserv 1.0                         ******");
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******       Bienvenido al sistema de registro del Hotel Hilton       ******");
      System.out.println(
          "******       Opciones de gestion de Huespedes                         ******");
      System.out.println(
          "****************************************************************************");
      System.out.println(
          "******           1-Registrar Usuario                                  ******");
      System.out.println(
          "******           2-Reservar Habitacion                                ******");
      System.out.println(
          "******           3-Cancelar reserva                                   ******");
      System.out.println(
          "******           4-Solicitar Membrecia                                ******");
      System.out.println(
          "******           5-Cancelar Membrecia                                 ******");
      System.out.println(
          "******           6-Salir                                              ******");
      System.out.println(
          "****************************************************************************");
      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          { // Registrar Usuario
            System.out.println("Opciones de registro de usuarios");
            System.out.println("Nombre");
            System.out.println("Apellido");
            System.out.println("Tipo de documento de identidad");
            System.out.println("Numero de documento de identidad");
            System.out.println("Fecha de nacimiento");
            System.out.println("Genero");
            System.out.println("Direccion");
            System.out.println("Telefono");
            System.out.println("Correo Electronico");
            break;
          }

        case 2:
          { // Reservar Habitacion
            System.out.println("Confirmar Seleccion del Huesped");
            System.out.println("Procesar pago");
            break;
          }
        case 3:
          { // Cancelar reserva
            System.out.println("Cancelar Reserva del huesped");

            break;
          }
        case 4:
          { // Solicitar Membrecia
            System.out.println("Procesar solicitud de membrecia");
            System.out.println("Enviar correo electronico de confirmacion");

            break;
          }
        case 5:
          { // Cancelar Membrecia
            System.out.println("Cancelar membrecia");
            System.out.println("Enviar enviar correo de confirmacion");
            break;
          }
        case 6:
          { // Cerrar la applicacion
            System.out.println("La aplicacion se ha cerrado con exito");
            opt = 0;
            break;
          }
      }
    } while (close != 0);
  }
}
