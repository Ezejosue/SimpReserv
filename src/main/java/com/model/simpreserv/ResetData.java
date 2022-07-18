package com.model.simpreserv;

import com.controller.*;
import com.enums.EmployeeStatus;
import com.enums.ReservationStatus;
import com.enums.RoomFloor;
import com.enums.RoomStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import java.util.Calendar;

public class ResetData {
  public void resetHotelData() {
    Hotel myHotel = new Hotel(1, "Hotel Sea Sand", "Caribean Coast", "4 Stars", 15);
    myHotel.saveHotelInfo(myHotel);
  }

  public void resetRoomData() {
    Map<Integer, Room> rooms = new TreeMap<>();
    rooms.put(
        1,
        new Room(
            1,
            11,
            RoomFloor.FIRST,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        2,
        new Room(
            2,
            12,
            RoomFloor.FIRST,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        3,
        new Room(
            3,
            13,
            RoomFloor.FIRST,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        4,
        new Room(
            4,
            14,
            RoomFloor.FIRST,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        5,
        new Room(
            5,
            15,
            RoomFloor.FIRST,
            "Suite with dining room and kitchen",
            124.99,
            "Triple",
            RoomStatus.AVAILABLE));

    rooms.put(
        6,
        new Room(
            6,
            21,
            RoomFloor.SECOND,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        7,
        new Room(
            7,
            22,
            RoomFloor.SECOND,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        8,
        new Room(
            8,
            23,
            RoomFloor.SECOND,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        9,
        new Room(
            9,
            24,
            RoomFloor.SECOND,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        10,
        new Room(
            10,
            25,
            RoomFloor.SECOND,
            "Suite with dining room and kitchen",
            124.99,
            "Triple",
            RoomStatus.AVAILABLE));

    rooms.put(
        11,
        new Room(
            11,
            31,
            RoomFloor.THIRD,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        12,
        new Room(
            12,
            32,
            RoomFloor.THIRD,
            "Suite",
            84.99,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        13,
        new Room(
            13,
            33,
            RoomFloor.THIRD,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        14,
        new Room(
            14,
            34,
            RoomFloor.THIRD,
            "Suite with kitchen",
            94.99,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        15,
        new Room(
            15,
            35,
            RoomFloor.THIRD,
            "Penhouse with terrace and interior pool",
            224.99,
            "Penhouse",
            RoomStatus.AVAILABLE));

    Room room = new Room();
    room.saveRoomsList(rooms);
  }

  public void resetEmployeeData() {
    Map<Integer, Employee> employees = new TreeMap<>();
    employees.put(
        1,
        new Employee(
            1,
            "Juan Perez",
            "1985-03-18",
            "M",
            "123456-7",
            "jperez@elhotel.com",
            "0001",
            1200.00,
            EmployeeStatus.HIRED,
            "Gerente",
            "Diurno"));
    employees.put(
        2,
        new Employee(
            2,
            "Tony Stark",
            "1969-10-04",
            "M",
            "365874-9",
            "tstark@elhotel.com",
            "0002",
            950.50,
            EmployeeStatus.HIRED,
            "Jefe de Mantenimiento",
            "Diurno"));
    employees.put(
        3,
        new Employee(
            3,
            "Wanda Maximoff",
            "1995-03-21",
            "F",
            "637489-4",
            "wmaximoff@elhotel.com",
            "0003",
            650.00,
            EmployeeStatus.HIRED,
            "Atencion al Cliente",
            "Diurno"));
    employees.put(
        4,
        new Employee(
            4,
            "Natasha Romanoff",
            "1991-03-21",
            "F",
            "748965-1",
            "nromanoff@elhotel.com",
            "0004",
            699.00,
            EmployeeStatus.HIRED,
            "Atencion al Cliente",
            "Nocturno"));

    Employee employee = new Employee();
    employee.saveAllEmployees(employees);
  }

  public void resetClientData(){
    Map<Integer,Client> clients = new TreeMap<>();

    Membership ms = new Membership();
    CreditCard cc = new CreditCard();

    clients.put(1, new Client(ms, cc, 1, "Jhon Doe", "18/02/1987", "M", "123456", "cliente1@email.com"));
    clients.put(2, new Client(ms, cc, 2, "Diana Prince", "30/11/1999", "F", "987654", "cliente2@email.com"));
    clients.put(3, new Client(ms, cc, 3, "Ana de Armas", "30/04/1988", "F", "654789", "cliente3@email.com"));
    clients.put(4, new Client(ms, cc, 4, "Jose Ramirez", "25/07/1978", "M", "869587", "cliente4@email.com"));

    Client client = new Client();
    client.saveClientsList(clients);
  }

  public void resetReservationData(){
    Map<Integer, Reservation> reservations = new TreeMap<>();

    Membership ms = new Membership();
    CreditCard cc = new CreditCard();
    Client clt;
    Employee emp;
    Room room;

    emp = new Employee(3, "Wanda Maximoff", "1995-03-21", "F", "637489-4", "wmaximoff@elhotel.com", "0003", 650.00, EmployeeStatus.HIRED, "Atencion al Cliente", "Diurno");
    RoomMethods rm=new RoomMethods();
    ClientMethods cm=new ClientMethods();
    reservations.put(1, new Reservation(1, cm.findRecordById(1),
            emp.searchEmployeeById(1), rm.findRecordById(1),
            LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-18"),
            LocalDate.parse("2022-01-20"),
            224.99, ReservationStatus.HOLD,
            false));
    reservations.put(2, new Reservation(2, cm.findRecordById(2),
            emp.searchEmployeeById(2), rm.findRecordById(2),
            LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-18"),
            LocalDate.parse("2022-01-20"),
            224.99, ReservationStatus.HOLD,
            false));
    reservations.put(3, new Reservation(3, cm.findRecordById(3),
            emp.searchEmployeeById(3), rm.findRecordById(3),
            LocalDate.parse("2022-01-15"), LocalDate.parse("2022-01-18"),
            LocalDate.parse("2022-01-20"),
            224.99, ReservationStatus.HOLD,
            false));

    Reservation reservation = new Reservation();
    reservation.saveAllReservations(reservations);
  }

  public void resetUserData(){
    Calendar calendar = Calendar.getInstance();
    Date dateObj = calendar.getTime();
    Map<Integer,User> users = new TreeMap<>();

    users.put(1, new User(1, "Josue", "1234", 1, dateObj));
    users.put(2, new User(2, "Carlos", "123", 2, dateObj));
    users.put(3, new User(3, "Stalyn", "12345", 1, dateObj));

    UserMethods userData = new UserMethods();
    userData.saveAllRecords(users);

  }

  public static void main(String[] args) {
    ResetData rs = new ResetData();
    rs.resetHotelData();
    rs.resetRoomData();
    rs.resetEmployeeData();
    rs.resetClientData();
    rs.resetReservationData();
    rs.resetUserData();
  }
}
