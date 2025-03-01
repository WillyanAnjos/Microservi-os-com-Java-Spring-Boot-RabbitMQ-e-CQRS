package br.com.ms_beautique_query.services;

import java.util.List;

import br.com.ms_beautique_query.dtos.customers.CustomerDTO;

public interface CustomerService {
    
    List<CustomerDTO> listAllCustomers();
    List<CustomerDTO> listByNameLikeIgnoreCase(String name);
    List<CustomerDTO> listByEmailLikeIgnoreCase(String email);
}
