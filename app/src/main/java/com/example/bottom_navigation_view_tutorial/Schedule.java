package com.example.bottom_navigation_view_tutorial;

public class Schedule {

    private  String agenda , date , time ;

    public Schedule(String agenda , String date , String time)
    {
        this.agenda = agenda ;
        this.date  = date ;
        this.time = time ;
    }
    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
