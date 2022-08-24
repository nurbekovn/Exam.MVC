package com.serviceImp;
import com.model.Company;
import com.repository.CompanyRepository;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteCompany(id);
    }

    @Override
    public List<Company> getAllCompanies(Long id) {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }
}
