package br.com.beautique.services;

import br.com.beautique.dtos.CustomerDTO;

public interface  CustomerService {
    CustomerDTO create(CustomerDTO customer);
    CustomerDTO update(CustomerDTO customer);

    void delete(Long id);
}
