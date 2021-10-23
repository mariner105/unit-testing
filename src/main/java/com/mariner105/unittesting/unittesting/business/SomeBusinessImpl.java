package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

    private  SomeDataService dataService;

    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSumUsingDataService() {
        int[] data = dataService.retrieveAllData();
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

}
