package com.example.petclinic.web;

import com.example.petclinic.model.Owner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class PetClinicRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;



    @Before
    public void setUp() {
        restTemplate = restTemplate.withBasicAuth("user2","secret");
    }


    @Test
    public void testDeleteOwner(){
        restTemplate.delete("http://localhost:8080/rest/owner/1");
        //restTemplate.exchange("http://localhost:8080/rest/owner/1", HttpMethod.DELETE,null, Void.class);

        try {
            restTemplate.getForEntity("http://localhost:8080/rest/owner/1",Owner.class);
            Assert.fail("should have not returned owner");
        }catch (HttpClientErrorException ex){
            MatcherAssert.assertThat(ex.getStatusCode().value(),Matchers.equalTo(404));
        }
    }

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Furkan");
        owner.setLastName("Sekili");

        URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner",owner);

        Owner owner2 = restTemplate.getForObject(location, Owner.class);

        MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
        MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));
    }

    @Test
    public void testUpdateOwner(){
        Owner owner = restTemplate.getForObject("http://localhost:8080/rest/owner/4",Owner.class);

        MatcherAssert.assertThat(owner.getFirstName(),Matchers.equalTo("Selinay"));

        owner.setFirstName("Selinay Elif");
        restTemplate.put("http://localhost:8080/rest/owner/4",owner);

        owner = restTemplate.getForObject("http://localhost:8080/rest/owner/4",Owner.class);

        MatcherAssert.assertThat(owner.getFirstName(),Matchers.equalTo("Selinay Elif"));
    }

    @Test
    public void testGetOwnerById() {
        ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8085/rest/owner/1", Owner.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Ziya"));
    }

    @Test
    public void testGetOwnersByLastName() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Sekili", List.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();

        List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());

        MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Kerim"));
    }

    @Test
    public void testGetOwners() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();

        List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());

        MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Ziya","Be??ir"));
    }

    @Test
    public void testServiceLevelValidation(){
        Owner owner = new Owner();
        //owner.setFirstName("K");
        //owner.setLastName("S");

     ResponseEntity<URI> response =  restTemplate.postForEntity("http://localhost:/rest/owner",owner, URI.class);
     MatcherAssert.assertThat(response.getStatusCode(),Matchers.equalTo(HttpStatus.PRECONDITION_FAILED));
    }

}
