package com.lunchify.server.service.order;

import com.lunchify.server.model.order.AddOrderDTO;
import com.lunchify.server.model.order.OrderDTO;
import java.util.List;

public interface OrderServiceI {

  AddOrderDTO addOrder(AddOrderDTO order);

  List<OrderDTO> getOrders();

  OrderDTO getOrderDetails(String id);

  OrderDTO updateOrderDetails(OrderDTO order, String id);

  void deleteOrder(String id);
}
