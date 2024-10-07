package com.example.pos.controller;

import com.example.pos.dto.request.companyRequest;
import com.example.pos.dto.response.companyResponse;
import com.example.pos.model.Company;
import com.example.pos.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class CompanyController {
    private final CompanyService companyService;

    // POST request to create a new company
    @PostMapping(path="/create")
    public companyResponse createCompany(@RequestBody @Validated companyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return new companyResponse(companyRequest.getCompanyName());
    }

    // GET request to retrieve all companies
    @GetMapping(path = "/allcompanies")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("companies", companies);
        return "company.html";  // Thymeleaf template displaying all companies
    }

    // GET request to retrieve a company by ID and show the update form
    @GetMapping("/formupdate/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "updateform"; // Name of the Thymeleaf template for updating the company
    }

    // POST request to update a company by ID (from form submission)
    @PostMapping(path="/company/{id}")
    public String updateCompany(@PathVariable Long id, @ModelAttribute companyRequest companyRequest) {
        companyService.updateCompany(id, companyRequest);
        return "redirect:/register/allcompanies";  // Redirect to list of companies after update
    }

    // POST request to save a single company (via form submission)
    @GetMapping(path="/store")
    public String saveSingleCompany(@ModelAttribute Company company) {
        companyService.saveSingleCompany(company);
        return "store.html";
    }

    // DELETE request to delete a company by ID
    @DeleteMapping(path="/{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.DeleteCompany(id);
    }
}
