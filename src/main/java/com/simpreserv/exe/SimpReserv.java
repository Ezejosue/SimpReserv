package com.simpreserv.exe;

import com.hotelreservation.simpreserv.*;
import controller.ControllerClient;
import enums.RoomFloor;
import enums.RoomStatus;

import java.util.Date;

import static enums.RoomFloor.TERCERO;
import static enums.RoomStatus.AVAILABLE;

public class SimpReserv {

    public static void main(String[] args) {

        Room room= new Room(101,TERCERO,"Bueno","","Simple", AVAILABLE);

        room.roomInfo("Simple");

    }
}
