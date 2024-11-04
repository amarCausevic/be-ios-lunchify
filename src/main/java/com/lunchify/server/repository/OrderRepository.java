package com.lunchify.server.repository;

import com.lunchify.server.model.order.OrderDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDTO, String> {

}
