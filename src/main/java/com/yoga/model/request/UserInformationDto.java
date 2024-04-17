package com.yoga.model.request;

import com.yoga.model.entity.Address;
import com.yoga.model.entity.UsersInformation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
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
    private Address Address;


    public UsersInformation usersInformationBuilder()
    {
        return UsersInformation.builder().surname(surname).firstname(firstname).lastname(lastname).email(email).phone(phone).Address(Address).build();
    }



}
