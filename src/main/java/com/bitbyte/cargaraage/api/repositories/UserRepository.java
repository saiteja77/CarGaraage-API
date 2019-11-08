package com.bitbyte.cargaraage.api.repositories;

import com.bitbyte.cargaraage.api.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
