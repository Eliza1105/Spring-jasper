package org.itstep.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value="/customers", produces="application/json")
    public List<Customer> getCustomers(){
        return customerService.findAll();
    }

    //сортировка по
    @GetMapping(value="/customers/{field}", produces="application/json")
    public List<Customer> getCustomersSorted(@PathVariable String field){
        return customerService.findByOrderBy(field);
    }


} 