package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplTest {

    @Mock
    private SomeDataService dataServiceMock;

    @BeforeEach
    public void beforeEach() {
        dataServiceMock = mock(SomeDataService.class);
    }

    @Test
    public void calculateSum_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        int actualResult = business.calculateSum(dataServiceMock.retrieveAllData());
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });
        int actualResult = business.calculateSum(dataServiceMock.retrieveAllData());
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
        int actualResult = business.calculateSum(dataServiceMock.retrieveAllData());
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}