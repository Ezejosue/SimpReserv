package com.hotelreservation.simpreserv;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

public class Voucher {
    @Setter @Getter
    private long voucherId;

    @Setter @Getter
    private Client client;

    @Setter @Getter
    private Employee employee;

    public Voucher(long voucherId, Client client, Employee employee) {
        this.voucherId = voucherId;
        this.client = client;
        this.employee = employee;
    }

    public Voucher() {

    }

    public List<String > generateVoucher(List<String> list){

        return list;
    }
}
