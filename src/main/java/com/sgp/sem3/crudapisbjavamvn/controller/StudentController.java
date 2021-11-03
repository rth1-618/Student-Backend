package com.sgp.sem3.crudapisbjavamvn.controller;

import com.sgp.sem3.crudapisbjavamvn.model.Semester;
import com.sgp.sem3.crudapisbjavamvn.model.Student;
import com.sgp.sem3.crudapisbjavamvn.model.Subject;
import com.sgp.sem3.crudapisbjavamvn.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
/** // TESTing POST
    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){
        *//*ArrayList<Subject> AL = new ArrayList<>();
        AL.add(new Subject("MS001","MySub1",3.0,"CC",4));
        AL.add(new Subject("MS002","MySub2",3.5,"CC",4));
        AL.add(new Subject("MS003","MySub3",3.5,"BB",7));
        AL.add(new Subject("MS004","MySub4",5,"BC",6));
        AL.add(new Subject("MS005","MySub5",2.0,"AB",9));*//*
        Student studentTest = new Student("20CS069","Akshay");
        studentService.addStudent(studentTest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){

        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{sid}")
    public ResponseEntity<Student> getStudentById(@PathVariable String sid){
        return ResponseEntity.ok(studentService.getStudentById(sid));
    }

    @DeleteMapping("/{sid}")
    public ResponseEntity deleteStudent(@PathVariable String sid){
        studentService.deleteStudent(sid);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
