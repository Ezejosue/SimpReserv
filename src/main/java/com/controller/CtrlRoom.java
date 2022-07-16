package com.controller;

import com.entity.IRoomController;
import com.enums.RoomStatus;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.Room;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CtrlRoom implements IRoomController {

    private static final String FILEPATH = "src\\main\\resources\\rooms.dat";

    @Override
    public Map<Integer, Room> loadRoomsList() {
        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
            ReadObject ro = new ReadObject(FILEPATH);
            return (Map<Integer, Room>) ro.loadInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveRoomsList(Map<Integer, Room> roomsList) {
        WriteObject wo = new WriteObject(FILEPATH, roomsList);
        wo.writeToFile();
    }

    @Override
    public void addNewRoom(Room newRoomInfo) {
        int lastId;
        Map<Integer, Room> list = this.loadRoomsList();
        if (list.size() != 0) {
            lastId = list.get(list.size()).getId();
        } else {
            lastId = 0;
        }
        lastId++;
        list.put(lastId, newRoomInfo);
        this.saveRoomsList(list);
    }

    @Override
    public Room findRoomById(int roomId) {
        Map<Integer, Room> list = this.loadRoomsList();
        return list.get(roomId);
    }

    @Override
    public Room findRoomByRoomNumber(int roomNumber) {
        Map<Integer, Room> list = this.loadRoomsList();
        Room room = new Room();
        for (Map.Entry<Integer, Room> item : list.entrySet()) {
            if (item.getValue().getRoomNumber() == roomNumber) {
                room = item.getValue();
                break;
            }
        }
        return room;
    }

    @Override
    public Map<Integer, Room> findRoomByRoomType(String roomType) {
        Map<Integer, Room> list = this.loadRoomsList();
        Map<Integer, Room> filteredList = new TreeMap<>();
        for (Map.Entry<Integer, Room> item : list.entrySet()) {
            if (item.getValue().getRoomType().equals(roomType)) {
                filteredList.put(item.getKey(), item.getValue());
            }
        }
        return filteredList;
    }

    @Override
    public void updateRoomById(int roomId, Room newRoomInfo) {
        Map<Integer, Room> list = this.loadRoomsList();
        list.replace(roomId, newRoomInfo);
        this.saveRoomsList(list);
    }

    @Override
    public void updateRoomStatusById(int roomId, RoomStatus roomStatus) {
        Map<Integer, Room> list = this.loadRoomsList();
        list.get(roomId).setRoomStatus(roomStatus);
        this.saveRoomsList(list);
    }

    @Override
    public void deleteRoomById(int roomId) {
        Map<Integer, Room> list = this.loadRoomsList();
        list.remove(roomId);
        this.saveRoomsList(list);
    }

    @Override
    public void printRoomsList() {
        Map<Integer, Room> list = this.loadRoomsList();
        for (Map.Entry<Integer, Room> item : list.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }
}
