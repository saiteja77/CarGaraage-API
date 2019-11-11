package com.bitbyte.cargaraage.api.entities;


import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsId implements Serializable {

    private Long orderId;
    private Long userId;
    private String carId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(Long orderId, Long userId, String carId) {
        this.orderId = orderId;
        this.userId = userId;
        this.carId = carId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsId that = (OrderDetailsId) o;
        return orderId.equals(that.orderId) &&
                userId.equals(that.userId) &&
                carId.equals(that.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, carId);
    }
}
