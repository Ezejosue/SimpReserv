package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;
import enums.RoomFloor;
import enums.RoomStatus;
import java.util.Map;
import java.util.TreeMap;

public class ResetData {
  public void resetHotelData() {
    Hotel myHotel = new Hotel(1, "Hotel Sea Sand", "Caribean Coast", "4 Stars", 15);
    HotelMethods hotelData = new HotelMethods();
    hotelData.updateRecord(myHotel);
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
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        2,
        new Room(
            2,
            12,
            RoomFloor.FIRST,
            "Suite",
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        3,
        new Room(
            3,
            13,
            RoomFloor.FIRST,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        4,
        new Room(
            4,
            14,
            RoomFloor.FIRST,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        5,
        new Room(
            5,
            15,
            RoomFloor.FIRST,
            "Suite with dining room and kitchen",
            "With sea sight",
            124.99f,
            "Triple",
            RoomStatus.AVAILABLE));

    rooms.put(
        6,
        new Room(
            6,
            21,
            RoomFloor.SECOND,
            "Suite",
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        7,
        new Room(
            7,
            22,
            RoomFloor.SECOND,
            "Suite",
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        8,
        new Room(
            8,
            23,
            RoomFloor.SECOND,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        9,
        new Room(
            9,
            24,
            RoomFloor.SECOND,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        10,
        new Room(
            10,
            25,
            RoomFloor.SECOND,
            "Suite with dining room and kitchen",
            "With sea sight",
            124.99f,
            "Triple",
            RoomStatus.AVAILABLE));

    rooms.put(
        11,
        new Room(
            11,
            31,
            RoomFloor.THIRD,
            "Suite",
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        12,
        new Room(
            12,
            32,
            RoomFloor.THIRD,
            "Suite",
            "With pool sight",
            84.99f,
            "Single",
            RoomStatus.AVAILABLE));
    rooms.put(
        13,
        new Room(
            13,
            33,
            RoomFloor.THIRD,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        14,
        new Room(
            14,
            34,
            RoomFloor.THIRD,
            "Suite with kitchen",
            "With street sight",
            94.99f,
            "Double",
            RoomStatus.AVAILABLE));
    rooms.put(
        15,
        new Room(
            15,
            35,
            RoomFloor.THIRD,
            "Penhouse with terrace and interior pool",
            "With sea sight",
            224.99f,
            "Penhouse",
            RoomStatus.AVAILABLE));

    RoomMethods roomData = new RoomMethods();
    roomData.saveAllRecords(rooms);
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
            1200.00f,
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
            950.50f,
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
            650.00f,
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
            699.00f,
            EmployeeStatus.HIRED,
            "Atencion al Cliente",
            "Nocturno"));

    EmployeeMethods empData = new EmployeeMethods();
    empData.saveAllRecords(employees);
  }

  public static void main(String[] args) {
    ResetData rs = new ResetData();
    rs.resetHotelData();
    rs.resetRoomData();
    rs.resetEmployeeData();
  }
}
