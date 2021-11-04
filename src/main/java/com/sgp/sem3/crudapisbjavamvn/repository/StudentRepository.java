package com.sgp.sem3.crudapisbjavamvn.repository;

import com.sgp.sem3.crudapisbjavamvn.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * Student Repository inherits features from MongoRepository
 * and provides a reference to access Database.
 * {@inheritDoc}
 * @author PARTH
 */
public interface StudentRepository extends MongoRepository<Student, String> {
    /**
     * This method does not exist in the MongoRepository framework class.
     * It searches for a Student with a given id
     * @param sid the university id of the Student to be searched
     * @return a Student Object
     */
    @Query("{'sid': ?0}")
    Optional<Student> findByStudentId(String sid);

}
