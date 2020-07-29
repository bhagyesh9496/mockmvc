package com.demotest.mockdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demotest.mockdemo.Service.ItemService;
import com.demotest.mockdemo.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemservice;

	@GetMapping("/item")
	public Item itemdata() {

		return new Item(1, "bat", 25, 500);
	}

	@GetMapping("/itemService")
	public Item itemService() {

		return itemservice.retriveItem();
	}

	@GetMapping("/allItem")
	public List<Item> allItemData() {

		return itemservice.allData();
	}

}
