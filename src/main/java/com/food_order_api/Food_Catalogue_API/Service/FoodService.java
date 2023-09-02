package com.food_order_api.Food_Catalogue_API.Service;

import com.food_order_api.Food_Catalogue_API.Dto.FoodDto;
import com.food_order_api.Food_Catalogue_API.Dto.FoodRestaurantPage;

public interface FoodService {

    FoodDto addFood(FoodDto foodDto);


    FoodRestaurantPage getFoodByRestaurantId(Integer restaurantId);
}
