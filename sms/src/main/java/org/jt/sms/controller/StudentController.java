package org.jt.sms.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.jt.sms.domain.ContactInfo;
import org.jt.sms.domain.Student;
import org.jt.sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Student API", description = "This controller class manages the CRUD operations for student entities")
//@Validated   //this is used for validation in old way
public class StudentController {
    private final StudentService service;
    private final ContactInfo contactInfo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new student")
    public Student saveStudent(@Valid @RequestBody Student student) {

        return service.addStudent(student);
    }

    @PutMapping("/{roll}")
    public Student updateStudent(@Min(value = 100) @PathVariable int roll, @Valid @RequestBody Student student) {
        return service.updateStudent(roll, student);
    }

    @DeleteMapping("/{roll}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiResponse(description = "Student not found",
            responseCode = "400",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    public Student removeStudent(@Min(value = 100) @PathVariable int roll) {
        return service.deleteStudent(roll);
    }

    @GetMapping
    public List<Student> students() {

        return service.getStudents();
    }

    @GetMapping("/{roll}")
    public Student student(@Min(value = 100) @PathVariable int roll) {
        return service.getStudent(roll);
    }

    @GetMapping("/contacts")
    public ContactInfo contactInfo() {
        System.out.println("Contact controller");
        return contactInfo;
    }
}