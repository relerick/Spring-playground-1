package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class Endpoints {

    @GetMapping("/flights/flight")
    public Flight Flight(){
        Date flightDate=new Date(117,03,21,14,34);
        return Flight();
    }

    @GetMapping("/flights")
    public List<Flight> ListFlights(){

       return ListFlights();
    }

}
