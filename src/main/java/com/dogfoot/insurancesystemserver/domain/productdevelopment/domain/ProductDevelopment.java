package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Entity
public abstract class ProductDevelopment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long payment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DevelopmentState state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApproveState approveState;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    public ProductDevelopment(String name, Long payment) {
        this.name = name;
        this.payment = payment;
    }

    protected void changeState(DevelopmentState state) {
        this.state = state;
    }

    protected void changeApproveSate(ApproveState approveState) {
        this.approveState = approveState;
    }
}
