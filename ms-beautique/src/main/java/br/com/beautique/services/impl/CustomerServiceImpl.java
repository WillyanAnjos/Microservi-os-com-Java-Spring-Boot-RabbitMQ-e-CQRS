package br.com.beautique.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beautique.dtos.CustomerDTO;
import br.com.beautique.entities.CustomerEntity;
import br.com.beautique.repositories.CustomerRepository;
import br.com.beautique.services.BrokerService;
import br.com.beautique.services.CustomerService;
import br.com.beautique.utils.ConverterUtil;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BrokerService brokerService;

    private final ConverterUtil<CustomerEntity, CustomerDTO> converterUtil = new ConverterUtil<>(CustomerEntity.class, CustomerDTO.class);

    @Override
    public CustomerDTO create(CustomerDTO customer) {

        CustomerEntity customerEntity = converterUtil.convertToSource(customer);
        CustomerEntity newCustomerEntity = customerRepository.save(customerEntity);

        sendCustomerToQueue(newCustomerEntity);
        return converterUtil.convertToTarget(newCustomerEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);

        if (customerEntity.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        
        customerRepository.delete(customerEntity.get());
    }

    @Override
    public CustomerDTO update(CustomerDTO customer) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());

        if(customerEntity.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        CustomerEntity customerToUpdate = converterUtil.convertToSource(customer);
        customerToUpdate.setAppointmentsEntities(customerEntity.get().getAppointmentsEntities());
        customerToUpdate.setCreatedAt(customerEntity.get().getCreatedAt());

        //Update the customer
        CustomerDTO updateCustomerDTO = converterUtil.convertToTarget(customerRepository.save(customerToUpdate));
        
        //Send the customer to the queue
        sendCustomerToQueue(customerToUpdate);

        return updateCustomerDTO;

    }

    private void sendCustomerToQueue(CustomerEntity customer) {
        CustomerDTO customerDTO = converterUtil.convertToTarget(customer);
        brokerService.send("customer",customerDTO);
    }

}
