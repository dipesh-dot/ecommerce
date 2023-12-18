package com.orderservice.service;


import com.orderservice.dto.OrderDto;
import com.orderservice.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {





    public Order saveOrderFromDto(OrderDto orderDto);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    boolean deleteOrderById(Long id);
}
