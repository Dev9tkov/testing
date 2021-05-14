package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;

public class SomeBuisness {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int val : data) {
            sum += val;
        }
        return sum;
    }

    public int calculateSumUsingDataService () {
        int[] data = someDataService.retrieveAllData();
        int sum = 0;
        for (int val : data) {
            sum += val;
        }
        return sum;
    }
}
