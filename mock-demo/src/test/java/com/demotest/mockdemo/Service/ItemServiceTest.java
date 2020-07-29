package com.demotest.mockdemo.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.demotest.mockdemo.model.Item;
import com.demotest.mockdemo.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	
	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemRepository itemRepo;
	
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}
	
	@Test
	public void findallTest() {
		
		
		when(itemRepo.findAll()).thenReturn(Arrays.asList((new Item(1,"bat",5,50)), new Item(2,"ball",5,50)));
		
			List<Item> allData = itemService.allData();
		assertEquals(250, allData.get(0).getValue());
		assertEquals(250, allData.get(1).getValue());
	}
	
}
