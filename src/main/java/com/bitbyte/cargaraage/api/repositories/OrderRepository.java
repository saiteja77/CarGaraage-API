package com.bitbyte.cargaraage.api.repositories;

import com.bitbyte.cargaraage.api.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
