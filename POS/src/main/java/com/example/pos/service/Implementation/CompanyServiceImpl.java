package com.example.pos.service.Implementation;

import com.example.pos.dto.request.companyRequest;
import com.example.pos.dto.response.companyResponse;
import com.example.pos.model.Company;
import com.example.pos.repository.CompanyRepository;
import com.example.pos.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public companyResponse createCompany(companyRequest companyrequest) {
        Company company = new Company();
        company.setCompanyEmail(companyrequest.getCompanyEmail());
        company.setCompanyName(companyrequest.getCompanyName());
        company.setCompanyLocation(companyrequest.getCompanyLocation());
        company.setCompanyLogo(companyrequest.getCompanyLogo());
        company.setCompanyPhoneNumber(companyrequest.getCompanyPhoneNumber());

      Company saveCompany=  companyRepository.save(company);
        return new companyResponse(saveCompany.getCompanyName());
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if (optional.isPresent()) {
            company = optional.get();
        } else {
            throw new RuntimeException("Company not found");
        }
    return company;
    }
    @Override
    public companyResponse updateCompany(Long id,companyRequest companyRequest) {
        Company myCompany=companyRepository.findById(id).get();
        myCompany.setCompanyEmail(companyRequest.getCompanyEmail());
        myCompany.setCompanyPhoneNumber(companyRequest.getCompanyPhoneNumber());
        myCompany.setCompanyLogo(companyRequest.getCompanyLogo());
        myCompany.setCompanyLocation(companyRequest.getCompanyLocation());
        myCompany.setCompanyName(companyRequest.getCompanyName());

        Company newCompany= companyRepository.save(myCompany);
        return new companyResponse(newCompany.getCompanyName());
    }

    @Override
    public void DeleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override

    public void saveSingleCompany(Company company) {
        companyRepository.save(company);
    }



}
