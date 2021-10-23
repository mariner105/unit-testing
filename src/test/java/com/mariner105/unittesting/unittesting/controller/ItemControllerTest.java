package com.mariner105.unittesting.unittesting.controller;

import com.mariner105.unittesting.unittesting.business.ItemBusinessService;
import com.mariner105.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ItemController.class})
class ItemControllerTest {

    public static final String EXPECTED_JSON = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        //call "/dummy-item"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request);

        //verify that the response contains the expected JSON
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(EXPECTED_JSON))
                .andReturn();

        JSONAssert.assertEquals(EXPECTED_JSON, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new
                                Item(2, "Item2", 10, 10),
                        new
                                Item(3, "Item3", 20, 20))
        );

        //call "/dummy-item"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        //verify that the response contains the expected JSON
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:3,name:Item3,price:20}, {id:2,name:Item2,price:10}]"))
                .andReturn();

        //JSONAssert.assertEquals(EXPECTED_JSON, result.getResponse().getContentAsString(), false);

    }
}