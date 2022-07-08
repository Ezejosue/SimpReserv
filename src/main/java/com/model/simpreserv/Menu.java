package com.model.simpreserv;

import com.controller.ClientMethods;
import com.controller.ControllerEmployee;
import com.controller.EmployeeMethods;
import com.controller.RoomMethods;
import com.enums.EmployeeStatus;
import java.util.Calendar;
import java.util.Date;
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
      initialize();
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
    int id;
    Membership membership = new Membership();
    CreditCard creditCardInfo = new CreditCard();
    String completeName;
    String birthDay;
    String gender;
    String numberOfDocument;
    String email;
    Client cl;

    Reservation reserva;
    int idReserva;
    Room room;
    int idRoom;
    int roomNum;
    Employee emp;

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
          "******           1-Registrar cliente                                  ******");
      System.out.println(
          "******           2-Crear reservacion                                  ******");
      System.out.println(
          "******           3-Eliminar cliente                                   ******");
      System.out.println(
          "******           4-Mostrar cliente                                    ******");
      System.out.println(
          "******           5-Buscar cliente por id o documento de identidad     ******");
      System.out.println(
          "******           6-Actualizar datos de cliente                        ******");
      System.out.println(
          "******           7-Salir                                              ******");
      System.out.println(
          "****************************************************************************");

      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          { // Agregar clientes
            id = 0;
            System.out.print("Ingrese el nombre del cliente: ");
            completeName = sc.next();
            System.out.print("Ingrese la fecha de nacimiento del cliente: ");
            birthDay = sc.next();
            System.out.print("Ingrese el genero del cliente: ");
            gender = sc.next();
            System.out.print("Ingrese el numero de documento de identidad: ");
            numberOfDocument = sc.next();
            System.out.print("Ingrese el correo del cliente: ");
            email = sc.next();

            cl = new Client(membership, creditCardInfo, id, completeName, birthDay, gender, numberOfDocument, email);
            cl.addClient(cl);

            System.out.println("Cliente agregado satisfactoriamente.");

            userMenu();
            break;
          }
        case 2:
          { // Crear reserva
            id = 0;
            idRoom = 0;
            idReserva = 0;
            System.out.println("Seleccione el cliente para hacer la reservacion.");
            System.out.println("Digite 1 para buscar cliente por numero de documento o 2 para buscarlo por Id:");
            int opcion = sc.nextInt();
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento del cliente a buscar: ");
              numberOfDocument = sc.next();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = sc.nextInt();
              cl = cl.searchClientById(id);
            }
            id = cl.getId();
            System.out.println("Resultado: " + cl.toString());
            System.out.println("Seleccione la habitacion a reservar.");
            RoomMethods rmData = new RoomMethods();
            rmData.showRooms();
            System.out.print("Ingrese el numero de habitacion: ");
            roomNum = sc.nextInt();

            room = new Room();
            room = room.searchRoomByNumber(roomNum);
            idRoom = room.getId();

            /*reserva = new Reservation(idReserva, cl);*/

            userMenu();
            break;
          }
        case 3:
          { // Eliminar cliente
            System.out.print(
                "Digite 1 para buscar cliente por numero de documento o 2 para buscarlo por Id:");
            int opcion = sc.nextInt();
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento del cliente a buscar: ");
              numberOfDocument = sc.next();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = sc.nextInt();
              cl = cl.searchClientById(id);
            }
            id = cl.getId();
            System.out.println("Resultado: " + cl.toString());
            System.out.print("Seguro que desea eliminar este cliente? Y/N");
            String eleccion = sc.next();
            if (eleccion.equals("Y")) {
              cl.deleteClientById(id);
            }
            userMenu();
            break;
          }
        case 4:
          { // Mostrar Clientes
            ClientMethods showCl = new ClientMethods();
            showCl.showClients();
            userMenu();
            break;
          }
        case 5:
          {
            System.out.print(
                "Digite 1 para buscar cliente por documeto de identidad o 2 para buscar cliente por Id:");
            int opcion = sc.nextInt();
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento de cliente a buscar: ");
              numberOfDocument = sc.next();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = sc.nextInt();
              cl = cl.searchClientById(id);
            }
            System.out.println("Resultado: " + cl.toString());
            employeeMenu();
            break;
          }

        case 6:
        {
          System.out.print(
              "Digite 1 para buscar cliente por documento de identidad o 2 para buscar cliente por Id:");
          int opcion = sc.nextInt();
          cl = new Client();
          if (opcion == 1) {
            System.out.print("Ingrese el numero de documento de cliente a buscar: ");
            numberOfDocument = sc.next();
            cl = cl.searchClientByDocNumber(numberOfDocument);
          } else if (opcion == 2) {
            System.out.print("Ingrese el id de cliente a buscar: ");
            id = sc.nextInt();
            cl = cl.searchClientById(id);
          }
          id = cl.getId();
          System.out.println("Resultado: " + cl.toString());
          System.out.println("Seleccione el campo que desea modificar (1 - 5): ");
          opcion = sc.nextInt();

          switch (opcion) {
            case 1:
              System.out.print("Digite el nuevo nombre: ");
              completeName = sc.next();
              cl.setName(completeName);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 2:
              System.out.print("Digite su fecha de cumpleaños: ");
              birthDay = sc.next();
              cl.setDateOfBirth(birthDay);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 3:
              System.out.print("Digite el nuevo genero: ");
              gender = sc.next();
              cl.setGender(gender);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 4:
              System.out.print("Digite el nuevo numero de documento: ");
              numberOfDocument = sc.next();
              cl.setNumberOfDocument(numberOfDocument);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 5:
              System.out.print("Digite el nuevo email: ");
              email = sc.next();
              cl.setEmail(email);
              cl.updateClientById(id, cl);
              userMenu();
              break;
          }
          break;
        }
        case 7:
        { // Cerrar la applicacion
          System.out.println("La aplicacion se ha cerrado con exito");
          opt = 0;
          break;
        }
      }
    } while (close != 0);
  }

  public void employeeMenu() {
    int close = 1;

    int id;
    String name;
    String dateOfBirth;
    String gender;
    String numberOfDocument;
    String email;
    String cardCompany;
    float salary;
    EmployeeStatus status;
    String position;
    String schedule;

    Employee emp;

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
          "******           3-Buscar Empleado por Id o Carnet                    ******");
      System.out.println(
          "******           4-Mostrar Empleados                                  ******");
      System.out.println(
          "******           5-Eliminar Empleado                                  ******");
      System.out.println(
          "******           6-Registrar Usuario                                  ******");
      System.out.println(
          "******           7-Reservar Habitacion                                ******");
      System.out.println(
          "******           8-Cancelar reserva                                   ******");
      System.out.println(
          "******           9-Solicitar Membrecia                                ******");
      System.out.println(
          "******           10-Cancelar Membrecia                                ******");
      System.out.println(
          "******           11-Salir                                             ******");
      System.out.println(
          "****************************************************************************");
      int opt = sc.nextInt();
      switch (opt) {
        case 1:
          { // Registrar Usuario
            id = 0;
            status = EmployeeStatus.HIRED;

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
            System.out.print("Ingrese el numero de carnet de empleado: ");
            cardCompany = sc.next();
            System.out.print("Ingrese el salario del empleado: ");
            salary = sc.nextFloat();
            System.out.print("Ingrese el puesto de trabajo del empleado: ");
            position = sc.next();
            System.out.print("Ingrese el turno de trabajo del empleado: ");
            schedule = sc.next();

            emp =
                new Employee(
                    id,
                    name,
                    dateOfBirth,
                    gender,
                    numberOfDocument,
                    email,
                    cardCompany,
                    salary,
                    status,
                    position,
                    schedule);
            emp.addEmployee(emp);

            System.out.println("Usuario agregado satisfactoriamente.");

            employeeMenu();
            break;
          }

        case 2:
          { // Reservar Habitacion
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = sc.nextInt();
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.next();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = sc.nextInt();
              emp = emp.searchEmployeeById(id);
            }
            id = emp.getId();
            System.out.println("Resultado: " + emp.toString());
            System.out.println("Seleccione el campo que desea modificar (1 - 10): ");
            opcion = sc.nextInt();

            switch (opcion) {
              case 1:
                System.out.print("Digite el nuevo nombre: ");
                name = sc.next();
                emp.setName(name);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 2:
                System.out.print("Digite su fecha de cumpleaños: ");
                dateOfBirth = sc.next();
                emp.setDateOfBirth(dateOfBirth);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 3:
                 System.out.print("Digite el nuevo genero: ");
                gender = sc.next();
                emp.setGender(gender);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 4:
                 System.out.print("Digite el nuevo numero de documento: ");
                numberOfDocument = sc.next();
                emp.setNumberOfDocument(numberOfDocument);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 5:
                 System.out.print("Digite el nuevo email: ");
                email = sc.next();
                emp.setEmail(email);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 6:
                 System.out.print("Digite el nuevo carnet: ");
                cardCompany = sc.next();
                emp.setCarnet(cardCompany);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 7:
                 System.out.print("Digite el nuevo salario: ");
                salary = sc.nextFloat();
                emp.setSalary(salary);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 8:
                 System.out.print("Digite el estado [ 1- HIRED, 2- FIRED O 3- SUSPENDED]: ");
                 int selection = sc.nextInt();
                if (selection==1){
                  emp.setStatus(EmployeeStatus.HIRED);
                  emp.updateEmployeeById(id, emp);
                  employeeMenu();
                } else if (selection==2){
                    emp.setStatus(EmployeeStatus.FIRED);
                    emp.updateEmployeeById(id, emp);
                    employeeMenu();
                } else {
                  emp.setStatus(EmployeeStatus.SUSPENDED);
                  emp.updateEmployeeById(id, emp);
                  employeeMenu();
                }
                break;
              case 9:
                 System.out.print("Digite el nuevo puesto: ");
                position = sc.next();
                emp.setPosition(position);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 10:
                 System.out.print("Digite el nuevo horario: ");
                schedule = sc.next();
                emp.setSchedule(schedule);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
            }

            break;
          }
        case 3:
          { // Cancelar reserva
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = sc.nextInt();
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.next();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = sc.nextInt();
              emp = emp.searchEmployeeById(id);
            }
            System.out.println("Resultado: " + emp.toString());
            employeeMenu();
            break;
          }
        case 4:
          { // Mostrar empleados
            EmployeeMethods employeeList = new EmployeeMethods();
            employeeList.showEmployees();
            employeeMenu();
            break;
          }
        case 5:
          { // Cancelar Empleado
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = sc.nextInt();
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.next();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = sc.nextInt();
              emp = emp.searchEmployeeById(id);
            }
            id = emp.getId();
            System.out.println("Resultado: " + emp.toString());
            System.out.print("Seguro que desea eliminar este empleado? Y/N");
            String eleccion = sc.next();
            if (eleccion.equals("Y")) {
              emp.deleteEmployeeById(id);
            }
            employeeMenu();
            break;
          }
        case 6:{//
          User usr;
          Calendar calendar = Calendar.getInstance();
          Date dateObj = calendar.getTime();
          id = 0;
          String user, pass;
          int typeUser;
          System.out.print("Ingrese el nombre del usuario: ");
          user = sc.next();
          System.out.print("Ingrese la clave: ");
          pass = sc.next();
          System.out.print("Ingrese el tipo de usuario: 1 para cliente y 2 para usuario: ");
          typeUser = sc.nextInt();
          usr =
              new User(
                  id,
                  user,
                  pass,
                  typeUser,
                  dateObj);
          usr.addUser(usr);

          System.out.println("Usuario agregado satisfactoriamente.");

          employeeMenu();
          break;
        }
        case 7:{//Reservar habitacion
          System.out.println("Este modulo aun esta en construccion");
          System.out.println("Lo sentimos mucho :(");
          break;
        }
        case 8:{//Cancelar reserva
          System.out.println("Este modulo aun esta en construccion");
          System.out.println("Lo sentimos mucho :(");
          break;
        }
        case 9:{//Solicitar membrecia
            ControllerEmployee cm=new ControllerEmployee();
            cm.membershipMenu();
          break;
        }
        case 10:{//Cancelar membrecia
          ControllerEmployee cm=new ControllerEmployee();
          cm.cancelMenu();
          break;
        }
          case 11:
          { // Cerrar la applicacion
            System.out.println("La aplicacion se ha cerrado con exito");
            opt = 0;
            close=opt;
            break;
          }
      }
    } while (close != 0);
  }
}
