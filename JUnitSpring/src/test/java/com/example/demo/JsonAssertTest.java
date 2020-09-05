package com.example.demo;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"name\":\"youghurt\",\"id\":1,\"price\":10.0,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue_ExactMatchWithSpace() throws JSONException {
        String expectedResponse = "{\"name\":\"youghurt\",\"id\":1,\"price\":10.0,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }
    @Test
    public void jsonAssert_strictFalse_withoutQty() throws JSONException {
        String expectedResponse = "{\"name\":\"youghurt\",\"id\":1,\"price\":10.0}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
    //string with space -> quote with escape char, otherwise not needed
    @Test
    public void jsonAssert_strictTrue_WithoutEscapeChar() throws JSONException {
        String expectedResponse = "{name:youghurt,id:1,price:10.0,quantity:100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }
}
