package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    @OneToOne
    private CapacityPolicy capacityPolicy;

    public Insurance(String name, Long payment) {
        this.name = name;
        this.payment = payment;
    }

    public boolean hasCapacityPolicy() {
        return this.capacityPolicy != null;
    }

    public void removeCapacityPolicy() {
        this.capacityPolicy = null;
    }
}
