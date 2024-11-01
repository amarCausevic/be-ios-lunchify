package com.lunchify.server.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserDTO {

  @Id
  private String id;
  private String name;
  private String displayName;
  private String email;
  private String device;
  private Boolean active;
}
