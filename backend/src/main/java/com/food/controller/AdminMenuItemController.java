package com.food.controller;

import java.util.List;

import com.food.model.Restaurant;
import com.food.service.CategoryService;
import com.food.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.Exception.FoodException;
import com.food.Exception.RestaurantException;
import com.food.Exception.UserException;
import com.food.model.Food;
import com.food.model.User;
import com.food.request.CreateFoodRequest;
import com.food.service.FoodService;
import com.food.service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminMenuItemController {
	
	@Autowired
	private FoodService menuItemService;
	@Autowired
	private UserService userService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private CategoryService categoryService;

	@PostMapping()
	public ResponseEntity<Food> createItem(
			@RequestBody CreateFoodRequest item, 
			@RequestHeader("Authorization") String jwt)
			throws FoodException, UserException, RestaurantException {
		System.out.println("req-controller ----"+item);
		User user = userService.findUserProfileByJwt(jwt);
//		Category category=categoryService.findCategoryById(item.getCategoryId());
		Restaurant restaurant=restaurantService.findRestaurantById(item.getRestaurantId());
			Food menuItem = menuItemService.createFood(item,item.getCategory(),restaurant);
			return ResponseEntity.ok(menuItem);

	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Long id, @RequestHeader("Authorization") String jwt)
			throws UserException, FoodException {
		User user = userService.findUserProfileByJwt(jwt);
		
			menuItemService.deleteFood(id);
			return ResponseEntity.ok("Menu item deleted");
		
	
	}

	

	@GetMapping("/search")
	public ResponseEntity<List<Food>> getMenuItemByName(@RequestParam String name)  {
		List<Food> menuItem = menuItemService.searchFood(name);
		return ResponseEntity.ok(menuItem);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateAvilibilityStatus(
			@PathVariable Long id) throws FoodException {
		Food menuItems= menuItemService.updateAvailibilityStatus(id);
		return ResponseEntity.ok(menuItems);
	}
	
	

}
