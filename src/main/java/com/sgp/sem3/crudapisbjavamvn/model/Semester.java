package com.sgp.sem3.crudapisbjavamvn.model;

import java.util.ArrayList;

/**
 * Demonstrates a Semester with an ArrayList of Subjects.
 * @author PARTH
 */
public class Semester {
    int sem;
    ArrayList<Subject> subjects;

    public Semester(int sem, ArrayList<Subject> subjects) {
        this.sem = sem;
        this.subjects = subjects;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

}
