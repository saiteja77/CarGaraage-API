package com.bitbyte.cargaraage.api.controllers;

import com.bitbyte.cargaraage.api.entities.Role;
import com.bitbyte.cargaraage.api.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        LOG.info("AdminController -> createRole -> start");
        Role createdRole = adminService.createRole(role);
        LOG.info("AdminController -> createRole -> end");
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }
}
