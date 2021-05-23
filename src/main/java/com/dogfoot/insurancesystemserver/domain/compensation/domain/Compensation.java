package com.dogfoot.insurancesystemserver.domain.compensation.domain;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
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
    private Contract contract;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

}
