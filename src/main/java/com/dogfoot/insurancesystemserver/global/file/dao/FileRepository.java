package com.dogfoot.insurancesystemserver.global.file.dao;


import com.dogfoot.insurancesystemserver.global.file.file.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<MyFile, Long> {
}
