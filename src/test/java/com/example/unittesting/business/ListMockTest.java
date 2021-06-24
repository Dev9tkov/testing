package com.example.unittesting.business;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size())
                .thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size())
                .thenReturn(5)
                .thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameteres() {
        when(mock.get(0))
                .thenReturn("inTest");
        assertEquals("inTest", mock.get(0));
    }

    @Test
    public void returnWithGenericParameteres() {
        when(mock.get(anyInt()))
                .thenReturn("inTest");
        assertEquals("inTest", mock.get(0));
        assertEquals("inTest", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);

    }
}
