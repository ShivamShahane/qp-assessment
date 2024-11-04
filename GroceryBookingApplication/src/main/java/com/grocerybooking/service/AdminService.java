package com.grocerybooking.service;

import java.util.List;

import com.grocerybooking.model.GroceryItem;

public interface AdminService {
	
	public GroceryItem addGroceryItem(GroceryItem groceryItem);
	
	public List<GroceryItem> getAllGroceryItems();
	
	public void deleteGroceryItem(Long id);
	
	public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem);
	
	public GroceryItem manageInventory(Long id, int inventoryLevel);

}
