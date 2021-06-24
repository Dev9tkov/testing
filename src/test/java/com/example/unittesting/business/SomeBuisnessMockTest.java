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
        assertEquals(6, buisness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {});
        assertEquals(0, buisness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[] {5});
        assertEquals(5, buisness.calculateSumUsingDataService());
    }
}