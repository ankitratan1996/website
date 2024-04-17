package com.yoga.model.request;

import com.yoga.model.entity.Address;
import com.yoga.model.entity.Studio;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudioInformationDto {

    @NotBlank
    private String studioName;

    private Address address;

    public Studio StudioBuilder()
    {
        return Studio.builder().studioName(studioName).address(address).build();
    }

}
