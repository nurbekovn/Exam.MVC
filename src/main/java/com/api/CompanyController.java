package com.api;
import com.model.Company;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
//@ComponentScan(basePackages = "com")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping()
    private String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies",companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    private String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    private String getCompanyById(@PathVariable("company") Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        System.out.println(companyService.getCompanyById(id));
        return "/innerPage";
    }

    @GetMapping("/{id}/updateCompany")
    private String updateCompany(@PathVariable("id")Long id, Model model) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "company/updateCompany";
    }

    @PatchMapping("/{id}")
    private String saveUpdateCompany(@PathVariable("id")Long id , @ModelAttribute("company")Company company) {
        companyService.updateCompany(company);
        return "redirect:/companies";
    }

    @DeleteMapping("/{id}")
    private String deleteCompany(@PathVariable("id")Long id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }
}
