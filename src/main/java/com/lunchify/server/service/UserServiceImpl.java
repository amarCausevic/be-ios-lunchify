package com.lunchify.server.service;

import com.lunchify.server.model.UserDTO;
import com.lunchify.server.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserDTO> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public UserDTO getUserDetails(String id) {
    Optional<UserDTO> user = userRepository.findById(id);

    if (user.isPresent()) {
      return user.get();
    }

    throw new RuntimeException();
  }
}
