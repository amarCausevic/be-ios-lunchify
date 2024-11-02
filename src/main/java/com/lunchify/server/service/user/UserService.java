package com.lunchify.server.service.user;

import com.lunchify.server.model.user.AddUserDTO;
import com.lunchify.server.model.user.UserDTO;
import com.lunchify.server.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceI {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public UserDTO addUser(AddUserDTO addUserDTO) {
    return userRepository.save(addUserDTO);
  }

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

  @Override
  public UserDTO updateUserDetails(UserDTO userDTO, String id) {
    UserDTO existingUser = userRepository.findById(id).orElseThrow(
        RuntimeException::new
    );

    existingUser.setEmail(userDTO.getEmail());
    existingUser.setDisplayName(userDTO.getDisplayName());
    userRepository.save(existingUser);

    return existingUser;
  }

  @Override
  public void deleteUser(String id) {
    userRepository.findById(id).orElseThrow(RuntimeException::new);
    userRepository.deleteById(id);
  }
}
