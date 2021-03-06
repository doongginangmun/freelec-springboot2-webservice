package com.jojoidu.book.freelecspringboot2webservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //어노테이션 생성될수있는 위치
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
