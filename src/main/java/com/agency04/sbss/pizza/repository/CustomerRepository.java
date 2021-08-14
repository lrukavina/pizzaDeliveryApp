package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    @Transactional
    void deleteCustomerByUsername(String username);

}
