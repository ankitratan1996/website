package com.yoga.model.request;

import com.yoga.model.entity.Instructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstructorInformationDto {

    @NotBlank
    private String instructorName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String qualification;
    @NotBlank
    private String phone;

    public Instructor InstructorBuilder()
    {
        return Instructor.builder().instructorName(instructorName).email(email).qualification(qualification).phone(phone).build();
    }


}
