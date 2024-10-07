package com.example.pos.controller;


import com.example.pos.dto.request.adminRequest;
import com.example.pos.dto.response.adminResponse;
import com.example.pos.model.Admin;
import com.example.pos.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registeradmin")

public class AdminController {

    private final AdminService adminService;

    @PostMapping(name="/save")
    public adminResponse createAdmin(@RequestBody  @Validated adminRequest adminrequest) {
         adminService.createAdmin(adminrequest);
        return  new adminResponse(adminrequest.getFullName());
    }
    //    @GetMapping(value = "/all", produces = "application/json")
    @GetMapping(path = "/alladmins")
    public String getAllAdmins(Model model) {
      List<Admin> admin=adminService.getAllAdmins();
      model.addAttribute("admin",admin);
      return "admin";
    }



    @GetMapping(path="/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }
    @PutMapping(path = "/{id}")
    public adminResponse updateAdmin(@PathVariable Long id, @RequestBody @Validated
    adminRequest adminrequest) {
        adminService.updateAdmin(id, adminrequest);
        return  new adminResponse(adminrequest.getFullName());
    }
    @DeleteMapping(path = "/{id}")
    public adminResponse deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return new adminResponse();
    }
}




