package com.food_order_api.Food_Catalogue_API.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.food_order_api.Food_Catalogue_API.Dto.FoodDto;
import com.food_order_api.Food_Catalogue_API.Dto.FoodRestaurantPage;
import com.food_order_api.Food_Catalogue_API.Service.FoodService;

public class FoodControllerTest {
	@Mock
    private FoodService foodCatalogueService;

    @InjectMocks
    private FoodController foodCatalogueController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addFoodItem_ShouldReturnCreatedStatus() {
        // Arrange
        FoodDto foodItemDTO = new FoodDto();
        when(foodCatalogueService.addFood(any(FoodDto.class))).thenReturn(foodItemDTO);

        // Act
        ResponseEntity<FoodDto> response = foodCatalogueController.addFoodItem(foodItemDTO);

        // Assert
        verify(foodCatalogueService, times(1)).addFood(foodItemDTO);
        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == foodItemDTO;
    }

    @Test
    void fetchRestauDetailsWithFoodMenu_ShouldReturnOkStatus() {
        // Arrange
        int restaurantId = 123;
        FoodRestaurantPage foodCataloguePage = new FoodRestaurantPage();
        when(foodCatalogueService.getFoodByRestaurantId(restaurantId)).thenReturn(foodCataloguePage);

        // Act
        ResponseEntity<FoodRestaurantPage> response = foodCatalogueController.getFoodByRestaurantId(restaurantId);

        // Assert
        verify(foodCatalogueService, times(1)).getFoodByRestaurantId(restaurantId);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == foodCataloguePage;
    }

}
