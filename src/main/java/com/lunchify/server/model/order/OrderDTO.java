package com.lunchify.server.model.order;

import com.lunchify.server.model.meal.MealDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class OrderDTO {

  @Id
  private String id;
  private String userName;
  private String userId;
  private List<MealDTO> meals;
  private String status;
  private String timestampCreated;
  private String userComment;
}
