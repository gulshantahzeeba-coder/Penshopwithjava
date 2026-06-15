package Services;

import java.util.ArrayList;
import java.util.List;

import Interfaces.ICompany;
import Models.Company;

public class CompanyService implements ICompany {
    private List<Company> companies = new ArrayList<>();

    @Override
    public void addCompany(Company company) {
        // Add new company in list
        companies.add(company);
    }

    @Override
    public Company getCompanyById(int id) {
        // gGet company by id from in memory companies list.
        return companies.stream().filter(company -> company.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Company> getAllCompanies() {
        // Get all company list.
        return new ArrayList<>(companies);
    }

    @Override
    public void updateCompany(int Id, Company UpdatedCompany) {
        Company company = getCompanyById(Id);
        if (company != null) {
            company.setCompanyTitle(UpdatedCompany.getCompanyTitle());
            company.setCompanyPhoneNumber(UpdatedCompany.getCompanyPhoneNumber());
            company.setCompanyOwner(UpdatedCompany.getCompanyOwner());
        }
    }

    @Override
    public void deleteCompany(int Id) {
        companies.removeIf(company -> company.getId() == Id);
    }

}
