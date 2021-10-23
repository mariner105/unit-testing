package com.mariner105.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    public static final String ACTUAL_RESPONSE = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue_ExactMatchExceptForSpaces() throws JSONException {
        //When the strict argument is true then the actual JSON structure must
        // match the expected JSON structure, i.e. no missing or added fields.
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, ACTUAL_RESPONSE, true);
    }

    @Test
    public void jsonAssert_NonStrict() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        // With false we could look for a subset of the actual fields.
        JSONAssert.assertEquals(expectedResponse, ACTUAL_RESPONSE, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1, name: Ball, price:10}";
        // With false we could look for a subset of the actual fields.
        JSONAssert.assertEquals(expectedResponse, ACTUAL_RESPONSE, false);
    }


}
