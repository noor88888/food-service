package com.food_order_api.Food_Catalogue_API.Dto;

import com.food_order_api.Food_Catalogue_API.Entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRestaurantPage {
    private List<Food> foodList;
    private Restaurant restaurant;
}
