package com.edu.tasksapi;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import com.edu.tasksapi.entity.User;
import com.edu.tasksapi.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTests {

    /**
     * le bean MockMVC apporte une abstraction sur l'adresse complete du controller
     * à tester
     */
    @Autowired
    private MockMvc mockMvc;

    /** Service mocké */
    @TestConfiguration
    static class MockingTestClasses {
        @Bean
        public UserService userService() {
            return new UserService() {

                @Override
                public User getRandomUser() {
                    User returnv = new User();
                    returnv.setIduser(10);
                    returnv.setName("toto");
                    return returnv;
                }

            };
        }
    }

    @Autowired
    public UserService mockservice;

    @Test
    void whenGetRandom_shouldReturnTotoUser() throws Exception {
        this.mockMvc.perform(get("/users/random")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("toto")));
        System.out.println(content());
    }

    @Test
    void shouldReturnDefaultMessage1() throws Exception {
        this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("name")));
        System.out.println(content());
    }
}