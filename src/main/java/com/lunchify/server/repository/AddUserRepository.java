package com.lunchify.server.repository;

import com.lunchify.server.model.user.AddUserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddUserRepository extends MongoRepository<AddUserDTO, String> {

}
