package cl.integraltech.customer.controller;

import cl.integraltech.customer.entities.Customer;
import cl.integraltech.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // Listar Todos los Clientes
    @GetMapping("/")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Buscar Cliente por ID
    @GetMapping("/{id}")
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    // Buscar Cliente por Nombre
    @GetMapping("/name/{name}")
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    // Buscar Cliente por Email
    @GetMapping("/email/{email}")
    public List<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    // Registrar nuevo Cliente
    @PostMapping()
    public Customer save(@RequestBody Customer input) {
       Customer save = customerRepository.save(input);
       return save;
    }

    // Actualizar Cliente
    @PutMapping("/{id}")
    public Customer update(@PathVariable String id, @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Eliminar Cliente
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, @RequestBody Customer customer){
        customerRepository.delete(customer);
    }


}
