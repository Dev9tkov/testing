package com.example.unittesting.business;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {
    List mock = mock(List.class);

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
}
