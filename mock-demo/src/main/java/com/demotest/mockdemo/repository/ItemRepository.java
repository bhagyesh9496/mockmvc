package com.demotest.mockdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demotest.mockdemo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	

}
