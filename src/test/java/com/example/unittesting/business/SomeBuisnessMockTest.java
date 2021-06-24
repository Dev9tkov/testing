package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBuisnessMockTest {

    @InjectMocks
    SomeBuisness buisness;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {1, 2, 3});
        int res = buisness.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected, res);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {});
        int res = buisness.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected, res);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {5});
        int res = buisness.calculateSumUsingDataService();
        int expected = 5;
        assertEquals(expected, res);
    }
}