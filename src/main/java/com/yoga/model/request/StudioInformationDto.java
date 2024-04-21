package com.yoga.model.request;

import com.yoga.model.entity.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudioInformationDto {

    @NotBlank
    private String studioName;

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



    public Studio StudioBuilder()
    {
        return Studio.builder().studioName(studioName).address(address).yogaClasses(List.of(YogaClassesBuilder())).build();
    }

}
