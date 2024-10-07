package com.example.pos.service;

import com.example.pos.dto.request.adminRequest;
import com.example.pos.dto.response.adminResponse;
import com.example.pos.model.Admin;

import java.util.List;

public interface AdminService {
    public  adminResponse  createAdmin(adminRequest adminRequest);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
adminResponse  updateAdmin(Long id, adminRequest adminRequest);
adminResponse  deleteAdmin(Long id);

}

