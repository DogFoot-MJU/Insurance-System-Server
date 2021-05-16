package com.dogfoot.insurancesystemserver.domain.consulting.domain;

import javax.persistence.*;

@Entity
public class Consulting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String title;

    private String contents;

}
