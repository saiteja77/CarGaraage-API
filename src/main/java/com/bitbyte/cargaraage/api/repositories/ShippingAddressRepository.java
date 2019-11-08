package com.bitbyte.cargaraage.api.repositories;

import com.bitbyte.cargaraage.api.entities.ShippingAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
}
