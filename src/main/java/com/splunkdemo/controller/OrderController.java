package com.splunkdemo.controller;

import com.splunkdemo.dto.Order;
import com.splunkdemo.util.OrderMapper;
import com.splunkdemo.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        logger.info("OrderController:placeOrder persist order request: {}", OrderMapper.mapToJsonString(order));
        Order addOrder = orderService.addOrder(order);
        logger.info("OrderController:placeOrder response from service: {}", OrderMapper.mapToJsonString(addOrder));
        return addOrder;
    }

    @GetMapping
    public List<Order> getOrders() {
        List<Order> orders = orderService.getOrders();
        logger.info("OrderController:getOrders response from service: {}", OrderMapper.mapToJsonString(orders));
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        logger.info("OrderController:getOrder fetch order by id: {}", id);
        Order order = orderService.getOrder(id);
        logger.info("OrderController:getOrder fetch order response: {}", OrderMapper.mapToJsonString(order));
        return order;
    }
}
