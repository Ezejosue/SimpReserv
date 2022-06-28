package com.hotelreservation.simpreserv;

import lombok.Setter;
import lombok.Getter;

import java.util.Date;

public class Payment {
    private long id;
    private int idReservation;
    private Voucher voucher;
    private double tax;
    private double fullPayment;
    private Date issueDate;
    private Date paymentDay;

}
