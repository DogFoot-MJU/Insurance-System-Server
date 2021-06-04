package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.compensation.dto.CompensationApproveRequest;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccidentService {

    void save(List<MultipartFile> files, Long id) throws IOException;

    List<AccidentResponse> accidentListFindByUser(User user);

    List<AccidentResponse> accidentFindByState(AccidentState state);

    Accident findById(Long id);

    @Transactional
    void compensationApprove(CompensationApproveRequest request);

    @Transactional
    void compensationReject(Long id);

}
