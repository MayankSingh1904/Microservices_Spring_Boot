package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-list";
    }

    @GetMapping("/orders/new")
    public String showForm(Model model) {
        model.addAttribute("order", new Order());
        return "order-form";
    }

    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
}