package com.example.pos.service;

import com.example.pos.dto.request.companyRequest;
import com.example.pos.dto.response.companyResponse;
import com.example.pos.model.Company;

import java.util.List;

public interface  CompanyService {
    public companyResponse createCompany(companyRequest companyrequest);
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    companyResponse updateCompany(Long id,companyRequest companyrequest);
void DeleteCompany(Long id);

void saveSingleCompany(Company company);
}
