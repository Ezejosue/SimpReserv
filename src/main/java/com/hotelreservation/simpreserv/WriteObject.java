package com.hotelreservation.simpreserv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
  private final String filePath;
  private final Object obj;

  public WriteObject(String filePath, Object obj) {
    this.filePath = filePath;
    this.obj = obj;
  }

  public void writeToFile() {
    try (FileOutputStream fos = new FileOutputStream(filePath)) {
      try (ObjectOutputStream objStream = new ObjectOutputStream(fos)) {
        objStream.writeObject(obj);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
