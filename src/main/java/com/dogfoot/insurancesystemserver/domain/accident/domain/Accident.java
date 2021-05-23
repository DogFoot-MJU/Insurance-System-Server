package com.dogfoot.insurancesystemserver.domain.accident.domain;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate accidentDate;

    @ManyToOne
    private Contract contract;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

}
