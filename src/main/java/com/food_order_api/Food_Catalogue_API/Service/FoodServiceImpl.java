package com.food_order_api.Food_Catalogue_API.Service;

import com.food_order_api.Food_Catalogue_API.Dto.FoodDto;
import com.food_order_api.Food_Catalogue_API.Dto.FoodRestaurantPage;
import com.food_order_api.Food_Catalogue_API.Dto.Restaurant;
import com.food_order_api.Food_Catalogue_API.Entity.Food;
import com.food_order_api.Food_Catalogue_API.Mapper.FoodMapper;
import com.food_order_api.Food_Catalogue_API.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodServiceImpl implements  FoodService{

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestTemplate restTemplate;
    @Override
    public FoodDto addFood(FoodDto foodDto) {
        Food food=foodRepository.save(FoodMapper.INSTANCE.mapFoodDtoToFood(foodDto));
        return FoodMapper.INSTANCE.mapFoodToFoodDto(food);
    }

    @Override
    public FoodRestaurantPage getFoodByRestaurantId(Integer restaurantId)
    {
        List<Food> foodList =  fetchFoodList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetails(restaurantId);
        return createFoodRestaurantPage(foodList, restaurant);
    }

    private FoodRestaurantPage createFoodRestaurantPage(List<Food> foodList, Restaurant restaurant)
    {
        FoodRestaurantPage foodRestaurantPage=new FoodRestaurantPage();
        foodRestaurantPage.setFoodList(foodList);
        foodRestaurantPage.setRestaurant(restaurant);
        return foodRestaurantPage;
    }

    private Restaurant fetchRestaurantDetails(Integer restaurantId) {
        Restaurant restaurant= restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId,Restaurant.class);
        return restaurant;
    }

    private List<Food> fetchFoodList(Integer restaurantId) {
        return foodRepository.findByrestaurantId(restaurantId);
    }
}
