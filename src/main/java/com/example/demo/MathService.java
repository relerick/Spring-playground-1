package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathService {

    @GetMapping("/math/calculate")
    public String mAdd(@RequestParam String operation, @RequestParam String x, @RequestParam String y) {
        int result;
        switch (operation) {
            case "add":
                result = Integer.parseInt(x) + Integer.parseInt(y);
                return Integer.toString(result);

            case "subtract":
                result = Integer.parseInt(x) - Integer.parseInt(y);
                return Integer.toString(result);

            case "multiply":
                result = Integer.parseInt(x) * Integer.parseInt(y);
                return Integer.toString(result);

            case "divide":
                result = Integer.parseInt(x) / Integer.parseInt(y);
                return Integer.toString(result);
        }
        return "";
    }

    @PostMapping("/math/sum")
    public String nAdd(@RequestParam String n) {
        int result = 0;
        String[] splitted = n.split(",", 10);

        for(int i = 0; i < splitted.length; i++) {
            if (splitted[i].equals("")) {
                break;
            }
            result += Integer.parseInt(splitted[i]);
        }

        return Integer.toString(result);
    }

    @PostMapping("/math/area")
    public String nArea(@RequestParam String type,
                        @RequestParam (required = false, defaultValue = "0") int radius,
                        @RequestParam (required = false, defaultValue = "0") int width,
                        @RequestParam (required = false, defaultValue = "0") int height){
        //int result=0;
        if(type.equals("circle")){

            if(radius<=0) {
                return "INVALID";
            }
            else
                return Double.toString(3.14159*radius*radius);
        }
        else if(type.equals("rectangle")){
            return Integer.toString(width*height);
        }
        else
            return "INVALID TYPE";
    }
}