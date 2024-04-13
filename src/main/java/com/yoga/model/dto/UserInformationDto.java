package com.yoga.model.dto;

import com.yoga.model.entity.Address;
import com.yoga.model.entity.UsersInformation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class UserInformationDto {

    @NotNull
    private String surname;
    @NotBlank
    private String firstname;
    private String lastname;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @Valid
    private Address Address;


    public UsersInformation usersInformationBuilder()
    {
        return UsersInformation.builder().surname(surname).firstname(firstname).lastname(lastname).email(email).phone(phone).Address(Address).build();
    }



}
