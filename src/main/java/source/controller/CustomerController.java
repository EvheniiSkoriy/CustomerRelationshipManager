package source.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import source.entity.Customer;
import source.exception.CustomerNotFoundException;
import source.service.CustomerService;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/blog")
    public List<Customer> showCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId){
        if(customerService.getCustomerById(customerId) ==null){
            throw new CustomerNotFoundException("Customer not found: " + customerId);
        }
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

//    @PutMapping("/customers/{customerId}")
//    public Customer updateCustomer(@RequestBody Customer customer,
//                                   @PathVariable Integer customerId){
//        if(customerService.getCustomerById(customerId) ==null){
//            throw new CustomerNotFoundException("Customer not found: " + customerId);
//        }
//        customerService.saveCustomer(customerService.updateCustomer(customerService.getCustomerById(customerId),customer););
//        return customerService.getCustomerById(customerId);
//    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerById(@PathVariable Integer customerId){
        if(customerService.getCustomerById(customerId) ==null){
            throw new CustomerNotFoundException("Customer not found: " + customerId);
        }
        customerService.deleteCustomerById(customerId);
        return "deleted customer with id: "+customerId;
    }
}
