package com.lunchify.server.controller;

import com.lunchify.server.model.UserDTO;
import com.lunchify.server.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public List<UserDTO> geUsersList() {
    return userService.getUsers();
  }

  @GetMapping("{id}")
  public ResponseEntity<UserDTO> getUserDetails(@PathVariable("Id") String id) {
    return new ResponseEntity<UserDTO>(userService.getUserDetails(id), HttpStatus.OK);
  }
}
