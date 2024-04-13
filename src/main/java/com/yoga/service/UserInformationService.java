package com.yoga.service;

import com.yoga.model.dto.UserInformationDto;
import com.yoga.model.entity.UsersInformation;
import com.yoga.repository.UserInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;

    public UsersInformation saveUserInformation(UserInformationDto userInformationDto)
    {
       UsersInformation usersInformation= userInformationDto.usersInformationBuilder();
       return userInformationRepository.save(usersInformation);
    }


}
