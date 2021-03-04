package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(MathService.class)
public class MathServiceTest {
    @Autowired
    MockMvc mvc;
    @Test
    public void testmAdd() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6")).andExpect(content().string("10"));
    }

    @Test
    public void testmSub() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6")).andExpect(content().string("-2"));
    }
    @Test
    public void testmMul() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6")).andExpect(content().string("24"));
    }
    @Test
    public void testmDiv() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5")).andExpect(content().string("6"));
    }

    @Test
    public void testnAdd() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6")).andExpect(content().string("15"));
    }

    @Test
    public void testnArea() throws Exception{
        this.mvc.perform(post("/math/area?type=circle&radius=4")).andExpect(content().string("50.26544"));
        this.mvc.perform(post("/math/area?type=rectangle&width=4&height=7")).andExpect(content().string("28"));
        this.mvc.perform(post("/math/area?type=circle&radius=0")).andExpect(content().string("INVALID"));
        this.mvc.perform(post("/math/area?type=TRI&radius=0")).andExpect(content().string("INVALID TYPE"));


    }


}

