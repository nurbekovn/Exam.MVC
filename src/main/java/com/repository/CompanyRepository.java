package com.repository;
import com.model.Company;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface CompanyRepository {
    void saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Long id);
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);

}
