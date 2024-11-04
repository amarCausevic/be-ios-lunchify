package com.lunchify.server.controller.meal;

import com.lunchify.server.model.common.DeleteResponseDTO;
import com.lunchify.server.model.meal.AddMealDTO;
import com.lunchify.server.model.meal.MealDTO;
import com.lunchify.server.service.meal.MealServiceI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meal")
public class MealController {

  @Autowired
  MealServiceI mealServiceI;

  @PostMapping
  public ResponseEntity<AddMealDTO> addMeal(@RequestBody AddMealDTO requestBody) {
    return new ResponseEntity<AddMealDTO>(mealServiceI.addMeal(requestBody), HttpStatus.CREATED);
  }

  @GetMapping
  public List<MealDTO> geMealList() {
    return mealServiceI.getMeals();
  }

  @GetMapping("{id}")
  public ResponseEntity<MealDTO> getMealDetails(@PathVariable("id") String id) {
    return new ResponseEntity<MealDTO>(mealServiceI.getMealDetails(id), HttpStatus.OK);
  }

  @PatchMapping("{id}")
  public ResponseEntity<MealDTO> updateMealDetails(@PathVariable("id") String id,
      @RequestBody MealDTO requestBody) {
    return new ResponseEntity<MealDTO>(mealServiceI.updateMealDetails(requestBody, id),
        HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<DeleteResponseDTO> deleteMeal(@PathVariable("id") String id) {
    mealServiceI.deleteMeal(id);

    return new ResponseEntity<DeleteResponseDTO>(
        new DeleteResponseDTO("CRUD Delete Meal",
            "Meal has been successfully delete from database"),
        HttpStatus.OK);
  }
}
