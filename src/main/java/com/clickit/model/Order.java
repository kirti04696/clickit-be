package com.clickit.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clickit_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer orderId;
    private Integer amount;
    private String paymentMode;
    private Date orderDate;
    private String paymentStatus;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedItem> orderedItem;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;


    public Order() {
    }

    public Order(Integer orderId, Integer amount, String paymentMode, Date orderDate, String paymentStatus, String address, User user, List<OrderedItem> orderedItems) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.orderDate = orderDate;
        this.paymentStatus = paymentStatus;
        this.address = address;
        this.user = user;
        this.orderedItem = orderedItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getAddress() {
        return address;
    }

    public List<OrderedItem> getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(List<OrderedItem> orderedItem) {
        this.orderedItem = orderedItem;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", paymentMode='" + paymentMode + '\'' +
                ", orderDate=" + orderDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
