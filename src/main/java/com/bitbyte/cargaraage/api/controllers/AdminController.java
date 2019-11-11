package com.bitbyte.cargaraage.api.controllers;

import com.bitbyte.cargaraage.api.entities.Role;
import com.bitbyte.cargaraage.api.services.AdminService;
import com.bitbyte.cargaraage.api.services.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController("/admin")
@CrossOrigin
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestHeader String token, @RequestBody Role role){
        if(authorizationService.isAuthorized(token, "ADMIN")){
            LOG.info("AdminController -> createRole -> start");
            Role createdRole = adminService.createRole(role);
            LOG.info("AdminController -> createRole -> end");
            return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
