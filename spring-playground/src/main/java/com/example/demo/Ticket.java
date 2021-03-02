package com.example.demo;

class Ticket {
    public Ticket(String lastName, String firstName, int price) {
        this.price = price;
        this.passenger=new People(lastName, firstName);

    }

    int price;
    People passenger;

}
