package com.simpreserv.exe;

import com.hotelreservation.simpreserv.Client;
import com.hotelreservation.simpreserv.Membership;
import com.hotelreservation.simpreserv.MembershipType;
import controller.ControllerClient;

public class SimpReserv {

    public static void main(String[] args) {

        Membership membership=new Membership("Gold",new MembershipType());


        System.out.println(membership);
    }
}
