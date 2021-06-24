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

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceOneElemStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
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

    @Test
    void calculateSumUsingDataService_empty() {
        SomeBuisness buisness = new SomeBuisness();
        buisness.setSomeDataService(new SomeDataServiceEmptyStub());
        int res = buisness.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected, res);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        SomeBuisness buisness = new SomeBuisness();
        buisness.setSomeDataService(new SomeDataServiceOneElemStub());
        int res = buisness.calculateSumUsingDataService();
        int expected = 5;
        assertEquals(expected, res);
    }
}