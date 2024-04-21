package com.yoga.model.request;

import com.yoga.model.entity.ClassStatus;
import com.yoga.model.entity.Instructor;
import com.yoga.model.entity.Studio;
import com.yoga.model.entity.YogaClasses;
import jakarta.validation.constraints.Email;
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
    /**--------------------*/
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

    public Instructor InstructorBuilder()
    {
        return Instructor.builder().instructorName(instructorName).email(email).qualification(qualification).phone(phone).yogaClasses(List.of(YogaClassesBuilder())).build();
    }


}
