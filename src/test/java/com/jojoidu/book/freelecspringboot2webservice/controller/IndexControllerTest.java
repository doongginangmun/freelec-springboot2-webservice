package com.jojoidu.book.freelecspringboot2webservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("웹 메인페이지 로딩")
    public void testcase() {
        //given
        String body = this.restTemplate.getForObject("/", String.class);

        //when

        //then
        assertThat(body).contains("스프링 부트 웹 서비스");
    }

}