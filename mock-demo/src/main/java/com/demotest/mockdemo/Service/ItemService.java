package com.demotest.mockdemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demotest.mockdemo.model.Item;
import com.demotest.mockdemo.repository.ItemRepository;

@Service
public class ItemService {

	
	@Autowired
	private ItemRepository repository;
	
	public Item retriveItem() {

		return new Item(1, "bat", 25, 500);
	}

	
	public List<Item> allData(){
		
		List<Item> items = repository.findAll();
		
		for (Item item : items) {
			
			item.setValue(item.getPrice()*item.getQuantity());
		}
		
		return items;
		
	}
}
