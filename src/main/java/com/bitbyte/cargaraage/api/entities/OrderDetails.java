package com.bitbyte.cargaraage.api.entities;

import javax.persistence.*;

@Entity
@IdClass(OrderDetailsId.class)
public class OrderDetails {

    @Id
    private Long orderId;
    @Id
    private Long userId;
    @Id
    private Long carId;
    private Long price;
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name="orderId", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
