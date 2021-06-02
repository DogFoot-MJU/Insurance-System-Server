package com.dogfoot.insurancesystemserver.domain.accident.domain;

import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.file.file.MyFile;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    public Accident(Contract<?> contract) {
        this.files = new ArrayList<>();
        this.contract = contract;
        this.compensationList = new ArrayList<>();
    }

    public void addFile(MyFile file) {
        this.files.add(file);
    }
}
