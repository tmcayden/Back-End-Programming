package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id", nullable = false, insertable = false, updatable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;
}
