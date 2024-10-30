package com.lunchify.server.service;

import com.lunchify.server.model.UserDTO;
import com.lunchify.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO getUserInformation() {
    return (UserDTO) userRepository.findAll();
  }
}
