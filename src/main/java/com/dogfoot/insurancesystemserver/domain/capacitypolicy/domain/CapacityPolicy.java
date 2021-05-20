package com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CapacityPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "capacityPolicy")
    private Insurance insurance;

    private String physical;

    private String economical;

    private String environmental;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public CapacityPolicy(String name, Insurance insurance, String physical, String economical, String environmental) {
        this.name = name;
        this.insurance = insurance;
        this.physical = physical;
        this.economical = economical;
        this.environmental = environmental;
    }
}
