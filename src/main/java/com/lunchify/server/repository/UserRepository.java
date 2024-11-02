package com.lunchify.server.repository;

import com.lunchify.server.model.user.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDTO, String> {

}
