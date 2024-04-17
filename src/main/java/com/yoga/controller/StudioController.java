package com.yoga.controller;

import com.yoga.model.entity.Studio;
import com.yoga.model.request.StudioInformationDto;
import com.yoga.service.StudioInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioInformationService studioInformationService;
    @PostMapping(value = "/add-studio",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Studio> CreateStudio(@Valid @RequestBody StudioInformationDto studioInformationDto)
    {
        return new ResponseEntity<>(studioInformationService.SaveStudioInfo(studioInformationDto), HttpStatus.CREATED);
    }
}
