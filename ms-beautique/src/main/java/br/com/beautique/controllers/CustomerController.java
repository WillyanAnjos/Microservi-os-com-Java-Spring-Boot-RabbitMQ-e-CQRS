package br.com.beautique.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beautique.dtos.CustomerDTO;
import br.com.beautique.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    ResponseEntity<CustomerDTO> create (@RequestBody CustomerDTO customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping()
    ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customer) {
        return ResponseEntity.ok(customerService.update(customer));
    }
}
