package za.ac.cput.controller.financialAid;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.factory.financialAid.FundingFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FundingControllerTest {

    private static Funding funding = FundingFactory.createFunding("NSFAS", "A");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/funding/";

    @Test
    public void a_create() {

        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.println("Data :" + funding);
        ResponseEntity<Funding> postResponse = restTemplate.postForEntity(url, funding, Funding.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        funding = postResponse.getBody();
        System.out.println("Saved Data: " + funding);
        assertEquals(funding.getFundingId(),postResponse.getBody().getFundingId());
    }


    @Test
    public void b_read() {
        String url = baseURL + "read/" + funding.getFundingId();
        System.out.println("URL" + url);
        ResponseEntity<Funding> response  = restTemplate.getForEntity(url, Funding.class);
        assertEquals(funding.getFundingId(), response.getBody().getFundingId());


    }

    @Test
    public void c_update() {

        Funding updated = new Funding.Builder().copy(funding).setFundingName("NSFAS").build();
        String url = baseURL + "update";
        System.out.println("URL" + url);
        System.out.println("Data" + updated);
        ResponseEntity<Funding> response = restTemplate.postForEntity(url,updated, Funding.class);
        assertEquals(funding.getFundingId(), response.getBody().getFundingId());
    }



    @Test
    public void d_getAll() {

        String url = baseURL + "All";
        System.out.println("URL: "  + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {

        String url = baseURL + "delete" + funding.getFundingId();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }
}