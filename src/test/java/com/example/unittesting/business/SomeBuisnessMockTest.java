package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBuisnessMockTest {

    SomeBuisness buisness = new SomeBuisness();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @BeforeEach
    public void before() {
        buisness.setSomeDataService(dataServiceMock);
    }

    @Test
    void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {1, 2, 3});
        int res = buisness.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected, res);
    }


    @Test
    void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {});
        int res = buisness.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected, res);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {5});
        int res = buisness.calculateSumUsingDataService();
        int expected = 5;
        assertEquals(expected, res);
    }
}