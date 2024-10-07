package com.example.pos.service.Implementation;

import com.example.pos.dto.request.adminRequest;
import com.example.pos.dto.response.adminResponse;
import com.example.pos.model.Admin;
import com.example.pos.repository.AdminRepository;
import com.example.pos.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public adminResponse createAdmin(adminRequest adminrequest) {
        // Here you could add validation logic

        Admin admin = new Admin();
        admin.setEmail(adminrequest.getEmail());
        admin.setPassword(adminrequest.getPassword());
        admin.setFullName(adminrequest.getFullName());
        admin.setUserName(adminrequest.getUserName());
        admin.setPhoneNumber(adminrequest.getPhoneNumber());

        Admin savedAdmin = adminRepository.save(admin);
        return new adminResponse(savedAdmin.getFullName());
    }


    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
//        return adminRepository.findById(id);
    }

    @Override
    public adminResponse updateAdmin(Long id, adminRequest adminRequest) {
        Admin add=adminRepository.findById(id).get();
        add.setFullName(adminRequest.getFullName());
        add.setUserName(adminRequest.getUserName());
        add.setPassword(adminRequest.getPassword());
        add.setPhoneNumber(adminRequest.getPhoneNumber());
        add.setEmail(adminRequest.getEmail());

        Admin newAdmin=adminRepository.save(add);
        return new adminResponse(newAdmin.getFullName());
    }

    @Override
    public adminResponse deleteAdmin(Long id) {
        Admin admin=adminRepository.findById(id).get();
        return new adminResponse(admin.getFullName());
    }


}
