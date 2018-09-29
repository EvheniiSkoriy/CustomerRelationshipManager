package source.service;

import source.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);

    List<Customer> getCustomersByLastName(String lastName);

    void updateCustomer(Customer customerToUpdate,Customer customer);
}
