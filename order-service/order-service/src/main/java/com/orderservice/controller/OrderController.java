package com.orderservice.controller;

import com.orderservice.dto.OrderDto;
import com.orderservice.entity.Order;
import com.orderservice.generic.CustomResponseMessage;
import com.orderservice.productproxy.ProductProxy;
import com.orderservice.productproxy.ProductServiceClient;
import com.orderservice.service.OrderService;
import com.orderservice.userproxy.UserProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final UserProxy userProxy;
    private final ProductProxy productProxy;

    private final ProductServiceClient productServiceClient;

    public OrderController(OrderService orderService, UserProxy userProxy, ProductProxy productProxy, OrderDto orderDto, ProductServiceClient productServiceClient) {
        this.orderService = orderService;
        this.userProxy = userProxy;
        this.productProxy = productProxy;

        this.productServiceClient = productServiceClient;
    }

//    @PostMapping("/save")
//    ResponseEntity<CustomResponseMessage> OrderSave(@RequestBody Order order) {
//
//
//        return getGlobalResponse(HttpStatus.CREATED, orderService.saveOrder(order), "order Saved SuccessFully ");
//    }


    @PostMapping("/save")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        // Call a method in the service to save the order
        Order savedOrder = orderService.saveOrderFromDto(orderDto);

        // You can customize the response based on your requirements
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }





    @GetMapping("/{id}")
    OrderDto getOrderById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        if (order == null) {
            return null;
        }



        return OrderDto.builder()
                .userName(userProxy.getUser(order.getUserId()))
                .productName(productProxy.getProductName(order.getProductId()))
                .orderDate(order.getOrderDate())
                .quantity(order.getQuantity())
                .totalAmount(order.getTotalAmount())
                .build();
    }

    @GetMapping("/all")
    ResponseEntity<CustomResponseMessage> getAll() {
        return getGlobalResponse(HttpStatus.FOUND, orderService.getAllOrders(), "All Order found  ");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<CustomResponseMessage> deleteOrder(@PathVariable Long id) {
        return getGlobalResponse(HttpStatus.OK, orderService.deleteOrderById(id), "Order deleted by id   ");
    }

    private ResponseEntity<CustomResponseMessage> getGlobalResponse(HttpStatus status, Object data, String message) {
        return ResponseEntity.ok(CustomResponseMessage.builder().status(status).data(data).message(message).build());
    }
}
