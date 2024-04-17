package com.yoga.service;

import com.yoga.exception.ExceptionStatusCode;
import com.yoga.exception.InvalidInputException;
import com.yoga.model.request.UpdateUserInformationDto;
import com.yoga.model.request.UserInformationDto;
import com.yoga.model.entity.Address;
import com.yoga.model.entity.UsersInformation;
import com.yoga.repository.UserInformationRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@ToString
public class UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;
    public UsersInformation saveUserInformation(UserInformationDto userInformationDto)
    {
       UsersInformation usersInformation= userInformationDto.usersInformationBuilder();
       return saveOrUpdate(usersInformation);
    }

    private UsersInformation saveOrUpdate(UsersInformation usersInformation) {
        return userInformationRepository.save(usersInformation);
    }

    public Optional<UsersInformation> findUserInformationByID(UUID uuid)
    {
        if(Objects.isNull(uuid))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        Optional<UsersInformation>receiveDataById = userInformationRepository.findById(uuid);
        if(receiveDataById.isEmpty())
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_USER);
        }
        return receiveDataById;
    }

    public UsersInformation findUserInformationByEmail(String email)
    {
        if(Objects.isNull(email))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        UsersInformation receivedDataByEmail= userInformationRepository.findByEmail(email);
        if(Objects.isNull(receivedDataByEmail))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_EMAIL);
        }
        return receivedDataByEmail;
    }
    public UsersInformation findUserInformationByEmailFirstTime(String email)
    {
        if(Objects.isNull(email))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        return userInformationRepository.findByEmail(email);
    }
    public boolean deleteUserByID(UUID userId) {
        if(Objects.isNull(userId))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
         UsersInformation usersInformation= userInformationRepository.findById(userId).orElseThrow(()->new InvalidInputException(ExceptionStatusCode.INVALID_INPUT));
         userInformationRepository.delete(usersInformation);
         return true;
    }

    public UsersInformation updateUserInformation(UUID userId, UpdateUserInformationDto updateUserInformationDto) {

        Optional<UsersInformation> usersInformation=findUserInformationByID(userId);
        UsersInformation existingUser=usersInformation.get();

        if (updateUserInformationDto.getAddress() != null) {
            Address address = new Address();
            address.setBuildingNo(updateUserInformationDto.getAddress().getBuildingNo());
            address.setLocation(updateUserInformationDto.getAddress().getLocation());
            address.setPinCode(updateUserInformationDto.getAddress().getPinCode());
            existingUser.setAddress(address);
        } else {
            existingUser.setAddress(null);
        }
        existingUser.setSurname(updateUserInformationDto.getSurname());
        existingUser.setPhone(updateUserInformationDto.getPhone());
        existingUser.setEmail(updateUserInformationDto.getEmail());
        existingUser.setFirstname(updateUserInformationDto.getFirstname());
        existingUser.setLastname(updateUserInformationDto.getLastname());
        log.info("existingUser data:{}",existingUser);
        return saveOrUpdate(existingUser);

    }

}
