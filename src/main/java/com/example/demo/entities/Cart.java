package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Table(name = "carts")
@Entity
@Data
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "package_price")
    private BigDecimal packagePrice;

    @Column(name = "party_size")
    private int partySize;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cart")
    private Set<CartItem>cartItems;
}
