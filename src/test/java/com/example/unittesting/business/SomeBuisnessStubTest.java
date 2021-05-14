package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}

class SomeBuisnessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {
        SomeBuisness buisness = new SomeBuisness();
        buisness.setSomeDataService(new SomeDataServiceStub());
        int res = buisness.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected, res);
    }
}