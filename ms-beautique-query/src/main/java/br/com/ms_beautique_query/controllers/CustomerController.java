package br.com.ms_beautique_query.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms_beautique_query.dtos.customers.CustomerDTO;
import br.com.ms_beautique_query.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<List<CustomerDTO>> listAllCustomers() {
        return ResponseEntity.ok(customerService.listAllCustomers());
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<CustomerDTO>> listCustomersByName(String name) {
        return ResponseEntity.ok(customerService.listByNameLikeIgnoreCase(name));
    }

    @GetMapping("/email/{email}")
    ResponseEntity<List<CustomerDTO>> listCustomersByEmail(String email) {
        return ResponseEntity.ok(customerService.listByEmailLikeIgnoreCase(email));
    }
}
