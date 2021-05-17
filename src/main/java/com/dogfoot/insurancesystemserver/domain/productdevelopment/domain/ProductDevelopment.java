package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Entity
public abstract class ProductDevelopment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long payment;

    private DevelopmentState state;

    public ProductDevelopment(String name, Long payment) {
        this.name = name;
        this.payment = payment;
    }

}
