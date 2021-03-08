package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Endpoints.class)
public class EndpointsTest {
    @Autowired
    MockMvc mvc;
    String flightData="{\"tickets\": [{\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\"},\"price\": 200},{\"passenger\": {\"firstName\": \"Name B\",\"lastName\": \"Name C\"}, \"price\": 150}]}";

    @Test
    public void testEnd1() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(flightData);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("350"));
    }

    @Test
    public void testEnd2() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        List<Ticket> ticketList=new ArrayList<>();

        Ticket ticket1=new Ticket("some other name", "some name", 200);
        Ticket ticket2=new Ticket("nameB", "nameC", 150);

        ticketList.add(ticket1);
        ticketList.add(ticket2);

        HashMap<String, Object> flightList=new HashMap<String, Object>();
            flightList.put("tickets",ticketList);
            //flightList.put("ticket2",ticket2);

        String jsonData = objectMapper.writeValueAsString(flightList);

        System.out.println(jsonData);
        System.out.println(jsonData);

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("350"));
    }

    @Test
    public void testEnd3() throws Exception{
        JSONParser parser=new JSONParser();
        Object obj=parser.parse(new FileReader("/Users/r2153043/Downloads/spring-playground/src/test/java/com/example/demo/scratch.json"));
        JSONObject jsonObject=(JSONObject) obj;
        String jsonData= jsonObject.toJSONString();


        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonData);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("350"));
    }

}
