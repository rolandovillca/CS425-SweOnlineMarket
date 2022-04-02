package edu.miu.cs.cs425.sweonlinemarketproject.service;


import edu.miu.cs.cs425.sweonlinemarketproject.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order saveOrder(Order order);
    void deleteOrderById(Long orderId);
    List<Order> getOrdersByOwnerUserId(Long userId);

}
