package com.example.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add(("SomeString"));

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mock.add(("SomeString1"));
        mock.add(("SomeString2"));

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValuees = captor.getAllValues();

        assertEquals("SomeString1", allValuees.get(0));
        assertEquals("SomeString2", allValuees.get(1));
    }
}
