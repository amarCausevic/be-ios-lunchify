package com.lunchify.server.service.order;

import com.lunchify.server.enums.OrderStatus;
import com.lunchify.server.model.order.AddOrderDTO;
import com.lunchify.server.model.order.OrderDTO;
import com.lunchify.server.repository.AddOrderRepository;
import com.lunchify.server.repository.OrderRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceI {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private AddOrderRepository addOrderRepository;

  @Override
  public AddOrderDTO addOrder(AddOrderDTO order) {
    return addOrderRepository.save(order);
  }

  @Override
  public List<OrderDTO> getOrders() {
    return orderRepository.findAll();
  }

  @Override
  public OrderDTO getOrderDetails(String id) {
    Optional<OrderDTO> order = orderRepository.findById(id);

    if (order.isPresent()) {
      return order.get();
    }

    throw new RuntimeException();
  }

  @Override
  public OrderDTO updateOrderDetails(OrderDTO updatedOrder, String id) {
    Timestamp timestamp = new Timestamp(new Date().getTime());
    OrderDTO existingOrder = orderRepository.findById(id).orElseThrow(
        RuntimeException::new
    );

    //TODO: Find more clean way to fill up all information needed to update order information
    existingOrder.setMeals(updatedOrder.getMeals());
    existingOrder.setUserComment(updatedOrder.getUserComment());
    existingOrder.setTimestampCreated(timestamp.toString());
    existingOrder.setStatus(OrderStatus.UPDATED.val());
    orderRepository.save(existingOrder);

    return existingOrder;
  }

  @Override
  public void deleteOrder(String id) {
    orderRepository.findById(id).orElseThrow(RuntimeException::new);
    orderRepository.deleteById(id);
  }
}
