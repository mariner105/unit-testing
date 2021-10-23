package com.mariner105.unittesting.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    public static final boolean STRICT_FALSE = false;
    public final String URL_ALL_ITEMS = "/all-items-from-database";
    public final String EXPECTED_RESPONSE_JSON =
            "[{id:10001}, {id:10002}, {id:10003}]";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject(URL_ALL_ITEMS, String.class);
        JSONAssert.assertEquals(EXPECTED_RESPONSE_JSON, response, STRICT_FALSE);
    }


}
