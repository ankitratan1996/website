package com.yoga.service;

import com.yoga.exception.ExceptionStatusCode;
import com.yoga.exception.InvalidInputException;
import com.yoga.model.entity.Instructor;
import com.yoga.model.entity.UsersInformation;
import com.yoga.model.request.InstructorInformationDto;
import com.yoga.model.request.UpdateInstructorInformationDto;
import com.yoga.repository.InstructorInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstructorInformationService {
    @Autowired
    InstructorInformationRepo instructorInformationRepo;
    public Instructor SaveInstructorDetails(InstructorInformationDto instructorInformationDto) {
        Instructor instructor= instructorInformationDto.InstructorBuilder();
        return SaveOrUpdate(instructor);
    }
    private Instructor SaveOrUpdate(Instructor instructor)
    {
        return instructorInformationRepo.save( instructor);
    }


    public Optional<Instructor> findInstructorInformationByID(UUID instructorId) {
        if(Objects.isNull(instructorId))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        Optional<Instructor>receiveDataById = instructorInformationRepo.findById(instructorId);
        if(receiveDataById.isEmpty())
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_USER);
        }
        return receiveDataById;
    }

    public Instructor findInstructorInformationByEmail(String email) {
        if(Objects.isNull(email))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        Instructor receivedDataByEmail= instructorInformationRepo.findByEmail(email);
        if(Objects.isNull(receivedDataByEmail))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_EMAIL);
        }
        return receivedDataByEmail;
    }

    public boolean deleteInstructorByID(UUID instructorId) {
      Optional<Instructor> instructor= instructorInformationRepo.findById(instructorId);
      if(!instructor.isEmpty()) {
              instructorInformationRepo.delete(instructor.get());
          return true;
      }
      return false;
    }


    public Instructor updateInstructorInformation(UUID instructorId, UpdateInstructorInformationDto updateinstructorInformationDto) {
        Optional<Instructor> instructor= instructorInformationRepo.findById(instructorId);
        Instructor existingInstructorInfo=instructor.get();
        existingInstructorInfo.setInstructorName(updateinstructorInformationDto.getInstructorName());
        existingInstructorInfo.setEmail(updateinstructorInformationDto.getEmail());
        existingInstructorInfo.setPhone(updateinstructorInformationDto.getPhone());
        existingInstructorInfo.setQualification(updateinstructorInformationDto.getQualification());
        return instructorInformationRepo.saveAndFlush(existingInstructorInfo);
    }

    public Instructor findInstructorInformationByEmailFirstTime(String email) {
        if(Objects.isNull(email))
        {
            throw new InvalidInputException(ExceptionStatusCode.INVALID_INPUT);
        }
        return instructorInformationRepo.findByEmail(email);
    }
}
