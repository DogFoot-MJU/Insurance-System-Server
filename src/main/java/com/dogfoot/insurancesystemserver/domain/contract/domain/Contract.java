package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Entity
public abstract class Contract<Res> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dtype", insertable = false, updatable = false)
    private String dtype;

    @ManyToOne
    private User user;

    @OneToOne
    private Insurance insurance;

    private String customerPhysical;

    private String customerEconomical;

    private String customerEnvironmental;

    private Long calculatedPayment;

    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private UwDueProcessType uwDueProcessType;

    @OneToMany(mappedBy = "contract")
    private List<Accident> accidentList;

    @OneToMany(mappedBy = "contract")
    private List<Compensation> compensationList;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    public Contract(User user, Insurance insurance, String customerPhysical, String customerEconomical,
                    String customerEnvironmental, Long calculatedPayment, LocalDate expirationDate) {
        this.user = user;
        this.insurance = insurance;
        this.customerPhysical = customerPhysical;
        this.customerEconomical = customerEconomical;
        this.customerEnvironmental = customerEnvironmental;
        this.calculatedPayment = calculatedPayment;
        this.expirationDate = LocalDate.now().plusDays(insurance.getExpirationDate());
        this.uwDueProcessType = UwDueProcessType.WAIT;
        this.accidentList = new ArrayList<>();
        this.compensationList = new ArrayList<>();
    }

    public Contract<Res> uwDueProcessApprove() {
        this.uwDueProcessType = UwDueProcessType.APPROVE;
        return this;
    }

    public Contract<Res> uwDueProcessReject() {
        this.uwDueProcessType = UwDueProcessType.REJECT;
        return this;
    }

    public abstract Res toResponse();

}
