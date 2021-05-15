package com.dogfoot.insurancesystemserver.domain.user.domain;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(unique = true, nullable = false)
    private String email;

    @Getter
    private String name;

    @Getter
    @Column(nullable = false)
    private String password;

    @Getter
    private String phoneNumber;

    @Getter
    private String address;

    @Getter
    private String residentRegistrationNumber;

    @Getter
    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    @Getter
    @Enumerated(EnumType.STRING)
    private UserStateType state;

    @Getter
    @OneToMany(mappedBy = "user")
    private List<Contract> contracts;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public User(String email, String name, String password, String phoneNumber, String address,
                String residentRegistrationNumber, UserRoleType role, UserStateType state) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.role = role;
        this.state = state;
        contracts = new ArrayList<>();
    }

    public void emailVerificationCompleted() {
        this.state = UserStateType.NORMAL;
    }

}
