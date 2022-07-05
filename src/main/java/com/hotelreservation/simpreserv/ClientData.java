package com.hotelreservation.simpreserv;

import enums.EmployeeStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientData {

    public List<Client> clientList(){
        List<Client> listClient=new ArrayList<>();


        MembershipType mt=new MembershipType("Silver");
        MembershipType mt2=new MembershipType("Gold");
        MembershipType mt3=new MembershipType("Platinum");

        Membership mn=new Membership(mt);
        Membership mn2=new Membership(mt2);
        Membership mn3=new Membership(mt3);

        CreditCard cc=new CreditCard("Jose","Visa",new Date());
        CreditCard cc2=new CreditCard("Marcos","MasterCard",new Date());
        CreditCard cc3=new CreditCard("Rosa","Discovery",new Date());

        Client client=new Client("Jose","Martinez",new Date(),"Masculino","2385","C/4ra #2","829-340-5680","aol@gm.com",mn,cc);
        listClient.add(client);
        Client client2=new Client("Miguel","Perez",new Date(),"Masculino","2548","C/5ra #3","829-340-541","aol2@gm.com",null,cc2);
        listClient.add(client2);
        Client client3=new Client("Rosa","Dominguez",new Date(),"Femenino","2365","C/6ra #4","829-658-8695","aol3@gm.com",mn3,cc3);
        listClient.add(client3);
        Client client4=new Client("Nelkis","Ramon",new Date(),"Femenino","8385","C/7ra #5","829-340-4679","aol4@gm.com",mn,cc);
        listClient.add(client4);
        Client client5=new Client("Manuel","Hugo",new Date(),"Masculino","5385","C/8ra #6","829-340-4631","aol5@gm.com",mn2,cc2);
        listClient.add(client5);




        return listClient;
    }

    public List<Employee> employeeList(){
        List<Employee> list=new ArrayList<>();
        Employee employee=new Employee("Josue","Marte",new Date(),"Male","3216","C/8ra #6","829-340-4679","aol5@gm.com",568, EmployeeStatus.HIRED,"Mañana");
        list.add(employee);
        Employee employee2=new Employee("Tony","Cuevas",new Date(),"Male","6547","C/7ra #5","829-340-4631","aol4@gm.com",568, EmployeeStatus.HIRED,"Noche");
        list.add(employee2);
        Employee employee3=new Employee("Carlos","Barahona",new Date(),"Male","9874","C/6ra #4","829-340-5680","aol3@gm.com",568, EmployeeStatus.HIRED,"Amancecida");
        list.add(employee3);

        return list;
    }

    public void printClientList() {
      for (int i=0;i<this.clientList().size();i++){

          //Atributos a imprimir: nombre, apellido,tipo de membrecia,Beneficio

          System.out.println("Nombre: "+this.clientList().get(i).getName());
          System.out.println("Apellido: "+this.clientList().get(i).getLastname());
          System.out.println("Membrecia: "+this.clientList().get(i).getMembership().getMembershipType().getMembership());
          System.out.println("Beneficios: "+this.clientList().get(i).getMembership().getDiscountPercentage());
      }
    }
}
