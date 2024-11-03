package com.lunchify.server.service.user;

import com.lunchify.server.model.user.AddUserDTO;
import com.lunchify.server.model.user.UserDTO;
import java.util.List;

public interface UserServiceI {

  AddUserDTO addUser(AddUserDTO addUserDTO);

  List<UserDTO> getUsers();

  UserDTO getUserDetails(String id);

  UserDTO updateUserDetails(UserDTO user, String id);

  void deleteUser(String id);
}
