package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {
        @Autowired
        MockMvc mvc;

        @Test
        public void testHomePageEndpoint() throws Exception {
                this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Hello from Spring!"));
        }
}





