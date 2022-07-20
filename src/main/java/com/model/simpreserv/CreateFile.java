package com.model.simpreserv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {


    public CreateFile(){

    }


    public void setCreateFile(Hotel hotel, Client client, Room room) {


        try {
            File myFile = new File("src\\main\\java\\com\\file\\SimpReserv.txt");
            if (myFile.createNewFile()){
                System.out.println("Informacion de reservacion actualizada en archivo adjunto.");
            } else {
                System.out.println("Informacion de reservacion actualizada en archivo adjunto.");
            }

        } catch (IOException e) {
            System.out.println("Ocurrio un error al crear el archivo adjunto.");
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("src\\main\\java\\com\\file\\SimpReserv.txt");
            fileWriter.write("Hotel: " + hotel.getName() + "\n" + "Categoria: " + hotel.getCategory() + "\n" + "Direccion: " + hotel.getLocation());
            fileWriter.write( "\n" + "Descripcion: " + room.getRoomDescription() + "\n" + "Tipo: " + room.getRoomType() + "\n" + "Piso: " + room.getRoomFloor()
                    + "\n" + "Numero: " + room.getRoomNumber() + "\n" + "Precio: " + room.getRoomPrice() );
            fileWriter.write("\n" + "Cliente: " + client.getName());
            fileWriter.close();

        }catch (IOException e){
            System.out.println("Error al agregarle contenido al archivo adjunto.");
            e.printStackTrace();

        }
    }
}
