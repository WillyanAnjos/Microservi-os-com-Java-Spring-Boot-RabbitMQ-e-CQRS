package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
}
