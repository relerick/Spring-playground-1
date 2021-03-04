package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Endpoints {

    @PostMapping("/flights/tickets/total")
    public String totalTicket(@RequestBody HashMap<String, List<Ticket>> flightList){
    int accum=0;
    List<Ticket> arrayList=flightList.get("tickets");
    Ticket temp;

    for(int i=0;i<2;i++){
        temp=arrayList.get(i);
        accum+=temp.getPrice();
    }

        return String.valueOf(accum);
    }



}
