package com.sgp.sem3.crudapisbjavamvn.repository;

import com.sgp.sem3.crudapisbjavamvn.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{'sid': ?0}")
    Optional<Student> findByStudentId(String sid);

}
