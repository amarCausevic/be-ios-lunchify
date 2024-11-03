package com.lunchify.server.controller.user;

import com.lunchify.server.model.user.AddUserDTO;
import com.lunchify.server.model.user.DeleteUserDTO;
import com.lunchify.server.model.user.UserDTO;
import com.lunchify.server.service.user.UserServiceI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserServiceI userService;

  @PostMapping
  public ResponseEntity<AddUserDTO> addUser(@RequestBody AddUserDTO userRequestBody) {
    return new ResponseEntity<AddUserDTO>(userService.addUser(userRequestBody), HttpStatus.CREATED);
  }

  @GetMapping
  public List<UserDTO> geUsersList() {
    return userService.getUsers();
  }

  @GetMapping("{id}")
  public ResponseEntity<UserDTO> getUserDetails(@PathVariable("id") String id) {
    return new ResponseEntity<UserDTO>(userService.getUserDetails(id), HttpStatus.OK);
  }

  @PatchMapping("{id}")
  public ResponseEntity<UserDTO> updateUserDetails(@PathVariable("id") String id,
      @RequestBody UserDTO userRequestBody) {
    return new ResponseEntity<UserDTO>(userService.updateUserDetails(userRequestBody, id),
        HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<DeleteUserDTO> deleteUser(@PathVariable("id") String id) {
    userService.deleteUser(id);
    return new ResponseEntity<DeleteUserDTO>(
        new DeleteUserDTO("CRUD Delete User", "User has been successfully delete from database"),
        HttpStatus.OK);
  }
}
