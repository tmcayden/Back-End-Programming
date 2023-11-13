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
@Table(name = "countries")
@Data
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long id;

    @Column(name = "country")
    private String countryName;

    @Column(name = "create-date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions;
}
