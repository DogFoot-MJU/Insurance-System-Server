package com.dogfoot.insurancesystemserver.domain.accident.service;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.accident.dto.AccidentResponse;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccidentService {

    void save(List<MultipartFile> files, Long id) throws IOException;

    List<AccidentResponse> accidentListFindByUser(User user);

    List<AccidentResponse> accidentFindByState(AccidentState state);

    Accident findById(Long id);

}
