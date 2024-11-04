package com.lunchify.server.service.meal;

import com.lunchify.server.model.meal.AddMealDTO;
import com.lunchify.server.model.meal.MealDTO;
import com.lunchify.server.repository.AddMealRepository;
import com.lunchify.server.repository.MealRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService implements MealServiceI {

  @Autowired
  private MealRepository mealRepository;

  @Autowired
  private AddMealRepository addMealRepository;

  @Override
  public AddMealDTO addMeal(AddMealDTO addMealDTO) {
    return addMealRepository.save(addMealDTO);
  }

  @Override
  public List<MealDTO> getMeals() {
    return mealRepository.findAll();
  }

  @Override
  public MealDTO getMealDetails(String id) {
    Optional<MealDTO> meal = mealRepository.findById(id);

    if (meal.isPresent()) {
      return meal.get();
    }

    throw new RuntimeException();
  }

  @Override
  public MealDTO updateMealDetails(MealDTO updatedMeal, String id) {
    MealDTO existingMeal = mealRepository.findById(id).orElseThrow(
        RuntimeException::new
    );

    //TODO: Find more clean way to fill up all information needed to update meal information
    existingMeal.setDisplayName(updatedMeal.getDisplayName());
    existingMeal.setName(updatedMeal.getName());
    existingMeal.setComments(updatedMeal.getComments());
    existingMeal.setIngredients(updatedMeal.getIngredients());
    existingMeal.setCautionIngredients(updatedMeal.getCautionIngredients());
    mealRepository.save(existingMeal);

    return existingMeal;
  }

  @Override
  public void deleteMeal(String id) {
    mealRepository.findById(id).orElseThrow(RuntimeException::new);
    mealRepository.deleteById(id);
  }
}
