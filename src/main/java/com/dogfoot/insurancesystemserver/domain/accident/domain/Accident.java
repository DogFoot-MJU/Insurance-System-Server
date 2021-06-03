package com.dogfoot.insurancesystemserver.domain.accident.domain;

import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.file.file.MyFile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<MyFile> files;

    @ManyToOne
    private Contract<?> contract;

    @OneToMany(mappedBy = "accident")
    private List<Compensation> compensationList;

    private AccidentState state;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    public Accident(Contract<?> contract) {
        this.files = new ArrayList<>();
        this.contract = contract;
        this.compensationList = new ArrayList<>();
        this.state = AccidentState.WAIT;
    }

    public void addFile(MyFile file) {
        this.files.add(file);
    }
}
