package com.example.petclinic.security;

import com.example.petclinic.service.PetClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=dev")
@WithMockUser(username = "user", password = "secret", authorities = "USER")
public class PetClinicSecurityWithoutTokenTest {
    @Autowired
    private PetClinicService petClinicService;

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testFindOwners(){
        petClinicService.findOwners();
    }
}
