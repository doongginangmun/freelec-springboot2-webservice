package com.jojoidu.book.freelecspringboot2webservice.controller;

import com.jojoidu.book.freelecspringboot2webservice.config.auth.SecurityConfig;
import com.jojoidu.book.freelecspringboot2webservice.web.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HomeController.class
,excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                            classes = SecurityConfig.class)
        }
)//스캔 대상에서 SecurityConfig 제외
class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("hello 테스트")
    @WithMockUser(roles="USER")
    public void testcase1() throws Exception {
        //given
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    @DisplayName("롬복 테스트")
    @WithMockUser(roles="USER")
    public void testcase2() {
        //given
        String name = "test";
        int amount = 100;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }

    @Test
    @DisplayName("HelloResponse 반환")
    @WithMockUser(roles="USER")
    public void testcase3() throws Exception {
        //given
        String name = "hello";
        int amount = 1000;
        //when
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


        //then

    }
}