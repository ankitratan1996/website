package com.yoga.service;

import com.yoga.model.entity.YogaClasses;
import com.yoga.model.request.YogaClassInformationDto;
import com.yoga.repository.YogaClassInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YogaClassInformationService {

    @Autowired
    YogaClassInformationRepo yogaClassInformationRepo;

    public YogaClasses SaveYogaClassInfo(YogaClassInformationDto yogaClassInformationDto) {
        YogaClasses yogaClasses=yogaClassInformationDto.YogaClassBuilder();
        return yogaClassInformationRepo.save(yogaClasses);
    }
}
