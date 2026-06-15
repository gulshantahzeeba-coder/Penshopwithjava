package Menus;

import java.util.Scanner;
import Interfaces.ICompany;
import Models.Company;

public class CompanyMenu {
    private final ICompany _iCompanyService;
    private final Scanner scanner;

    public CompanyMenu(ICompany iCompanyService) {
        this._iCompanyService = iCompanyService;
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n    ---Information About Company---    ");
            System.out.println(" 1. Add Company ");
            System.out.println(" 2. List All Company  ");
            // show search and delete option only if there are companies in the list;
            if (!_iCompanyService.getAllCompanies().isEmpty()) {
                System.out.println(" 3. Search Companies by ID ");
                System.out.println(" 4. Update Companies by ID ");
                System.out.println(" 5. Delete Companies by ID ");
            }
            System.out.println(" 0. Exit ");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume new line.
            switch (choice) {
                case 1 -> addCompanies();
                case 2 -> listCompanies();
                case 3 -> {
                    if (!_iCompanyService.getAllCompanies().isEmpty())
                        searchCompany();
                    else
                        System.out.println("There is no Company to Search ");

                }
                case 4 -> {
                    if (!_iCompanyService.getAllCompanies().isEmpty())
                        updateCompany();
                    else
                        System.out.println("There is no Company to update!");
                }
                case 5 -> {
                    if (!_iCompanyService.getAllCompanies().isEmpty())
                        deleteCompany();
                    else
                        System.out.println("There is no Company to Delete!");
                }
                case 0 -> {
                    exit = true;
                    System.out.println("Exciting the Program. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private void addCompanies() {
        boolean adding = true;

        while (adding) {
            System.out.println("\n Enter Company Id");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the Company Title");
            String companyTitle = scanner.nextLine();

            System.out.println("Enter the companyPhoneNumber");
            String companyPhoneNumber = scanner.nextLine();

            System.out.println("Enter the Company Owner");
            String CompanyOwner = scanner.nextLine();

            _iCompanyService.addCompany(new Company(id, companyTitle, companyPhoneNumber, CompanyOwner));
            System.out.print("Company added successfully!");

            System.out.print(" would you like to run an other Company?");
            String choice = scanner.nextLine();
            adding = choice.equalsIgnoreCase("Y");
        }
        System.out.println("\n Company Added:");
        listCompanies();
    }

    private void listCompanies() {
        System.out.println("\n  ---List of companies---  ");
        if (_iCompanyService.getAllCompanies().isEmpty()) {
            System.out.println("There is no Company in Library.");
        } else {
            for (Company company : _iCompanyService.getAllCompanies()) {
                System.out.println(company);
            }
        }
    }

    private void searchCompany() {
        System.out.println("Enter Company ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume new Line.

        Company company = _iCompanyService.getCompanyById(id);
        if (company != null) {
            System.out.println("Company found: " + company);
        } else {
            System.out.println("Company not found with Id.");
        }
    }

    private void updateCompany() {
        System.out.println("Enter the Company Id to update: ");
        int companyId = scanner.nextInt();
        scanner.nextLine(); // consume line.

        Company existingCompany = _iCompanyService.getCompanyById(companyId);
        if (existingCompany != null) {
            System.out.println("Existing company title: " + existingCompany.getCompanyTitle() +
                    "\n" + "Now enter the new Title: ");
            String title = scanner.nextLine();
            if (title != "" && title != null)
                existingCompany.setCompanyTitle((title));
            else
                System.out.println("You didn't enter any title now old title will be consider!");

            System.out.println("Enter the new Phone Number");
            String companyPhoneNumber = scanner.nextLine();
            if (companyPhoneNumber != "" && companyPhoneNumber != null)
                existingCompany.setCompanyPhoneNumber(companyPhoneNumber);
            else
                System.out.println(
                        "You didn't enter any companyPhoneNumber now old company Phone Number will be consider!");

            System.out.println("Enter the new Company Owner: ");
            String CompanyOwner = scanner.nextLine();
            if (CompanyOwner != "" && CompanyOwner != null)
                existingCompany.setCompanyOwner(CompanyOwner);
            else
                System.out.println("You didn't enter any Company Owner now old Company Owner will be consider!");

            _iCompanyService.updateCompany(companyId, existingCompany);
            System.out.println("Company updated successfully!");

        } else {
            System.out.println("Company not found with ID " + companyId);
        }
    }

    private void deleteCompany() {

        System.out.println("Enter the Company ID to Delete");
        int companyId = scanner.nextInt();

        Company company = _iCompanyService.getCompanyById(companyId);
        if (company != null) {
            _iCompanyService.deleteCompany(companyId);
            System.out.println("Company Deleted Successfully");
        } else {
            System.out.println("Company not found with ID." + companyId);
        }
    }

    public void seedCompanies() {
        _iCompanyService.addCompany(new Company(1, "Tech Innovators Inc.", "(202) 555-0123", "Sarah Connor"));
_iCompanyService.addCompany(new Company(2, "Green Solutions Ltd.", "(202) 555-0456", "Michael Smith"));
_iCompanyService.addCompany(new Company(3, "Creative Designs Co.", "(202) 555-0789", "Emily Clark"));
_iCompanyService.addCompany(new Company(4, "Global Ventures Group", "(202) 555-1012", "David Johnson"));
_iCompanyService.addCompany(new Company(5, "Smart Home Systems", "(202) 555-1345", "Jessica Davis"));
_iCompanyService.addCompany(new Company(6, "EcoFriendly Products", "(202) 555-1678", "Daniel Wilson"));
_iCompanyService.addCompany(new Company(7, "Future Tech Solutions", "(202) 555-1900", "Laura Taylor"));
_iCompanyService.addCompany(new Company(8, "Health First Group", "(202) 555-2234", "James Brown"));
_iCompanyService.addCompany(new Company(9, "Travel Experts Agency", "(202) 555-2567", "Megan Lee"));
_iCompanyService.addCompany(new Company(10, "Bright Futures LLC", "(202) 555-2890", "Robert White"));

        System.out.println("10 Companies have been seeded to the library.");

    }
}
