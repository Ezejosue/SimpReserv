package com.entity;

import com.enums.RoomStatus;
import com.model.simpreserv.Room;

import java.util.Map;

public interface IRoomController {
    Map<Integer, Room> loadRoomsList();
    void saveRoomsList(Map<Integer, Room> roomsList);
    void addNewRoom(Room newRoomInfo);
    Room findRoomById(int roomId);;
    Room findRoomByRoomNumber(int roomNumber);
    Map<Integer, Room> findRoomByRoomType(String roomType);
    void updateRoomById(int roomId, Room newRoomInfo);
    void updateRoomStatusById(int roomId, RoomStatus roomStatus);
    void deleteRoomById(int roomId);
    void printRoomsList();
}
