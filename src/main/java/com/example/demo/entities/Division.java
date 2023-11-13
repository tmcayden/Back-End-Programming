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
@Table(name = "divisions")
@Data
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    Long id;

    @Column(name = "division")
    String division;

    @Column(name = "create_date")
    @CreationTimestamp
    Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private long countryId;
    public void setCountry(Country country){
        setCountryId(country.getId());
        this.country = country;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;
}
