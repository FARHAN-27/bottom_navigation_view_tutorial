package com.example.bottom_navigation_view_tutorial;

public class Doctor {
    private String name , degree ;

    public  Doctor(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Doctor(String nam , String degree)
    {
        this.name = nam ;
        this.degree = degree ;
    }
}
