package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Insurance insurance;

    private Long calculatedPayment;

    @OneToMany(mappedBy = "contract")
    private List<Accident> accidentList;

    @OneToMany(mappedBy = "contract")
    private List<Compensation> compensationList;

    private LocalDate expirationDate;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public Contract(User user, Insurance insurance, Long calculatedPayment, LocalDate expirationDate) {
        this.user = user;
        this.insurance = insurance;
        this.calculatedPayment = calculatedPayment;
        this.expirationDate = expirationDate;
        this.accidentList = new ArrayList<>();
        this.compensationList = new ArrayList<>();
    }
}
