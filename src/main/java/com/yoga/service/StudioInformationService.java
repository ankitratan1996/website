package com.yoga.service;

import com.yoga.model.entity.Studio;
import com.yoga.model.request.StudioInformationDto;
import com.yoga.repository.StudioInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioInformationService {
    @Autowired
    StudioInformationRepo studioInformationRepo;
    public Studio SaveStudioInfo(StudioInformationDto studioInformationDto) {
        Studio studio=studioInformationDto.StudioBuilder();
        return studioInformationRepo.save(studio);
    }
}
