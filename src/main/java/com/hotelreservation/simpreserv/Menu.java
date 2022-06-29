package com.hotelreservation.simpreserv;

import java.util.Scanner;

public class Menu {
 Scanner sc= new Scanner(System.in);
    public String loggingMenu(String user, String pass){
        if(user.equalsIgnoreCase("Client")&&pass.equalsIgnoreCase("1234")){
            return "Client";
        }else if(user.equalsIgnoreCase("Employee")&&pass.equalsIgnoreCase("1234")){
            return "Employee";
        }
        return user;
    }

    public void userMenu(){
        int close=0;
        do{

            System.out.println("SimpReserv 1.0");
            System.out.println("Bienvenido al sistema de registro del Hotel Hilton");
            System.out.println("Estas son las opciones disponible para servirte mejor");
            System.out.println("1-Reservar Habitacion");
            System.out.println("2-Cancelar reserva");
            System.out.println("3-Solicitar Membrecia");
            System.out.println("4-Cancelar Membrecia");
            System.out.println("5-Salir");
            int opt= sc.nextInt();
            switch (opt){
                case 1:{//Reservar Habitacion
                    System.out.println("Seleccionar fecha de llegada");
                    System.out.println("Seleccionar tiempo de estadia");
                    System.out.println("Seleccionar habitacion");

                    System.out.println("Seleccione el metodo de pago");
                    System.out.println("1-Tarjeta de Credito/Debito");
                    System.out.println("2-Paypal/Zelle");
                    System.out.println("3-Puntos accumulados");
                    break;
                }
                case 2:{//Cancelar reserva
                    System.out.println("Esta seguro de que quiere cancelar su reserva");
                    System.out.println("1-Si");
                    System.out.println("1-No");
                    break;
                }
                case 3:{//Solicitar Membrecia
                    System.out.println("Seleccione el tipo de membresia");
                    System.out.println("1-Silver");
                    System.out.println("2-Gold");
                    System.out.println("3-Planinium");
                    System.out.println("Su membrecia ha sido solicitada. Revise su correo electronico para mas informacion");
                    break;
                }
                case 4:{//Cancelar Membrecia
                    System.out.println("Esta seguro de que quiere cancelar su Membresia");
                    System.out.println("1-Si");
                    System.out.println("1-No");
                    System.out.println("Su membrecia ha sido cancelada exitosamente");
                    break;
                }
                case 5:{//Cerrar la applicacion
                    System.out.println("La aplicacion se ha cerrado con exito");
                    opt=0;
                    break;
                }
            }
        }while (close!=6);
    }

    public void employeeMenu(){

    }
}
