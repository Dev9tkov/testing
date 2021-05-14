package com.example.unittesting.business;

public class SomeBuisness {

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int val : data) {
            sum += val;
        }
        return sum;
    }
}
