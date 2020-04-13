package com.platzi.reservation.repository;

import com.platzi.reservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    /**
     *
     * @param lastName
     * @return
     */
    public List<Customer> findByLastName(String lastName);

    public Customer findByIdentification(String identification);
}
