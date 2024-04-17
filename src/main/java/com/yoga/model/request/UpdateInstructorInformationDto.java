package com.yoga.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateInstructorInformationDto {

    @NotBlank
    private String instructorName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String qualification;
    @NotBlank
    private String phone;
}
