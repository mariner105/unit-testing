package com.mariner105.unittesting.unittesting.business;

import com.mariner105.unittesting.unittesting.controller.ItemController;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemBusinessServiceTest {

    public static final String EXPECTED_JSON = "{id:2,name: Item2, price:10, quantity:10}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void itemFromBusinessService() throws Exception {
        when(businessService.retreiveHardCodedItem()).thenReturn(
                new Item(2, "Item2", 10, 10));

        //call "/item-from-business-service"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request);

        //verify that the response contains the expected JSON
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(EXPECTED_JSON))
                .andReturn();

        JSONAssert.assertEquals(EXPECTED_JSON, result.getResponse().getContentAsString(), false);

    }
}