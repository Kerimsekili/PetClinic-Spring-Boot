package com.example.petclinic;


import java.util.List;

import com.example.petclinic.model.Vet;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=dev"})
public class PetClinicIntegrationTests {

    @Before
    public void setUp() {
        TestingAuthenticationToken auth = new TestingAuthenticationToken("user", "secret", "ROLE_XXX");
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testFindOwners() {
        // NOT WORKİNG
        List<Owner> owners = petClinicService.findOwners();
        MatcherAssert.assertThat(owners.size(), Matchers.equalTo(11));
    }

    @Test
    public void testFindVets(){
        List<Vet> vets = petClinicService.findVets();
        MatcherAssert.assertThat(vets.size(),Matchers.equalTo(3));
    }
}