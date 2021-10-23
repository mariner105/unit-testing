package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

    private  SomeDataService dataService;

    //This method is here so that we can inject the mock
    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSumUsingDataService() {
        int[] data = dataService.retrieveAllData();
        int sum = 0;
        for (int value : data) {
            sum += value;
        }

        // If the following was a real method call then we could use verify tests to check that it was executed as
        // expected
        // someDataService.storeSum(sum);
        return sum;
    }

}
