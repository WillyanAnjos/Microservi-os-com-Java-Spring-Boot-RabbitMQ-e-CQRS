package br.com.ms_beautique_query.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ms_beautique_query.dtos.customers.CustomerDTO;
import br.com.ms_beautique_query.repositories.CustomerRepository;
import br.com.ms_beautique_query.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> listAllCustomers() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error on list all customers", e);
        }
    }

    @Override
    public List<CustomerDTO> listByNameLikeIgnoreCase(String name) {
        try {
            return customerRepository.findByNameLikeIgnoreCase(name);
        } catch (Exception e) {
            throw new RuntimeException("Error on list all customers by name", e);
        }
    }

    @Override
    public List<CustomerDTO> listByEmailLikeIgnoreCase(String email) {
        try {
            return customerRepository.findByEmailLikeIgnoreCase(email);
        } catch (Exception e) {
            throw new RuntimeException("Error on list all customers by email", e);
        }
    }

}
