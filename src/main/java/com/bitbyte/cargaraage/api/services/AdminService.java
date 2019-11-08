package com.bitbyte.cargaraage.api.services;

import com.bitbyte.cargaraage.api.entities.Role;
import com.bitbyte.cargaraage.api.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role){
        LOG.info("AdminService -> createRole -> start");
        Role createdRole = roleRepository.save(role);
        LOG.info("AdminService -> createRole -> end");
        return createdRole;
    }
}
