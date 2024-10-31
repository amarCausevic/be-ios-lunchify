package com.lunchify.server.service;

import com.lunchify.server.model.UserDTO;
import java.util.List;

public interface UserService {

  List<UserDTO> getUsers();

  UserDTO getUserDetails(String id);
}
