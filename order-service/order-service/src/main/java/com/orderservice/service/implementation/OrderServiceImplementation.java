package com.orderservice.service.implementation;


import com.orderservice.dto.OrderDto;
import com.orderservice.entity.Order;
import com.orderservice.productproxy.ProductProxy;
import com.orderservice.productproxy.ProductServiceClient;
import com.orderservice.repository.OrderRepository;
import com.orderservice.service.OrderService;
import com.orderservice.userproxy.UserProxy;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    private final UserProxy userProxy;
    private final ProductProxy productProxy;
    private final ProductServiceClient productServiceClient;


    public OrderServiceImplementation(OrderRepository orderRepository, UserProxy userProxy, ProductProxy productProxy, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.userProxy = userProxy;
        this.productProxy = productProxy;
        this.productServiceClient = productServiceClient;
    }


    @Override
    public Order saveOrderFromDto(OrderDto orderDto) {
        try {
            // Use Feign clients to get additional data
            String userName = userProxy.getUser(orderDto.getUserId());
            String productName = productProxy.getProductName(orderDto.getProductId());
            double productPrice = productServiceClient.getProductPrice(orderDto.getProductId());

            // Calculate total amount
            double totalAmount = productPrice * orderDto.getQuantity();

            // Create an Order entity with the gathered data
            Order order = new Order();
            order.setUserId(orderDto.getUserId());
            order.setProductId(orderDto.getProductId());
            order.setOrderDate(new Date());  // You may set the order date as needed
            order.setQuantity(orderDto.getQuantity());
            order.setTotalAmount(totalAmount);

            // Save the order to the database
            return orderRepository.save(order);
        } catch (FeignException e) {
            // Handle Feign client exceptions
            if (e.status() == 401) {
                // Log or handle 401 Unauthorized error
                // You may want to throw a custom exception or take appropriate actions
                throw new RuntimeException("Error while processing order: Unauthorized", e);
            } else {
                // Log or handle other Feign client exceptions
                throw new RuntimeException("Error while processing order", e);
            }
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("Error while processing order", e);
        }
    }

    @Override
    public Order getOrderById(Long id) {
        // Implement the logic to get an order by ID
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        // Implement the logic to get all orders
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteOrderById(Long id) {
        // Implement the logic to delete an order by ID
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
