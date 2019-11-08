package com.bitbyte.cargaraage.api.repositories;

import com.bitbyte.cargaraage.api.entities.OrderDetails;
import com.bitbyte.cargaraage.api.entities.OrderDetailsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, OrderDetailsId> {
}
