package Interfaces;

import java.util.List;

import Models.Company;

public interface ICompany {
    void addCompany(Company company);

    Company getCompanyById(int Id);

    List<Company> getAllCompanies();

    void updateCompany(int Id, Company UpdatedCompany);

    void deleteCompany(int Id);

}