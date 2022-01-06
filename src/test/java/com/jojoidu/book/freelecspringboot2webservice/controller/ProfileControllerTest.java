package com.jojoidu.book.freelecspringboot2webservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfileControllerTest {

    @Test
    @DisplayName("real_profile이 조회된다.")
    public void testcase() {
        //given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        //when
        String profile = controller.profile();
        //then
        assertThat(profile).isEqualTo(expectedProfile);

    }
    @Test
    @DisplayName("real_profile이 없으면 첫번째가 조회된다.")
    public void testcase2() {
        //given
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    @DisplayName("active_profile이 없으면 default가 조회된다.")
    public void testcase3() {
        //given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();
        //then
        assertThat(profile).isEqualTo(expectedProfile);

    }


}