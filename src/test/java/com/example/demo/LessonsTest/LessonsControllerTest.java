package com.example.demo.LessonsTest;

import com.example.demo.Lesson.Lesson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import java.util.HashMap;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonsControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    @Transactional
    @Rollback
    public void testAll() throws Exception{
        Lesson test=new Lesson();
        test.setTitle("Hello");
        test.setId(2l);


        ObjectMapper objectMapper=new ObjectMapper();

        String jsonData = objectMapper.writeValueAsString(test);
        MockHttpServletRequestBuilder requestposter=post("/lessons").contentType(MediaType.APPLICATION_JSON).content(jsonData);
        this.mvc.perform(requestposter);

        MockHttpServletRequestBuilder request=get("/lessons");
        this.mvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.[0]", instanceOf(HashMap.class)));//.andExpect(jsonPath("$", instanceOf(Lesson.class)));

    }

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception{
        Lesson test=new Lesson();
        test.setTitle("Hello");
        test.setId(2l);


        ObjectMapper objectMapper=new ObjectMapper();

        String jsonData = objectMapper.writeValueAsString(test);
        MockHttpServletRequestBuilder request=post("/lessons").contentType(MediaType.APPLICATION_JSON).content(jsonData);

        this.mvc.perform(request).andExpect(status().isOk());
        this.mvc.perform(get("/lessons")).andExpect(status().isOk()).andExpect(jsonPath("$.[0]", instanceOf(HashMap.class)));

    }
}
