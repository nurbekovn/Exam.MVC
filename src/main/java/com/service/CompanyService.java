package com.service;
import com.model.Company;
import com.repository.CompanyRepository;
import com.repositoryImpl.CompanyRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CompanyService  {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepositoryImpl companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);
    }


    public void updateCompany(Company company) {
        companyRepository.updateCompany(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteCompany(id);
    }


    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }


    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }
}