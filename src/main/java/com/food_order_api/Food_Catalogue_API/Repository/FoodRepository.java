package com.food_order_api.Food_Catalogue_API.Repository;

import com.food_order_api.Food_Catalogue_API.Dto.FoodRestaurantPage;
import com.food_order_api.Food_Catalogue_API.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

    List<Food> findByrestaurantId(Integer restaurantId);
}
