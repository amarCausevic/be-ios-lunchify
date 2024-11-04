package com.lunchify.server.repository;

import com.lunchify.server.model.meal.AddMealDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddMealRepository extends MongoRepository<AddMealDTO, String> {

}
