package com.lunchify.server.repository;

import com.lunchify.server.model.order.AddOrderDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddOrderRepository extends MongoRepository<AddOrderDTO, String> {

}
