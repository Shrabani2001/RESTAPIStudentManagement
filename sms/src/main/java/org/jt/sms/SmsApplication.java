package org.jt.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.jt.sms.domain.ContactInfo;
import org.jt.sms.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ContactInfo.class)
/*@OpenAPIDefinition(
        info = @Info(title = "Student Management System",
                description = "A web application for managing for student records", version = "v1")
)*/
public class SmsApplication {
   /* @Autowired
    private ObjectMapper objectMapper;*/

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            var student = new Student();
            student.setStudentRoll(101);
            student.setStudentName("Biswajit");

            var json = objectMapper.writeValueAsString(student);
            System.out.println(json);

            String obj = """
                    {
                        "studentRoll":102,
                        "studentName":"Shrabani"
                    }
                    """;

            Student student1 =  objectMapper.readValue(obj, Student.class);
            System.out.println(student1);
        };
    }*/
}