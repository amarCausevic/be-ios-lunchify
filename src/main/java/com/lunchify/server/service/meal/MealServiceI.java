package com.lunchify.server.service.meal;

import com.lunchify.server.model.meal.AddMealDTO;
import com.lunchify.server.model.meal.MealDTO;
import java.util.List;

public interface MealServiceI {

  AddMealDTO addMeal(AddMealDTO addMealDTO);

  List<MealDTO> getMeals();

  MealDTO getMealDetails(String id);

  MealDTO updateMealDetails(MealDTO meal, String id);

  void deleteMeal(String id);
}
