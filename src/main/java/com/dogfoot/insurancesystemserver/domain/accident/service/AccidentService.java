package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccidentService {

    void save(List<MultipartFile> files, Long id) throws IOException;

    List<AccidentResponse> accidentListFindByUser(User user);

    List<AccidentResponse> accidentFindByState(AccidentState state);

    AccidentDetailResponse findById(Long id);

}
