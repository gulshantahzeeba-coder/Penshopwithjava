package Interfaces;

import java.util.List;

import Models.Customer;

public interface ICustomer {

    void addCustomer(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomer();

    void updateCustomer(int id, Customer updatedCustomer);

    void deleteCustomer(int id);
}
