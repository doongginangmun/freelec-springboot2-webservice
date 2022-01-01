package com.jojoidu.book.freelecspringboot2webservice.config.auth.dto;

import com.jojoidu.book.freelecspringboot2webservice.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    //session에는 인증된 사용자 정보만 필요합니다.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
