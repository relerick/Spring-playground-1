package com.example.demo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Flight {
    Date departs;
    Ticket passenger;

    public Flight(Date date, int price, String firstName, String lastName){
        this.setDeparts(date);
        this.passenger = new Ticket(lastName, firstName, price);
    }

    public Flight (){
        Date fillerDate=new Date(117,03,21,14,24);
        this.setDeparts(fillerDate);
        this.passenger=new Ticket("Tebow", "Tim", 200);
    }

    @JsonFormat(pattern = "yyyy-mm-dd hh:mm")
    public void setDeparts(Date departs) {
        this.departs = departs;
    }

}
