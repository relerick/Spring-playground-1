package com.example.demo;

class Ticket {

    int price;
    People passenger;

    public Ticket(String lastName, String firstName, int price) {
        this.price = price;
        this.passenger=new People(lastName, firstName);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public People getPassenger() {
        return passenger;
    }

    public void setPassenger(People passenger) {
        this.passenger = passenger;
    }

}
