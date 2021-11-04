package com.sgp.sem3.crudapisbjavamvn.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Represents a Student Model for the Database.
 * Specifies a Student with Student ID, Name and 2 semester objects.
 * @author PARTH
 * @version 1
 */
@Document("student")
public class Student {
    @Id
    String id;

    @Field(name = "sid")
    @Indexed(unique = true)     //indexed field in DB
    String studentId;

    @Field(name = "sname")
    String studentName;

    Semester s1;
    Semester s2;

    public Student() {}

    public Student(String studentId, String studentName, Semester s1, Semester s2) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Semester getS1() {
        return s1;
    }

    public void setS1(Semester s1) {
        this.s1 = s1;
    }

    public Semester getS2() {
        return s2;
    }

    public void setS2(Semester s2) {
        this.s2 = s2;
    }

}
