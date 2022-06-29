package com.hotelreservation.simpreserv;

import lombok.Getter;
import lombok.Setter;

public class MembershipType {
    @Setter
    @Getter
    private String silver;
    @Setter
    @Getter
    private String gold;
    @Setter
    @Getter
    private String platinum;

    public MembershipType(String silver, String gold, String platinum) {
        this.silver = silver;
        this.gold = gold;
        this.platinum = platinum;
    }

    public MembershipType() {
    }

    public void benefits(String type){
        if(type.equalsIgnoreCase("silver")){

        }
    }

}
