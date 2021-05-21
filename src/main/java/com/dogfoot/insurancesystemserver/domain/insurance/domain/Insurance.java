package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Entity
public abstract class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private Long payment;

    private int expirationDate;

    @OneToOne
    private CapacityPolicy capacityPolicy;

    private boolean isAvailableSale;

    public Insurance(String name, Long payment, int expirationDate) {
        this.name = name;
        this.payment = payment;
        this.expirationDate = expirationDate;
        this.isAvailableSale = false;
    }

    public void setCapacityPolicy(CapacityPolicy capacityPolicy) {
        this.capacityPolicy = capacityPolicy;
        this.isAvailableSale = true;
    }

    public boolean hasCapacityPolicy() {
        return this.capacityPolicy != null;
    }

    public void removeCapacityPolicy() {
        this.capacityPolicy = null;
        this.isAvailableSale = false;
    }
}
