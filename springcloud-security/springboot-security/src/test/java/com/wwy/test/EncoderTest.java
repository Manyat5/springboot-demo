package com.wwy.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wwy
 */
public class EncoderTest {
    @Test
    public void test1(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123");//$2a$10$VyI08S5BJBN1pn0Ze8sfP.CurN9CEWXral1n0HUm0aX8PL.zqvDmu
        System.out.println(encode);
        System.out.println(encoder.matches("123", encode));
    }
    @Test
    public void test2(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("123", "$2a$10$VyI08S5BJBN1pn0Ze8sfP.CurN9CEWXral1n0HUm0aX8PL.zqvDmu"));
    }
}
