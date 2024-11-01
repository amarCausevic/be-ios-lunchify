package com.lunchify.server.controller;

import com.lunchify.server.model.UserDTO;
import com.lunchify.server.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<UserDTO> getUserInformation() {
    return userService.getUserInformation();
  }
}
