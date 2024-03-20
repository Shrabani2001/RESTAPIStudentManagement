package org.jt.sms.service;

import org.jt.sms.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public Student updateStudent(int roll,Student student){
        var existingstudent = getStudent(roll);
        existingstudent.setStudentName(student.getStudentName());
        existingstudent.setStudentFee(student.getStudentFee());
        existingstudent.setStudentEmail(student.getStudentEmail());
        existingstudent.setStudentPhoneNumber(student.getStudentPhoneNumber());
        existingstudent.setHobbies(student.getHobbies());
        existingstudent.setAddress(student.getAddress());

        var index = getIndex(roll);
        students.set(index,existingstudent);
        return existingstudent;
    }

    public Student deleteStudent(int roll){
        var student = getStudent(roll);
        students.remove(student);
        return student;
    }
    public List<Student> getStudents() {

        return students;
    }

    public Student getStudent(int roll) {
        for (var student : students) {
            if (student.getStudentRoll() == roll) {
                return student;
            }

        }
        throw new RuntimeException("Student not found");
    }

    private int getIndex(int roll){
        for (int i = 0; i < students.size(); i++) {
            var student = students.get(i);
            if (student.getStudentRoll() == roll)
                return i;
        }
        return -1;
    }
}