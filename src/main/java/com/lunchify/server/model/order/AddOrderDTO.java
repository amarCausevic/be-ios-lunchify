package com.lunchify.server.model.order;

import com.lunchify.server.model.meal.MealDTO;
import com.lunchify.server.model.user.UserDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class AddOrderDTO {

  private String userName;
  private UserDTO user;
  private List<MealDTO> meals;
  private String status;
  private String timestampCreated;
  private String userComment;
}
