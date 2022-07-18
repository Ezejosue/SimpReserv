package com.model.simpreserv;

import com.controller.*;
import com.enums.EmployeeStatus;
import com.enums.ReservationStatus;
import com.enums.RoomStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
  Scanner sc = new Scanner(System.in);
  Validator val = new Validator();
  Loger log = new Loger();
  public void loggingMenu(String user, String pass) throws ParseException {
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

  public void login() throws ParseException {
    System.out.println("Ingresa tu usuario: ");
    String user = sc.nextLine();

    System.out.println("Ingresa tu clave: ");
    String password = sc.nextLine();

    loggingMenu(user, password);
  }

  public void initialize(){

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
    try {
      option = Integer.parseInt(sc.nextLine());
      if (option == 1) {

        login();

      } else {
        System.exit(0);
        sc.close();
      }
    } catch (Exception ex){
        log.error(ex.getMessage());
        System.out.println("Ocurrio un error en la ejecucion del programa");
        sc.close();
    }
  }

  public void userMenu() throws ParseException {
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
          "******           3-Cancelar reservacion                               ******");
      System.out.println(
          "******           4-Mostrar cliente                                    ******");
      System.out.println(
          "******           5-Buscar cliente por id o documento de identidad     ******");
      System.out.println(
          "******           6-Actualizar datos de cliente                        ******");
      System.out.println(
          "******           7-Solicitar membresia                                ******");
      System.out.println(
          "******           8-Cancelar membresia                                 ******");
      System.out.println(
          "******           9-Cerrar sesion                                      ******");
      System.out.println(
          "****************************************************************************");

      int opt = Integer.parseInt(sc.nextLine());
      switch (opt) {
        case 1: { // Agregar clientes
            id = 0;
            System.out.print("Ingrese el nombre del cliente: ");
            completeName = sc.nextLine();
            System.out.print("Ingrese la fecha de nacimiento del cliente: ");
            birthDay = sc.nextLine();
            System.out.print("Ingrese el genero del cliente: ");
            gender = sc.nextLine();
            System.out.print("Ingrese el numero de documento de identidad: ");
            numberOfDocument = sc.nextLine();
            System.out.print("Ingrese el correo del cliente: ");
            email = sc.nextLine();

            if (val.validateLetters(completeName)&&val.validateGender(gender)&&val.validateEmail(email)){

              cl = new Client(membership, creditCardInfo, id, completeName, birthDay, gender, numberOfDocument, email);
              cl.addClient(cl);
              System.out.println("Cliente agregado satisfactoriamente.");

              userMenu();
            } else {
              userMenu();
            }

            break;
          }
        case 2: { // Crear reserva
            idReserva = 0;
            System.out.println("** Seleccione el cliente para hacer la reservacion. **");
            System.out.println("** Busque al cliente con las siguientes opciones:");
            System.out.println("**** Digite 1 para buscar por numero de documento");
            System.out.println("**** Digite 2 para buscar por Id");
            System.out.println("**** Digite 3 para buscar por nombre");
            int opcion = Integer.parseInt(sc.nextLine());
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento del cliente a buscar: ");
              numberOfDocument = sc.nextLine();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              cl = cl.searchClientById(id);
            } else if (opcion == 3) {
              System.out.print("Ingrese el nombre del cliente a buscar: ");
              completeName = sc.nextLine();
              cl = cl.searchClientByName(completeName);
            }
            if (!val.validateClientExists(cl)){
                userMenu();
                break;
            }
            System.out.println("Resultado: " + cl.toString());
            id = cl.getId();
            System.out.println("Verificando si cliente tiene reservacion activa...");
            if (val.validateClientHasReservation(id)){
                userMenu();
                break;
            }
            System.out.println("Seleccione la habitacion a reservar.");
            room = new Room();
            room.printRooms();
            System.out.print("Ingrese el numero de habitacion: ");
            roomNum = Integer.parseInt(sc.nextLine());
            room = room.searchRoomByNumber(roomNum);
            if (!val.validateRoomExists(room)){
                userMenu();
                break;
            }
            if (!val.validateRoomAvailable(room)){
                userMenu();
                break;
            }
            idRoom = room.getId();
            System.out.print("Ingrese la fecha de inicio de la reservacion: ");
            String sTemp = sc.nextLine();
            Date dateStart = val.formatDate(sTemp);
            System.out.print("Ingrese la fecha de fin de la reservacion: ");
            sTemp = sc.nextLine();
            Date dateEnd = val.formatDate(sTemp);

            LocalDate checkIn = val.dateToLocalDate(dateStart);
            LocalDate checkOut = val.dateToLocalDate(dateEnd);

            long days = val.countDays(dateStart, dateEnd);
            double priceReserva = days * room.getRoomPrice();

            emp = new Employee();
            emp = emp.searchEmployeeById(3);

            reserva = new Reservation(idReserva, cl, emp, room, LocalDate.now(), checkIn, checkOut, priceReserva, ReservationStatus.CONFIRM, false);
            reserva.createReservation(reserva);

            room.changeRoomStatusById(idRoom, RoomStatus.BUSY);

            System.out.println("La reservacion se ha realizado satisfactoriamente.");

            /*Hotel hotel = new Hotel().loadHotelInfo();
            CreateFile createFile = new CreateFile();
            createFile.setCreateFile(hotel, cl, room);

            SendEmail sendEmail = new SendEmail();
            sendEmail.createAndSendEmail("tonyvasqueza002@gmail.com", "Reserva del hotel Sea Sand",
                    "En el archivo adjunto esta toda la informacion de su reserva" + "\n" + "\n" + "Saludos cordiales");
            System.out.println("Se ha enviado correo de confirmacion de reservacion.");
*/
            System.out.println("** Listado de reservaciones activas **");
            reserva.printReservations();
            userMenu();
            break;
          }
        case 3: { //Cancelar reservación
          reserva = new Reservation();
          idReserva = 0;
          System.out.println("** Seleccione la reservacion a cancelar **");
          System.out.println("** Busque la reservacion con las siguientes opciones:");
          System.out.println("**** Digite 1 para buscar por numero de reservacion");
          System.out.println("**** Digite 2 para buscar por nombre de cliente");
          int opcion = Integer.parseInt(sc.nextLine());
          if (opcion == 1) {
            System.out.print("Ingrese el numero de reservacion a buscar: ");
            idReserva = Integer.parseInt(sc.nextLine());
            reserva = reserva.searchReservationById(idReserva);
              if (!val.validateReservationById(reserva)){
                  userMenu();
                  break;
              }
          } else if (opcion == 2) {
            System.out.print("Ingrese el nombre del cliente a buscar: ");
            completeName = sc.nextLine();
            reserva = reserva.searchReservationByClientName(completeName);
            idReserva = reserva.getId();
              if (!val.validateReservationByName(reserva)){
                  userMenu();
                  break;
              }
          }

          System.out.println("Resultado de la busqueda: ");
          System.out.println(reserva.toString());
          System.out.print("Confirme la reservacion a cancelar (Y/N): ");
          String confirm = sc.nextLine();
          if (confirm.equals("Y") || (confirm.equals("y"))){
            reserva.updateReservationStatusById(idReserva, ReservationStatus.CANCELLED);
          }

          System.out.println("** Listado de reservaciones activas **");
          reserva.printReservations();
          userMenu();
          break;
        }
        case 4: { // Mostrar Clientes
            cl = new Client();
            cl.printClients();

            userMenu();
            break;
          }
        case 5: {
            System.out.print(
                "Digite 1 para buscar cliente por documeto de identidad o 2 para buscar cliente por Id:");
            int opcion = Integer.parseInt(sc.nextLine());
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento de cliente a buscar: ");
              numberOfDocument = sc.nextLine();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              cl = cl.searchClientById(id);
            }
            System.out.println("Resultado: " + cl.toString());
            userMenu();
            break;
          }
        case 6: {
          System.out.print(
              "Digite 1 para buscar cliente por documento de identidad o 2 para buscar cliente por Id:");
          int opcion = Integer.parseInt(sc.nextLine());
          cl = new Client();
          if (opcion == 1) {
            System.out.print("Ingrese el numero de documento de cliente a buscar: ");
            numberOfDocument = sc.nextLine();
            cl = cl.searchClientByDocNumber(numberOfDocument);
          } else if (opcion == 2) {
            System.out.print("Ingrese el id de cliente a buscar: ");
            id = Integer.parseInt(sc.nextLine());
            cl = cl.searchClientById(id);
          }
          id = cl.getId();
          System.out.println("Resultado: " + cl.toString());
          System.out.println("Seleccione el campo que desea modificar (1 - 5): ");
          System.out.println("**** 1 - Nombre");
          System.out.println("**** 2 - Fecha de nacimiento");
          System.out.println("**** 3 - Genero");
          System.out.println("**** 4 - Numero de documento");
          System.out.println("**** 5 - Correo");
          opcion = Integer.parseInt(sc.nextLine());

          switch (opcion) {
            case 1:
              System.out.print("Digite el nuevo nombre: ");
              completeName = sc.nextLine();
              cl.setName(completeName);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 2:
              System.out.print("Digite su fecha de nacimiento: ");
              birthDay = sc.nextLine();
              cl.setDateOfBirth(birthDay);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 3:
              System.out.print("Digite el nuevo genero: ");
              gender = sc.nextLine();
              cl.setGender(gender);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 4:
              System.out.print("Digite el nuevo numero de documento: ");
              numberOfDocument = sc.nextLine();
              cl.setNumberOfDocument(numberOfDocument);
              cl.updateClientById(id, cl);
              userMenu();
              break;
            case 5:
              System.out.print("Digite el nuevo email: ");
              email = sc.nextLine();
              cl.setEmail(email);
              cl.updateClientById(id, cl);
              userMenu();
              break;
          }
          break;
        }
        case 7: {//Solicitar Membresia
          ControllerEmployee cm=new ControllerEmployee();
          cm.membershipMenu();
          userMenu();
          break;
        }
        case 8: {//Cancelar Membresia
          ControllerEmployee cm=new ControllerEmployee();
          cm.cancelMenu();
          userMenu();
          break;
        }
        case 9: { // Cerrar la aplicacion
          initialize();
          opt = 0;
          break;
        }
        default:
        {
          System.out.println("Ingrese una opcion valida");
          userMenu();
        };
      }
    } while (close != 0);
  }

  public void employeeMenu() {
    int close = 0;

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
    Client cl;
    Employee emp;
    Reservation reserva;


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
              "******           7-Actualizar Usuario                                 ******");
      System.out.println(
              "******           8-Eliminar reserva                                   ******");
      System.out.println(
              "******           9-Eliminar cliente                                   ******");
      System.out.println(
              "******           10-Eliminar reserva                                  ******");
      System.out.println(
              "******           11-Gestion de Pagos                                  ******");
      System.out.println(
              "******           12-Gestion de tarjetas de credito                    ******");
      System.out.println(
              "******           13-Cerrar sesion                                     ******");
      System.out.println(
          "****************************************************************************");
      int opt = Integer.parseInt(sc.nextLine());
      switch (opt) {
        case 1: { // Registrar Empleado
            id = 0;
            status = EmployeeStatus.HIRED;

            System.out.print("Ingrese el nombre del empleado: ");
            name = sc.nextLine();
            System.out.print("Ingrese la fecha de nacimiento del empleado: ");
            dateOfBirth = sc.nextLine();
            System.out.print("Ingrese el genero del empleado: [M / F]");
            gender = sc.nextLine();
            System.out.print("Ingrese el numero de documento de identidad: ");
            numberOfDocument = sc.nextLine();
            System.out.print("Ingrese el correo del empleado: ");
            email = sc.nextLine();
            System.out.print("Ingrese el numero de carnet de empleado: ");
            cardCompany = sc.nextLine();
            System.out.print("Ingrese el salario del empleado: ");
            salary = sc.nextFloat();
            System.out.print("Ingrese el puesto de trabajo del empleado: ");
            position = sc.nextLine();
            System.out.print("Ingrese el turno de trabajo del empleado: ");
            schedule = sc.nextLine();

            if (val.validateLetters(name)&&val.validateGender(gender)&&val.validateEmail(email)&&val.validateNumbers(salary))
            {

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
                System.out.println("Empleado ingresado exitosamente!");
                System.out.println("Presione enter para continuar...");
                new java.util.Scanner(System.in).nextLine();
                employeeMenu();
            }else {
              System.out.println("Intentelo de nuevo");
              System.out.println("Presione enter para continuar...");
              new java.util.Scanner(System.in).nextLine();
              employeeMenu();
            }
            break;
          }
        case 2: { // Actualizar empleado
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = Integer.parseInt(sc.nextLine());
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.nextLine();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              emp = emp.searchEmployeeById(id);
            }
            id = emp.getId();
            System.out.println("Resultado: " + emp);
            System.out.println("Seleccione el campo que desea modificar (1 - 10): ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
              case 1:
                System.out.print("Digite el nuevo nombre: ");
                name = sc.nextLine();
                emp.setName(name);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 2:
                System.out.print("Digite su fecha de cumpleaños: ");
                dateOfBirth = sc.nextLine();
                emp.setDateOfBirth(dateOfBirth);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 3:
                System.out.print("Digite el nuevo genero: ");
                gender = sc.nextLine();
                emp.setGender(gender);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 4:
                System.out.print("Digite el nuevo numero de documento: ");
                numberOfDocument = sc.nextLine();
                emp.setNumberOfDocument(numberOfDocument);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 5:
                System.out.print("Digite el nuevo email: ");
                email = sc.nextLine();
                emp.setEmail(email);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 6:
                System.out.print("Digite el nuevo carnet: ");
                cardCompany = sc.nextLine();
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
                int selection = Integer.parseInt(sc.nextLine());
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
                position = sc.nextLine();
                emp.setPosition(position);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
              case 10:
                System.out.print("Digite el nuevo horario: ");
                schedule = sc.nextLine();
                emp.setSchedule(schedule);
                emp.updateEmployeeById(id, emp);
                employeeMenu();
                break;
            }

            break;
          }
        case 3: { // Buscar empleado
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = Integer.parseInt(sc.nextLine());
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.nextLine();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              emp = emp.searchEmployeeById(id);
            }
            System.out.println("Resultado: " + emp.toString());
            employeeMenu();
            break;
          }
        case 4: { // Mostrar empleados
            emp = new Employee();
            emp.printEmployees();

            employeeMenu();
            break;
          }
        case 5: { // Eliminar empleado
            System.out.print(
                "Digite 1 para buscar empleado por carnet o 2 para buscar empleado por Id:");
            int opcion = Integer.parseInt(sc.nextLine());
            emp = new Employee();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de carnet de empleado a buscar: ");
              cardCompany = sc.nextLine();
              emp = emp.searchEmployeeByCarnet(cardCompany);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de empleado a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              emp = emp.searchEmployeeById(id);
            }
            id = emp.getId();
            System.out.println("Resultado: " + emp.toString());
            System.out.print("Seguro que desea eliminar este empleado? Y/N");
            String eleccion = sc.next();
            if ((eleccion.equals("Y")) || (eleccion.equals("y"))) {
              emp.deleteEmployeeById(id);
            }
            employeeMenu();
            break;
          }
        case 6: { // Registrar usuario
          UserValidator validate = new UserValidator();
          User usr;
          Calendar calendar = Calendar.getInstance();

          Date dateObj = calendar.getTime();
          id = 0;
          String user, pass;
          int typeUser;
          System.out.print("Ingrese el nombre del usuario: ");
          user = sc.nextLine();
          System.out.print("Ingrese la clave: ");
          pass = sc.nextLine();
          System.out.print("Ingrese el tipo de usuario: 1 para cliente y 2 para usuario: ");
          typeUser = Integer.parseInt(sc.nextLine());

          if (validate.formatUsername(user)&&validate.formatPassword(pass)&&validate.validateTypeUser(typeUser)){
            usr =
                new User(
                    id,
                    user,
                    pass,
                    typeUser,
                    dateObj);

            usr.addUser(usr, user);
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
            employeeMenu();
          } else {
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
            employeeMenu();
          }



          break;
        }
        case 7: {//Actualizar usuario
          User usr;
          id = 0;
          System.out.print(
              "Digite 1 para buscar usuario por id o 2 para buscar por username: ");
          int opcion = Integer.parseInt(sc.nextLine());
          usr = new User();
          if (opcion == 1) {
            System.out.print("Ingrese el id del usuario a buscar: ");
            id = Integer.parseInt(sc.nextLine());
            usr = usr.searchUserById(id);
          } else if (opcion == 2) {
            System.out.print("Ingrese el username del usuario a buscar: ");
            String Uname = sc.nextLine();
            usr = usr.searchUserByName(Uname);
          }

          id = usr.getId();
          System.out.println("Resultado: " + usr.toString());
          System.out.println("Seleccione el campo que desea modificar (1 - 3): ");
          opcion = Integer.parseInt(sc.nextLine());
          switch (opcion) {
            case 1:
              System.out.print("Digite el nuevo nombre: ");
              String user = sc.nextLine();
              usr.setUserName(user);
              usr.updateUserById(id, usr);
              employeeMenu();
              break;
            case 2:
              System.out.print("Digite la nueva clave: ");
              String pass = sc.nextLine();
              usr.setPassword(pass);
              usr.updateUserById(id, usr);
              employeeMenu();
              break;
            case 3:
              System.out.print("Digite el tipo de usuario: ");
              int type = Integer.parseInt(sc.nextLine());
              usr.setTypeOfUser(type);
              usr.updateUserById(id, usr);
              employeeMenu();
              break;
          }
          break;
        }
        case 8: {//Eliminar reserva
          reserva = new Reservation();
          int idReserva = 0;
          System.out.println("** Seleccione la reservacion a eliminar **");
          System.out.println("** Busque la reservacion con las siguientes opciones:");
          System.out.println("**** Digite 1 para buscar por numero de reservacion");
          System.out.println("**** Digite 2 para buscar por nombre de cliente");
          int opcion = Integer.parseInt(sc.nextLine());
          if (opcion == 1) {
            System.out.print("Ingrese el numero de reservacion a buscar: ");
            idReserva = Integer.parseInt(sc.nextLine());
            reserva = reserva.searchReservationById(idReserva);
              if (!val.validateReservationById(reserva)){
                  employeeMenu();
                  break;
              }
          } else if (opcion == 2) {
            System.out.print("Ingrese el nombre del cliente a buscar: ");
            name = sc.nextLine();
            reserva = reserva.searchReservationByClientName(name);
            idReserva = reserva.getId();
              if (!val.validateReservationByName(reserva)){
                  employeeMenu();
                  break;
              }
          }
          System.out.println("Resultado de la busqueda: ");
          System.out.println(reserva.toString());
          System.out.print("Confirme la reservacion a eliminar (Y/N): ");
          String confirm = sc.nextLine();
          if (confirm.equals("Y") || (confirm.equals("y"))){
            reserva.deleteReservationById(idReserva);
          }

          System.out.println("** Listado de reservaciones activas **");
          reserva.printReservations();
          employeeMenu();
          break;
        }
        case 9: {//Eliminar cliente
          try {
            System.out.print(
                "Digite 1 para buscar cliente por numero de documento o 2 para buscarlo por Id:");
            int opcion = Integer.parseInt(sc.nextLine());
            cl = new Client();
            if (opcion == 1) {
              System.out.print("Ingrese el numero de documento del cliente a buscar: ");
              numberOfDocument = sc.nextLine();
              cl = cl.searchClientByDocNumber(numberOfDocument);
            } else if (opcion == 2) {
              System.out.print("Ingrese el id de cliente a buscar: ");
              id = Integer.parseInt(sc.nextLine());
              cl = cl.searchClientById(id);
            }
            id = cl.getId();
            System.out.println("Resultado: " + cl.toString());
            System.out.print("Seguro que desea eliminar este cliente? Y/N");
            String eleccion = sc.nextLine();
            if ((eleccion.equals("Y")) || (eleccion.equals("y"))) {
              cl.deleteClientById(id);
            }
            employeeMenu();
          } catch (Exception ex){
            System.out.println("Ocurrio un error" + ex.getMessage());
          }
          break;
        }
        case 10: {
          ResetData rs = new ResetData();
          rs.resetData();
          break;
        }
        case 11:{//Gestion de pagos
          System.out.println("Esta es la seccion de gestion de pagos");
          System.out.println("1-Procesar pagos, 2-Cancelar pagos");
          int opt2=Integer.parseInt(sc.nextLine());
          switch (opt2){
            case 1:{
              ControllerEmployee cm=new ControllerEmployee();
              cm.processPaymentMenu();
              employeeMenu();
              break;
            }
            case 2:{
              ControllerEmployee cm=new ControllerEmployee();
              cm.cancelPaymentMenu();
              employeeMenu();
              break;
            }
            default:{
              System.out.println("Ingrese una opcion valida.");
            }
          }
          employeeMenu();
          break;
        }
        case 12:{//Gestion de tarjetas de credito
          System.out.println("Esta es la seccion de gestion de tarjetas de credito");
          System.out.println("1-Agregar tarjeta, 2-Eliminar tarjeta, 3-Ver informacion de la tarjeta");
          int opt2=Integer.parseInt(sc.nextLine());
          switch (opt2){
            case 1:{
              ControllerEmployee cm=new ControllerEmployee();
              cm.addCardMenu();
              employeeMenu();
              break;
            }
            case 2:{
              ControllerEmployee cm=new ControllerEmployee();
              cm.removeCardMenu();
              employeeMenu();
              break;
            }
            case 3:{
              ControllerEmployee cm=new ControllerEmployee();
              cm.cardInfoMenu();
              employeeMenu();
              break;
            }
          }
          break;
        }
          case 13:
          { // Cerrar la applicacion
            initialize();
            opt = 0;
            break;
          }
        default:
        {
          System.out.println("Ingrese una opcion valida");
          employeeMenu();
        };
      }
    } while (close != 0);
  }

}
