package com.hotelreservation.simpreserv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
  private final String filePath;

  public ReadObject(String filePath) {
    this.filePath = filePath;
  }

  public Object loadInputStream(FileInputStream fis) {
    try (ObjectInputStream obj = new ObjectInputStream(fis)) {
      return obj.readObject();
    } catch (ClassNotFoundException | IOException e) {
      throw new RuntimeException(e);
    }
  }
}
