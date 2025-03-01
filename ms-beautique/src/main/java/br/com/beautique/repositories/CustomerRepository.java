package br.com.beautique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.beautique.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
