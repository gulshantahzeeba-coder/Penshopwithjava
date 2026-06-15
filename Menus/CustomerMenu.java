package Menus;

import java.util.Scanner;
import Interfaces.ICustomer;

import Models.Customer;

public class CustomerMenu {
    private final ICustomer _iCustomerService;
    private final Scanner scanner;

    public CustomerMenu(ICustomer iCustomerService) {
        this._iCustomerService = iCustomerService;
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n    ---Information About Customer---    ");
            System.out.println(" 1. Add Customer ");
            System.out.println(" 2. List All Customer  ");
            // show search and delete option only if there are customers in the list;
            if (!_iCustomerService.getAllCustomer().isEmpty()) {
                System.out.println(" 3. Search Customers by ID ");
                System.out.println(" 4. Update Customers by ID ");
                System.out.println(" 5. Delete Customers by ID ");
            }
            System.out.println(" 0. Exit ");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume new line.
            switch (choice) {
                case 1 -> addCustomers();
                case 2 -> listCustomers();
                case 3 -> {
                    if (!_iCustomerService.getAllCustomer().isEmpty())
                        searchCustomer();
                    else
                        System.out.println("There is no Customer to Search!");

                }
                case 4 -> {
                    if (!_iCustomerService.getAllCustomer().isEmpty())
                        updateCustomer();
                    else
                        System.out.println("There is no Customer to update!");
                }
                case 5 -> {
                    if (!_iCustomerService.getAllCustomer().isEmpty())
                        deleteCustomer();
                    else
                        System.out.println("There is no Customer to Delete!");
                }
                case 0 -> {
                    exit = true;
                    System.out.println("Exciting the Program. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private void addCustomers() {
        boolean adding = true;

        while (adding) {
            System.out.print("\n Enter Customer Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the Customer Title: ");
            String customerTitle = scanner.nextLine();

            System.out.print("Enter the Customer Email: ");
            String customerEmail = scanner.nextLine();

            System.out.print("Enter the Customer Phone: ");
            String customerPhone = scanner.nextLine();

            _iCustomerService.addCustomer(new Customer(id, customerTitle, customerEmail, customerPhone));
            System.out.print("Customer added successfully!");

            System.out.print(" Would you like to run an other Customer? Y/N: ");
            String choice = scanner.nextLine();
            adding = choice.equalsIgnoreCase("Y");
        }
        System.out.println("\n Customer Added:");
        listCustomers();
    }

    private void listCustomers() {
        System.out.println(" \n ----List of Customers----");
        {
            if (_iCustomerService.getAllCustomer().isEmpty()) {
                System.out.println("There is no Customer in this Library.");
            } else {
                for (Customer customer : _iCustomerService.getAllCustomer()) {
                    System.out.println(customer);
                }
            }
        }
    }

    private void searchCustomer() {
        System.out.println("Enter the Customer to Search.");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = _iCustomerService.getCustomerById(id);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found with Id.");
        }
    }

    private void updateCustomer() {
        System.out.println("Enter the Customer Id to update");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume line.

        Customer existingCustomer = _iCustomerService.getCustomerById(customerId);
        if (existingCustomer != null) {
            System.out.println("Existing customer title: " + existingCustomer.getTitle() +
                    "\n" + "Now enter the new Title: ");
            String title = scanner.nextLine();
            if (title != "" && title != null)
                existingCustomer.setTitle((title));
            else
                System.out.println("You didn't enter any title now old title will be consider!");

            System.out.println("Enter the new Customer Email: ");
            String CustomerEmail = scanner.nextLine();
            if (CustomerEmail != "" && CustomerEmail != null)
                existingCustomer.setEmail(CustomerEmail);
            else
                System.out.println("You didn't enter any Customer Email now old Customer Email will be consider!");

            System.out.println("Enter the new Phone ");
            String CustomerPhone = scanner.nextLine();
            if (CustomerPhone != "" && CustomerPhone != null)
                existingCustomer.setPhone(CustomerPhone);
            else
                System.out.println(
                        "You didn't enter any customerPhone now old customer Phone will be consider!");

            _iCustomerService.updateCustomer(customerId, existingCustomer);
            System.out.println("Customer updated successfully!");

        } else {
            System.out.println("Customer not found with ID " + customerId);
        }
    }

    private void deleteCustomer() {

        System.out.println("Enter the Customer ID to Delete");
        int customerId = scanner.nextInt();

        Customer customer = _iCustomerService.getCustomerById(customerId);
        if (customer != null) {
            _iCustomerService.deleteCustomer(customerId);
            System.out.println("Customer Deleted Successfully");
        } else {
            System.out.println("Customer not found with ID." + customerId);
        }
    }

    public void seedCustomers() {
        _iCustomerService.addCustomer(new Customer(1, "John Doe", "john.doe@example.com", "(202) 555-0123"));
        _iCustomerService.addCustomer(new Customer(2, "Jane Smith", "jane.smith@example.com", "(202) 555-0456"));
        _iCustomerService.addCustomer(new Customer(3, "Alice Johnson", "alice.johnson@example.com", "(202) 555-0789"));
        _iCustomerService.addCustomer(new Customer(4, "Bob Brown", "bob.brown@example.com", "(202) 555-1012"));
        _iCustomerService.addCustomer(new Customer(5, "Charlie Davis", "charlie.davis@example.com", "(202) 555-1345"));
        _iCustomerService.addCustomer(new Customer(6, "Emily Evans", "emily.evans@example.com", "(202) 555-1678"));
        _iCustomerService.addCustomer(new Customer(7, "Frank Green", "frank.green@example.com", "(202) 555-1900"));
        _iCustomerService.addCustomer(new Customer(8, "Grace Hall", "grace.hall@example.com", "(202) 555-2234"));
        _iCustomerService.addCustomer(new Customer(9, "Hannah Lee", "hannah.lee@example.com", "(202) 555-2567"));
        _iCustomerService.addCustomer(new Customer(10, "Ian Kim", "ian.kim@example.com", "(202) 555-2890"));
        
        System.out.println("10 Customers have been seeded to the library.");

    }
}