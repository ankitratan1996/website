package com.yoga.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @ValidAddress
    private String buildingNo;
    @ValidAddress
    private String location;
    @ValidAddress
    private String pinCode;


}
