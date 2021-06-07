package com.dogfoot.insurancesystemserver.infra.file.repository;


import com.dogfoot.insurancesystemserver.infra.file.file.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<MyFile, Long> {
}
