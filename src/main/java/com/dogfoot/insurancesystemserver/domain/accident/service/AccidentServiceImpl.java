package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.accident.dao.AccidentRepository;
import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import com.dogfoot.insurancesystemserver.domain.compensation.dto.CompensationApproveRequest;
import com.dogfoot.insurancesystemserver.domain.compensation.dao.CompensationRepository;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dao.ContractRepository;
import com.dogfoot.insurancesystemserver.global.file.service.FileService;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentResponse;
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
                .orElseThrow(() -> new IllegalArgumentException("해당 계약을 찾을 수 없습니다."));
        Accident accident = new Accident(contract);
        for (MultipartFile file : files) {
            accident.addFile(this.fileService.save(file));
        }
        this.accidentRepository.save(accident);
    }

    @Override
    public List<AccidentResponse> accidentListFindByUser(User user) {
        List<AccidentResponse> userAccidentList = new ArrayList<>();
        user.getContractList().forEach(contract -> userAccidentList.addAll(this.accidentRepository.findByContract(contract)
                .stream().map(AccidentResponse::from).collect(Collectors.toList())));
        return userAccidentList;
    }

    @Override
    public List<AccidentResponse> accidentFindByState(AccidentState state) {
        return this.accidentRepository.findAllByState(state).stream().map(AccidentResponse::from).collect(Collectors.toList());
    }

    @Override
    public Accident findById(Long id) {
        return this.accidentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사고 접수 내역을 찾울 수 없습니다."));
    }

    @Override
    public void compensationApprove(CompensationApproveRequest request) {
        Accident accident = findById(request.getAccidentId());
        Compensation compensation = this.compensationRepository.save(Compensation.of(request.getCompensationAmount(), accident));
        accident.compensationApprove(compensation);
    }

    @Override
    public void compensationReject(Long id) {
        findById(id).compensationReject();
    }
}
