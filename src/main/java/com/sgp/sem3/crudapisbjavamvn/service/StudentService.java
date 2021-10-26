package com.sgp.sem3.crudapisbjavamvn.service;

import com.sgp.sem3.crudapisbjavamvn.model.Student;
import com.sgp.sem3.crudapisbjavamvn.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.insert(student);
    }

    public void updateStudent(Student student){
        Student savedStudent = studentRepository.findById(student.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find Student by ID %s", student.getId())));
        savedStudent.setStudentId(student.getStudentId());
        savedStudent.setStudentName(student.getStudentName());
        savedStudent.setS1(student.getS1());
        savedStudent.setS2(student.getS2());

        studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(String sid){
        return studentRepository.findByStudentId(sid).orElseThrow(()-> new RuntimeException(
                String.format("Can't find Student by student ID: %s",sid)));
    }

    public void deleteStudent(String sid){
        studentRepository.deleteById(
                studentRepository.findByStudentId(sid)
                .orElseThrow(()-> new RuntimeException(
                String.format("Can't find Student by student ID: %s",sid)))
                .getId()
        );
    }
}
