package com.example.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBuisnessTest {

    @Test
    void calculateSum() {
        SomeBuisness buisness = new SomeBuisness();
        int res = buisness.calculateSum(new int[] {1, 2, 3});
        int expected = 6;
        assertEquals(expected, res);

    }
}