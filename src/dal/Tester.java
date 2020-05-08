/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import be.AttendanceTest;
import be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Caspe
 */
public class Tester
{
    public static void main(String[] args) throws IOException, SQLServerException, SQLException
    {
        Student st = new Student("Peter", 4, "pt@easv.dk", "");
        AttendanceDbDAO ad = new AttendanceDbDAO(); 
      
////        System.out.println(d);
//        ad.removeStudent(ad.getStudent(2));
//            ad.addTeacher("Hans", 1, "Hans@easv.com");
//        System.out.println(ad.getTeacher(1));
        //ad.removeTeacher(ad.getTeacher(1));
       ad.getStudent(4);
        System.out.println(ad.getStudent(4));
        //System.out.println(ad.editAttendance(st, at));
        
   

   
    }
}
