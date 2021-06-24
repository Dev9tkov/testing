package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBuisnessMockTest {

    @Test
    void calculateSumUsingDataService_basic() {
        SomeBuisness buisness = new SomeBuisness();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        //dataServiceMock retrieveAllData new int[] {1, 2, 3}
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {1, 2, 3});
        buisness.setSomeDataService(dataServiceMock);
        int res = buisness.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected, res);
    }


    @Test
    void calculateSumUsingDataService_empty() {
        SomeBuisness buisness = new SomeBuisness();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {});
        buisness.setSomeDataService(dataServiceMock);
        int res = buisness.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected, res);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        SomeBuisness buisness = new SomeBuisness();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {5});
        buisness.setSomeDataService(dataServiceMock);
        int res = buisness.calculateSumUsingDataService();
        int expected = 5;
        assertEquals(expected, res);
    }

}