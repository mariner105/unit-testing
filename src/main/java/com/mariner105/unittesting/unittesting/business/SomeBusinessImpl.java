package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private  SomeDataService dataService;

    //This method is here so that we can inject the mock
    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Calculate the some using functional programming.
     * @param data An array of integers whose sum be returned
     * @return sum of the integers
     */
    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int[] data = dataService.retrieveAllData();
//        int sum = 0;
//        for (int value : data) {
//            sum += value;
//        }

        // If the following was a real method call then we could use verify tests to check that it was executed as
        // expected
        // someDataService.storeSum(sum);
        return calculateSum(data);
    }

}
