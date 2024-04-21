package com.yoga.model.request;

import com.yoga.model.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInformationDto {

    @NotNull
    private String surname;
    @NotBlank
    private String firstname;
    private String lastname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @Valid
    private Address address;

    /*--------------------*/
    private String className;
    private String description;
    private Instructor instructor;
    private Studio studio;
    private Integer capacity;
    private LocalDateTime startTime;

    private String level;
    private String category;
    private BigDecimal price;
    private ClassStatus status;

    public YogaClasses YogaClassesBuilder() {
        return YogaClasses.builder().className(className).description(description).associatedInstructor(instructor).associatedStudio(studio).
        capacity(capacity).startTime(startTime).level(level).category(category).price(price).status(status).build();
    }

    public UsersInformation usersInformationBuilder()
    {
        return UsersInformation.builder().surname(surname).firstname(firstname).
                lastname(lastname).email(email).phone(phone).Address(address).associatedYogaClasses(YogaClassesBuilder()).build();
    }



}
