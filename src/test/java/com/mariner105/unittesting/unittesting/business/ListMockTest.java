package com.mariner105.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    public static final String MARINER_105 = "mariner105";
    public static final String SOME_STRING = "SomeString";
    public static final String SOME_STRING_2 = "SomeString2";
    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
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
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn(MARINER_105);
        assertEquals(MARINER_105, mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        //anyInt() is an argument matcher
        when(mock.get(anyInt())).thenReturn(MARINER_105);
        assertEquals(MARINER_105, mock.get(0));
        assertEquals(MARINER_105, mock.get(1));
    }

    @Test
    public void verificationBasics() {
        //System under test
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //Verify whether a method was called
        // We use this when there is no return value to check
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);

    }

    @Test
    public void argumentCapturing() {
        //System under test
        mock.add(SOME_STRING);

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals(SOME_STRING, captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //System under test
        mock.add(SOME_STRING);
        mock.add(SOME_STRING_2);

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals(SOME_STRING, allValues.get(0));
        assertEquals(SOME_STRING_2, allValues.get(1));
    }

}
