package com.yoga.controller;

import com.yoga.exception.ExceptionStatusCode;
import com.yoga.exception.InvalidInputException;
import com.yoga.model.dto.UserInformationDto;
import com.yoga.model.entity.UsersInformation;
import com.yoga.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class ControllerClass {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping(value = "/signUp",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersInformation> User_SignUp(@RequestBody @Validated UserInformationDto userInformationDto)
    {
        UsersInformation user=userInformationService.findUserInformationByEmailFirstTime(userInformationDto.getEmail());

        if(!Objects.isNull(user))
        {
            throw new InvalidInputException(ExceptionStatusCode.EMAIL_EXIST);
        }

        return new ResponseEntity<>(userInformationService.saveUserInformation(userInformationDto), HttpStatus.CREATED);
    }

    @GetMapping("/identifier-userId")
    public ResponseEntity<Optional<UsersInformation>> User_ById(@RequestParam(value = "userId")UUID userId)
    {
        return new ResponseEntity<>(userInformationService.findUserInformationByID(userId),HttpStatus.OK);
    }

    @GetMapping("/identifier-email")
    public  ResponseEntity<UsersInformation> User_ByEmail(@RequestParam(value = "email")String email)
    {
        return new ResponseEntity<>(userInformationService.findUserInformationByEmail(email),HttpStatus.OK);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> Delete_UserById(@RequestParam(value = "userId")UUID userId)
    {
        boolean deleted = userInformationService.deleteUserByID(userId);
        if (deleted) {
            return ResponseEntity.ok("Product with ID " + userId + " has been deleted from inventory.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product with ID " + userId + " was not found in the inventory.");
        }
    }
}
