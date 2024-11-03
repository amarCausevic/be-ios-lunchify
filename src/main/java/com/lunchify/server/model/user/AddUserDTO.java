package com.lunchify.server.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class AddUserDTO {

  private String name;
  private String displayName;
  private String email;
  private String device;
  private Boolean active;
}
