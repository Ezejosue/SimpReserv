package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
        "******           2-Salir                                              ******");
    System.out.println(
        "****************************************************************************");

    int option = 0;
    option = sc.nextInt();
    if (option == 1) {

      login();

    } else {
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
          "******           1-Registrar Empleado                                 ******");
      System.out.println(
          "******           2-Actualizar Empleado                                ******");
      System.out.println(
          "******           3-Buscar Empleado por parametro                      ******");
      System.out.println(
          "******           4-Mostrar Empleados                                  ******");
      System.out.println(
          "******           5-Eliminar Empleado                                  ******");
      System.out.println(
          "******           6-Eliminar Cliente                                   ******");
      System.out.println(
          "******           7-Reservar Habitacion                                ******");
      System.out.println(
          "******           8-Cancelar reserva                                   ******");
      System.out.println(
          "******           9-Solicitar Membrecia                                ******");
      System.out.println(
          "******           10-Cancelar Membrecia                                 ******");
      System.out.println(
          "******           11-Salir                                              ******");
      System.out.println(
          "****************************************************************************");
      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          { // Registrar Usuario
            int id = 0;
            String name;
            String dateOfBirth;
            String gender;
            String numberOfDocument;
            String email;
            String cardCompany;
            float salary;
            EmployeeStatus status = EmployeeStatus.HIRED;
            String position;
            String schedule;
            System.out.print("Ingrese el nombre del empleado: ");
            name = sc.next();
            System.out.print("Ingrese la fecha de nacimiento del empleado: ");
            dateOfBirth = sc.next();
            System.out.print("Ingrese el genero del empleado: ");
            gender = sc.next();
            System.out.print("Ingrese el numero de documento de identidad: ");
            numberOfDocument = sc.next();
            System.out.print("Ingrese el correo del empleado: ");
            email = sc.next();
            System.out.print("Ingrese el numero de empleado (carnet): ");
            cardCompany = sc.next();
            System.out.print("Ingrese el salario del empleado: ");
            salary = sc.nextFloat();
            System.out.print("Ingrese el puesto de trabajo del empleado: ");
            position = sc.next();
            System.out.print("Ingrese el turno de trabajo del empleado: ");
            schedule = sc.next();

            Employee emp = new Employee(id, name, dateOfBirth, gender, numberOfDocument, email, cardCompany, salary, status, position, schedule);
            emp.addEmployee(emp);

            System.out.println("Usuario agregado satisfactoriamente.");
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
          { // Mostrar empleados
            EmployeeMethods employeeList = new EmployeeMethods();
            employeeList.showEmployees();

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
