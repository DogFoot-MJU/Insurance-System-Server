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

    @Column(length = 60, nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private ConsultingStateType state;

    @OneToOne(fetch = FetchType.LAZY)
    private ConsultingAnswer consultingAnswer;

    @Builder
    public Consulting(String title, String contents, User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
        this.state = ConsultingStateType.WAIT;
    }

    public void answer(ConsultingAnswer consultingAnswer) {
        this.state = ConsultingStateType.COMPLETE;
        this.consultingAnswer = consultingAnswer;
    }

}
