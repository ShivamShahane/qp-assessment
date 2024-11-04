package com.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerybooking.model.GroceryItem;
import com.grocerybooking.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@PostMapping("/grocery-items")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return new ResponseEntity<>(adminServiceImpl.addGroceryItem(groceryItem), HttpStatus.CREATED);
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return new ResponseEntity<>(adminServiceImpl.getAllGroceryItems(), HttpStatus.OK);
    }

    @DeleteMapping("/grocery-items/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        adminServiceImpl.deleteGroceryItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/grocery-items/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return new ResponseEntity<>(adminServiceImpl.updateGroceryItem(id, groceryItem), HttpStatus.OK);
    }

    @PatchMapping("/grocery-items/{id}/inventory")
    public ResponseEntity<GroceryItem> manageInventory(@PathVariable Long id, @RequestBody int inventoryLevel) {
        return new ResponseEntity<>(adminServiceImpl.manageInventory(id, inventoryLevel), HttpStatus.OK);
    }

}
