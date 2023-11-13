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

@Entity
@Table(name = "vacations")
@Data
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "travel_fare_price")
    private BigDecimal travelFarePrice;

    @Column(name = "vacation_title")
    private String vacationTitle;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "vacation")
    private Set<Excursion> excursions;
}
