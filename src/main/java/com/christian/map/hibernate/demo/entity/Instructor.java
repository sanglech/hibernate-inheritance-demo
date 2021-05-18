package com.christian.map.hibernate.demo.entity;

import javax.persistence.Entity;

@Entity
public class Instructor extends User{

    private Double salary;

    public Instructor(String firstName, String lastName, String email,Double salary) {
        super(firstName, lastName, email);
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
