package com.hotelreservation.simpreserv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    private String filePath;
    private Object obj;

    public WriteObject(String filePath, Object obj) {
        this.filePath = filePath;
        this.obj = obj;
    }

    public void WriteToFile() {
        try(FileOutputStream fos = new FileOutputStream(filePath)){
            try(ObjectOutputStream objStream = new ObjectOutputStream(fos)){
                objStream.writeObject(obj);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
