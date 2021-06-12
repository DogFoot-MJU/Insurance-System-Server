package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.dao.AccidentRepository;
import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentResponse;
import com.dogfoot.insurancesystemserver.domain.accident.exception.AccidentExceptionMessages;
import com.dogfoot.insurancesystemserver.domain.accident.exception.AccidentNotFoundException;
import com.dogfoot.insurancesystemserver.domain.compensation.dao.CompensationRepository;
import com.dogfoot.insurancesystemserver.domain.contract.dao.ContractRepository;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.exception.ContractExceptionMessages;
import com.dogfoot.insurancesystemserver.domain.contract.exception.ContractNotFoundException;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.global.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final ContractRepository<?> contractRepository;
    private final CompensationRepository compensationRepository;
    private final FileService fileService;

    @Override
    public void save(List<MultipartFile> files, Long id) throws IOException {
        Contract<?> contract = this.contractRepository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException(ContractExceptionMessages.CONTRACT_NOT_FOUND_EXCEPTION));
        Accident accident = new Accident(contract);
        for (MultipartFile file : files) {
            accident.addFile(this.fileService.save(file));
        }
        this.accidentRepository.save(accident);
    }

    @Override
    public List<AccidentResponse> accidentListFindByUser(User user) {
        List<AccidentResponse> userAccidentList = new ArrayList<>();
        user.getContractList().forEach(contract -> userAccidentList.addAll(this.accidentRepository.findAllByContract(contract)
                .stream().map(AccidentResponse::from).collect(Collectors.toList())));
        return userAccidentList;
    }

    @Override
    public List<AccidentResponse> accidentFindByState(AccidentState state) {
        return this.accidentRepository.findAllByState(state).stream().map(AccidentResponse::from).collect(Collectors.toList());
    }

    @Override
    public Accident findById(Long id) {
        return this.accidentRepository.findById(id).orElseThrow(() -> new AccidentNotFoundException(AccidentExceptionMessages.ACCIDENT_NOT_FOUND_EXCEPTION_MESSAGE));
    }

}
