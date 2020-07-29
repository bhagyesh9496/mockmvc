package com.demotest.mockdemo.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demotest.mockdemo.Service.ItemService;
import com.demotest.mockdemo.model.Item;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;



@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemservice;

	@Test
	public void Item_basic() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"bat\",\"price\":25,\"quantity\":500}"))
				.andReturn();

		// assertEquals("Hello World !", result.getResponse().getContentAsString());

	}

	
	@Test
	public void ItemService_basic() throws Exception {

		
		when(itemservice.retriveItem()).thenReturn(new Item(1, "bat", 25, 500));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/itemService").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1,name:bat,price:25,quantity:500}"))
				.andReturn();


	}
	

	@Test
	public void ItemServiceAllData() throws Exception {

		
		when(itemservice.allData()).thenReturn(
				Arrays.asList((new Item(1, "bat", 25, 500)), new Item(2, "ball", 35, 50)));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/allItem").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1,name:bat,price:25,quantity:500},{id:2,name:ball,price:35,quantity:50}]"))
				.andReturn();


	}
	
}
