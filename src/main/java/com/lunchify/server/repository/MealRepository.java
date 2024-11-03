package com.lunchify.server.repository;

import com.lunchify.server.model.meal.MealDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<MealDTO, String> {

}
