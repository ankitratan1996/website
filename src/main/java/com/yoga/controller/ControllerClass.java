package com.yoga.controller;

import com.yoga.model.dto.UserInformationDto;
import com.yoga.model.entity.UsersInformation;
import com.yoga.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class ControllerClass {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping(value = "/signUp",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersInformation> User_SignUp(@RequestBody @Validated UserInformationDto userInformationDto)
    {

        log.info("user information{}",userInformationDto );
        return new ResponseEntity<>(userInformationService.saveUserInformation(userInformationDto), HttpStatus.CREATED);
    }





}
