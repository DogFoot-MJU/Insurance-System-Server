package com.dogfoot.insurancesystemserver.domain.compensation.domain;

import com.dogfoot.insurancesystemserver.domain.contract.domain.InsuranceContract;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long compensationAmount;

    @ManyToOne
    private InsuranceContract insuranceContract;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

}
