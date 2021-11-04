package com.sgp.sem3.crudapisbjavamvn.service;

import com.sgp.sem3.crudapisbjavamvn.model.Student;
import com.sgp.sem3.crudapisbjavamvn.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides and Implements methods for CRUD operations on StudentRepository
 * Uses StudentRepository to make perform CRUD operations on.
 * @see StudentRepository
 * @author PARTH
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Adds student to repository.
     * @param student object to be added.
     */
    public void addStudent(Student student){
        studentRepository.insert(student);
    }

    /**
     * Updates student from Repository.
     * @param student object to be updated.
     */
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

    /**
     * Fetches list of All Records in Repository.
     * @return a List of All records
     */
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    /**
     * Fetches a single record.
     * @param sid ID of the student to be be fetched.
     * @return a Student object fetched from the Repository.
     */
    public Student getStudentById(String sid){
        return studentRepository.findByStudentId(sid).orElseThrow(()-> new RuntimeException(
                String.format("Can't find Student by student ID: %s",sid)));
    }

    /**
     * Deletes a Student from the Repository
     * @param sid ID of Student to be deleted
     */
    public void deleteStudent(String sid){
        studentRepository.deleteById(
                studentRepository.findByStudentId(sid)
                .orElseThrow(()-> new RuntimeException(
                String.format("Can't find Student by student ID: %s",sid)))
                .getId()
        );
    }
}
