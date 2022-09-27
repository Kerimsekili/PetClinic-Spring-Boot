package com.example.petclinic.web;

import com.example.petclinic.model.Owner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PetClinicRestControllerRest {
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetOwnerById(){
        ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhıst:8080/rest/owner/1", Owner.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getFirstName(),Matchers.equalTo("Kerim"));
    }


}
