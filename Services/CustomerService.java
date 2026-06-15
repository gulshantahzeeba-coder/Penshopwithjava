package Services;

import java.util.ArrayList;
import java.util.List;

import Interfaces.ICustomer;
import Models.Customer;

public class CustomerService implements ICustomer {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        // gGet customer by id from in memory customer list.
        return customers.stream().filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(customers);
    }

    @Override
    public void updateCustomer(int id, Customer updatedCustomer) {
        Customer customer = getCustomerById(id);
        {
            if (customer != null) {
                customer.setTitle(updatedCustomer.getTitle());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setPhone(updatedCustomer.getPhone());

            }
        }

    }

    @Override
    public void deleteCustomer(int id) {
        customers.removeIf(cust -> cust.getId() == id);
    }
}
