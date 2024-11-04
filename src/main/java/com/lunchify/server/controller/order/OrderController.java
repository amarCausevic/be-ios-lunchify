package com.lunchify.server.controller.order;

import com.lunchify.server.model.common.DeleteResponseDTO;
import com.lunchify.server.model.order.AddOrderDTO;
import com.lunchify.server.model.order.OrderDTO;
import com.lunchify.server.service.order.OrderServiceI;
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
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  OrderServiceI orderServiceI;

  @PostMapping
  public ResponseEntity<AddOrderDTO> addOrder(@RequestBody AddOrderDTO requestBody) {
    return new ResponseEntity<AddOrderDTO>(orderServiceI.addOrder(requestBody), HttpStatus.CREATED);
  }

  @GetMapping
  public List<OrderDTO> getOrderList() {
    return orderServiceI.getOrders();
  }

  @GetMapping("{id}")
  public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable("id") String id) {
    return new ResponseEntity<OrderDTO>(orderServiceI.getOrderDetails(id), HttpStatus.OK);
  }

  @PatchMapping("{id}")
  public ResponseEntity<OrderDTO> updateOrderDetails(@PathVariable("id") String id,
      @RequestBody OrderDTO requestBody) {
    return new ResponseEntity<OrderDTO>(orderServiceI.updateOrderDetails(requestBody, id),
        HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<DeleteResponseDTO> deleteOrder(@PathVariable("id") String id) {
    orderServiceI.deleteOrder(id);

    return new ResponseEntity<DeleteResponseDTO>(
        new DeleteResponseDTO("CRUD Delete Order",
            "Order has been successfully delete from database"),
        HttpStatus.OK);
  }
}
