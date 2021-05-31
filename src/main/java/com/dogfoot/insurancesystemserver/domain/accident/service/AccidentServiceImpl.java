package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.repository.AccidentRepository;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.repository.ContractRepository;
import com.dogfoot.insurancesystemserver.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final ContractRepository<?> contractRepository;
    private final FileService fileService;

    @Override
    public void save(List<MultipartFile> files, Long id) throws IOException {
        Contract<?> contract = this.contractRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 계약을 찾을 수 없습니다."));
        Accident accident = new Accident(contract);
        for (MultipartFile file : files) {
            accident.addFile(this.fileService.save(file));
        }
        this.accidentRepository.save(accident);
    }
}
