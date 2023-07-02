package org.sakila.Enitites;

// Generated 20/10/2012 11:23:03 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "sakila")
public class Customer implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Short customerId;
    private Address address;
    private Store store;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Date createDate;
    private Date lastUpdate;
    private List<Rental> rentals;
    private List<Payment> payments;

    public Customer() {
    }

    public Customer(Address address, Store store, String firstName,
                    String lastName, boolean active, Date createDate, Date lastUpdate) {
        this.address = address;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }

    public Customer(Address address, Store store, String firstName,
                    String lastName, String email, boolean active, Date createDate,
                    Date lastUpdate, List<Rental> rentals, List<Payment> payments) {
        this.address = address;
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.rentals = rentals;
        this.payments = payments;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
    public Short getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false, length = 19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public List<Rental> getRentals() {
        return this.rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public List<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}
