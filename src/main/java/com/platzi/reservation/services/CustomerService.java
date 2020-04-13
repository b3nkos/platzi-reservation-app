package com.platzi.reservation.services;

import com.platzi.reservation.model.Customer;
import com.platzi.reservation.repository.CustomerRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer create(@NonNull Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    public Customer update(@NonNull Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Transactional
    public void delete(@NonNull Customer customer) {
        this.customerRepository.delete(customer);
    }

    public Customer findByIdentification(String identification) {
        return this.customerRepository.findByIdentification(identification);
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
