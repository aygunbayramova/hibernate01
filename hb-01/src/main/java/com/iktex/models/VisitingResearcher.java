package com.iktex.models;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

    public VisitingResearcher() {}

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }
}
