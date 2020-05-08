/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.time.LocalDate;

/**
 *
 * @author Caspe
 */
public class AttendanceTest
{
    private int id;
    private LocalDate date;
    private Student stud;
    private boolean absent;

    public AttendanceTest(LocalDate date, Student stud)
    {
        this.date = date;
        this.stud = stud;
    }

    public int getId()
    {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }


    public Student getStud()
    {
        return stud;
    }

    public boolean isAbsent()
    {
        return absent;
    }

    public void setAbsent(boolean absent)
    {
        this.absent = absent;
    }
    
    
}
