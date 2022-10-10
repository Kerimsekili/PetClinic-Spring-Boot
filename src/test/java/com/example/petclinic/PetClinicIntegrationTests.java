package com.example.petclinic;


import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.PetClinicService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=dev"})
public class PetClinicIntegrationTests {
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testFindOwners() {
        // NOT WORKİNG
        List<Owner> owners = petClinicService.findOwners();
        MatcherAssert.assertThat(owners.size(), Matchers.equalTo(11));
    }
}