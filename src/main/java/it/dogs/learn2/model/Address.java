package it.dogs.learn2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String postalCode;

    @Column(nullable = true)
    private String city;
    private String province;
}
