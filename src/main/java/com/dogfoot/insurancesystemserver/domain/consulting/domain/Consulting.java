package com.dogfoot.insurancesystemserver.domain.consulting.domain;

import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Consulting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String title;

    private String contents;

    @ManyToOne
    private User user;

    @Builder
    public Consulting(String title, String contents, User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
    }
}
