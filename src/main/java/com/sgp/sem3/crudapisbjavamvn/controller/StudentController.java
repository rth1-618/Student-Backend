package com.sgp.sem3.crudapisbjavamvn.controller;

import com.sgp.sem3.crudapisbjavamvn.model.Student;
import com.sgp.sem3.crudapisbjavamvn.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * For Controlling and Mapping Requests to Service.
 * Uses StudentService to map methods.
 * @see StudentService
 * @author PARTH
 * @version v2 Changed DeleteMapping  return type to Response Entity
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    /**
     * Initializes Service object upon a Controller creation
     * @param studentService object to be referenced
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Controls to map adding new record to Database
     * @param student Student object to be recorded.&nbsp;
     *                Fetched from body of Http request by Spring MVN.
     * @return One of the following Status Codes: <ul>
     *     <li>201 for successful addition of record
     *     <li>500 Server Error</li>
     * </ul>
     */
    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){

        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Controls to map Modifying exising record in Database
     * @param student Student object to be recorded.&nbsp;
     *                Fetched from body of Http request by Spring MVN.
     * @return One of the following Status Codes: <ul>
     *     <li>201 for successful push of record
     *     <li>500 Server Error</li>
     * </ul>
     */
    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return ResponseEntity.ok().build();
    }

    /**
     * Maps Fetch All Records Service to HTTP request and performs Service
     * @return One of the following Status Codes: <ul>
     *           <li>200 for successful fetch of all records </li>
     *           <li>500 Server Error</li>
     *      </ul>
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    /**
     * Maps Service to HTTP request and Fetches a single record.
     * @param sid ID of the student to be fetched from the Database.
     * @return One of the following Status Codes: <ul>
     *           <li>200 for successful fetch of record </li>
     *           <li>500 Server Error</li>
     *      </ul>
     */
    @GetMapping("/{sid}")
    public ResponseEntity<Student> getStudentById(@PathVariable String sid){
        return ResponseEntity.ok(studentService.getStudentById(sid));
    }

    /**
     * Maps Service to HTTP request and Deletes a single record.
     * @param sid ID of the student to be fetched from the Database.
     * @return One of the following Status Codes: <ul>
     *           <li>204 for successful delete of record </li>
     *           <li>500 Server Error</li>
     *      </ul>
     */
    @DeleteMapping("/{sid}")
    public ResponseEntity deleteStudent(@PathVariable String sid){
        studentService.deleteStudent(sid);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
