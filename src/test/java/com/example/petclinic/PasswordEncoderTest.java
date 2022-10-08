package com.example.petclinic;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void generateEncodedPasswords(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("{bcrypt}"+ passwordEncoder.encode("secret"));
        System.out.println("{bcrypt}"+ passwordEncoder.encode("secret"));
        System.out.println("{bcrypt}"+ passwordEncoder.encode("secret"));
    }
}
