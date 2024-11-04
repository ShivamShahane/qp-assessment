package com.grocerybooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerybooking.model.GroceryItem;
import com.grocerybooking.repository.GroceryItemRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
    private GroceryItemRepository groceryItemRepository;

	@Override
	public GroceryItem addGroceryItem(GroceryItem groceryItem) {
		return groceryItemRepository.save(groceryItem);
	}

	@Override
	public List<GroceryItem> getAllGroceryItems() {
		return groceryItemRepository.findAll();
	}

	@Override
	public void deleteGroceryItem(Long id) {
		groceryItemRepository.deleteById(id);
	}

	@Override
	public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
		groceryItem.setId(id);
        return groceryItemRepository.save(groceryItem);
	}

	@Override
	public GroceryItem manageInventory(Long id, int inventoryLevel) {
		GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
        item.setInventoryLevel(inventoryLevel);
        return groceryItemRepository.save(item);
	}

}
