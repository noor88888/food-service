package com.food_order_api.Food_Catalogue_API.Mapper;

import com.food_order_api.Food_Catalogue_API.Dto.FoodDto;
import com.food_order_api.Food_Catalogue_API.Entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food mapFoodDtoToFood(FoodDto foodDTO);

    FoodDto mapFoodToFoodDto(Food foodItem);
}
