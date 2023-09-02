package com.food_order_api.Food_Catalogue_API.Controller;

import com.food_order_api.Food_Catalogue_API.Dto.FoodDto;
import com.food_order_api.Food_Catalogue_API.Dto.FoodRestaurantPage;
import com.food_order_api.Food_Catalogue_API.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@CrossOrigin

public class FoodController
{
    @Autowired
    FoodService foodService;

    @PostMapping()
    public ResponseEntity<FoodDto> addFoodItem(@RequestBody FoodDto foodDTO){
        FoodDto foodItemSaved = foodService.addFood(foodDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    ResponseEntity<FoodRestaurantPage> getFoodByRestaurantId(@PathVariable Integer restaurantId)
    {
        FoodRestaurantPage foodRestaurantPage= foodService.getFoodByRestaurantId(restaurantId);
        return new ResponseEntity<>(foodRestaurantPage,HttpStatus.OK);
    }
}
