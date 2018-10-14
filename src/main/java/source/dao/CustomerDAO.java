package source.dao;

import source.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);

    List<Customer> getCustomersByLastName(String lastName);
}
