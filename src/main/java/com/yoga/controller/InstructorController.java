package com.yoga.controller;

import com.yoga.exception.ExceptionStatusCode;
import com.yoga.exception.InvalidInputException;
import com.yoga.model.entity.Instructor;
import com.yoga.model.request.InstructorInformationDto;
import com.yoga.model.request.UpdateInstructorInformationDto;
import com.yoga.service.InstructorInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/instructor")
public class InstructorController {
    @Autowired
    InstructorInformationService instructorInformationService;
    @PostMapping(value = "/profile-creation",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Instructor> CreateInstructorProfile(@Valid @RequestBody InstructorInformationDto instructorInformationDto)
    {
        Instructor instructor=instructorInformationService.findInstructorInformationByEmailFirstTime(instructorInformationDto.getEmail());
        if(!Objects.isNull(instructor))
        {
            throw new InvalidInputException(ExceptionStatusCode.EMAIL_EXIST);
        }
        return new ResponseEntity<>(instructorInformationService.SaveInstructorDetails(instructorInformationDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/identifier-InstructorId",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Instructor>> Instructor_ById(@RequestParam(value = "instructorId") UUID instructorId)
    {
        return new ResponseEntity<>(instructorInformationService.findInstructorInformationByID(instructorId),HttpStatus.OK);
    }

    @GetMapping(value = "/identifier-InstructorEmail",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Instructor> Instructor_ByEmail(@Valid @RequestParam(value = "email")String email)
    {
        return new ResponseEntity<>(instructorInformationService.findInstructorInformationByEmail(email),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-instructor",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Delete_InstructorById(@RequestParam(value = "instructorId")UUID instructorId)
    {
        boolean deleted = instructorInformationService.deleteInstructorByID(instructorId);
        if (deleted) {
            return ResponseEntity.ok("Instructor with ID " + instructorId + " has been deleted from inventory.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Instructor with ID " + instructorId + " was not found in the inventory.");
        }
    }

    @PutMapping(value = "/update-instructor/{instructorId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Instructor>Update_InstructorById(@PathVariable UUID instructorId, @Valid @RequestBody UpdateInstructorInformationDto updateinstructorInformationDto)
    {
        return new ResponseEntity<>(instructorInformationService.updateInstructorInformation(instructorId,updateinstructorInformationDto),HttpStatus.OK);
    }

}
