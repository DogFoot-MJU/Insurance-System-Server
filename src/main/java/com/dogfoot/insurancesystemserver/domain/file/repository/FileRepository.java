package com.dogfoot.insurancesystemserver.domain.file.repository;


import com.dogfoot.insurancesystemserver.domain.file.file.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<MyFile, Long> {
}
