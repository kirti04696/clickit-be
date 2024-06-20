package com.clickit.model;

import jakarta.persistence.*;

@Entity
public class OrderedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedItemId;
    private Integer productId;
    private Integer productVarietyId;
    private Integer quantity;

    public OrderedItem() {
    }

    public OrderedItem(Long orderedItemId, Integer productId, Integer productVarietyId, Integer quantity) {
        this.orderedItemId = orderedItemId;
        this.productId = productId;
        this.productVarietyId = productVarietyId;
        this.quantity = quantity;
    }

    public Long getOrderedItemId() {
        return orderedItemId;
    }

    public void setOrderedItemId(Long orderedItemId) {
        this.orderedItemId = orderedItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductVarietyId() {
        return productVarietyId;
    }

    public void setProductVarietyId(Integer productVarietyId) {
        this.productVarietyId = productVarietyId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderedItem{" +
                "orderedItemId=" + orderedItemId +
                ", productId=" + productId +
                ", productVarietyId=" + productVarietyId +
                ", quantity=" + quantity +
                '}';
    }
}

