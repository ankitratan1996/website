package com.yoga.model.request;

import com.yoga.model.entity.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class UpdateUserInformationDto {

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
}
