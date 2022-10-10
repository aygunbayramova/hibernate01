package com.iktex.models;

import javax.persistence.Entity;

@Entity
public class PermamentInstructor extends Instructor{
    private double fixedSalary;

    public PermamentInstructor() {}

    public PermamentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermamentInstructor(String name, String address, String phoneNumber, double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }
}
