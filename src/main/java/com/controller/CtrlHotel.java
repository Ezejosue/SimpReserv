package com.controller;

import com.entity.IHotelController;
import com.model.simpreserv.Hotel;
import com.model.simpreserv.ReadObject;
import com.model.simpreserv.WriteObject;

import java.io.FileInputStream;
import java.io.IOException;

public class CtrlHotel implements IHotelController {

    private final static String FILEPATH = "src\\main\\resources\\hotel.dat";

    @Override
    public Hotel loadHotelInfo() {
        try (FileInputStream fis = new FileInputStream(FILEPATH)) {
            ReadObject ro = new ReadObject(FILEPATH);
            return (Hotel) ro.loadInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveHotelInfo(Hotel newRecord) {
        WriteObject wo = new WriteObject(FILEPATH, newRecord);
        wo.writeToFile();
    }

}
