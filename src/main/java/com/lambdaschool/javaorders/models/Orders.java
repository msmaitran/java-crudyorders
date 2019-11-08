package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"hasordamount", "hasadvanceamount"})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @Transient
    public boolean hasordamount = false;

    @Transient
    public boolean hasadvanceamount = false;

    public Orders(){}

    public Orders(double ordamount, double advanceamount, Customers customers, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.customers = customers;
    }

    @ManyToOne
    @JoinColumn(name = "custcode",
                nullable = false)
    private Customers customers;

    @ManyToMany
    @JoinTable(name = "orderspayments",
                joinColumns = @JoinColumn(name = "ordnum"),
                inverseJoinColumns = @JoinColumn(name = "paymentid")
    )
    @JsonIgnoreProperties("orders")
    List<Payments> payments = new ArrayList<>();

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        hasordamount = true;
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        hasadvanceamount = true;
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void addPayments(Payments payments) {
        payments.getOrders().add(this);
    }

    public void removePayments(Payments payments) {
        payments.getOrders().remove(this);
    }
}
