package com.hotelreservation.simpreserv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    private String filePath;
    private Object obj;

    public ReadObject(String filePath, Object obj) {
        this.filePath = filePath;
        this.obj = obj;
    }

    public Object ReadFromFile(){
        try(FileInputStream fio = new FileInputStream(filePath)){
            try(ObjectInputStream obj = new ObjectInputStream(fio)){
                Object info = (Object) obj.readObject();
                return info;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
