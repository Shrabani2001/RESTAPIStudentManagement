package org.jt.sms.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"studentPhoneNumber","studentName"}) //Bring phoneNumber to top then studentName
public class Student {
    @Positive
    @Min(value = 100)
    @JsonAlias("roll") //it used instead of studentRoll for bind the data in json format
    private int studentRoll;
    @NotNull
    @NotEmpty // it checks the length (length is zero or not)
    @NotBlank // it checks the first character
    private String studentName;
    @Digits(integer = 5, fraction = 2)
    @PositiveOrZero
    @JsonIgnore //ignore this field
    private double studentFee;
    @Email(message = "Student email should be in proper format")
    private String studentEmail;
    @NotNull
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Mobile number should be in proper format")
    private String studentPhoneNumber;
    private List<String> hobbies;
    private Address address;
}
