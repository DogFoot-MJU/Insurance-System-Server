package com.dogfoot.insurancesystemserver.domain.consulting.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ConsultingAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @OneToOne(mappedBy = "consultingAnswer", fetch = FetchType.LAZY)
    private Consulting consulting;
}
