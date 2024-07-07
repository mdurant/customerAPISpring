package cl.integraltech.customer.repository;

import cl.integraltech.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{
    List<Customer> findByName(String name);
    List<Customer> findByEmail(String email);
}
