package org.itstep.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value="/orders", produces="application/json")
    public List<Order> getCustomers(){
        return orderService.findAll();
    }


} 