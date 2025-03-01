package br.com.beautique.ms_sync.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface CustomerRepository extends MongoRepository<CustomerDTO, Long>{

}
