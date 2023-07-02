package org.sakila.Enitites;

// Generated 20/10/2012 11:23:03 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Rental generated by hbm2java
 */
@Entity
@Table(name = "rental", catalog = "sakila", uniqueConstraints = @UniqueConstraint(columnNames = {
        "rental_date", "inventory_id", "customer_id"}))
public class Rental implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer rentalId;
    private Staff staff;
    private Customer customer;
    private Inventory inventory;
    private Date rentalDate;
    private Date returnDate;
    private Date lastUpdate;
    private List<Payment> payments;

    public Rental() {
    }

    public Rental(Staff staff, Customer customer, Inventory inventory,
                  Date rentalDate, Date lastUpdate) {
        this.staff = staff;
        this.customer = customer;
        this.inventory = inventory;
        this.rentalDate = rentalDate;
        this.lastUpdate = lastUpdate;
    }

    public Rental(Staff staff, Customer customer, Inventory inventory,
                  Date rentalDate, Date returnDate, Date lastUpdate,
                  List<Payment> payments) {
        this.staff = staff;
        this.customer = customer;
        this.inventory = inventory;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
        this.payments = payments;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rental_id", unique = true, nullable = false)
    public Integer getRentalId() {
        return this.rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rental_date", nullable = false, length = 19)
    public Date getRentalDate() {
        return this.rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date", length = 19)
    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false, length = 19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rental")
    public List<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}