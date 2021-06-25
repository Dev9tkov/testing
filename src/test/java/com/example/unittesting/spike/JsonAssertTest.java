package com.example.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expected, actualResponse, true);
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";//no quantity
        JSONAssert.assertEquals(expected, actualResponse, false);
    }

    @Test
    public void jsonAssert_withoutEscapeCharacter() throws JSONException {
        String expected = "{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expected, actualResponse, false);
    }
}
