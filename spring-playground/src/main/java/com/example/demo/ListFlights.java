package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListFlights {

    public List<Flight> ListFlights(){
        List<Flight> flightlist=new ArrayList<>();

        Date flightdate=new Date(117,03,21,14,34);
        Flight timsFlight=new  Flight(flightdate, 200, "Tim", "Tebow");
        flightlist.add(timsFlight);
        Flight aaronsFlight=new Flight(flightdate, 2000, "Aaron", "Sorkin");
        flightlist.add(aaronsFlight);

        return flightlist;
    }
}

