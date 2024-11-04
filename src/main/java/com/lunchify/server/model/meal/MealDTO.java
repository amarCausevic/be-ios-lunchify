package com.lunchify.server.model.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "meals")
public class MealDTO {

  @Id
  private String id;
  private String name;
  private String displayName;
  private String ingredients;
  private String cautionIngredients;
  private String comments;
  private String timestampCreated;
  private String timestampPrepareOn;
}