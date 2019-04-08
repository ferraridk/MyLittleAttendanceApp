package dal;

import be.SchoolClass;
import be.Student;
import be.Teacher;
import dal.DbConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Philip
 */
public class Authentication
{
    public static DbConnection ds;
    
    public Authentication(){
        ds = new DbConnection();
    }
public Student validateStudentLogin(String username, String password) throws SQLException
{
    boolean login = false;
    Student stud = null;
    try (Connection con = ds.getConnection() ){
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("SELECT * FROM LoginStud "
                + "JOIN Student ON LoginStud.studentID = Student.studentID "
                + "JOIN Class ON Class.classID = Student.classID "
                + "WHERE username = ? AND password = ?");
        
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        
        
        
        while (rs.next())
        {
            int id = rs.getInt("studentID");
            String name = rs.getString("s_Name");
            String email = rs.getString("s_Email");
            String className = rs.getString("c_Name");
            stud = new Student(name, id, email, className);
            System.out.println("");

        }
    }

    return stud;
}

public Teacher validateTeacherLogin(String username, String password) throws SQLException
{
        String sqlTeach = "SELECT * FROM LoginTeach "
                + "JOIN Teacher ON LoginTeach.teacherID = Teacher.teacherID "

                + "WHERE username = ? AND password = ?";
    
    String sqlClasses = "SELECT * FROM Class "
            + "JOIN TeacherClass ON TeacherClass.classID = Class.classID "
            + "WHERE teacherID = ?";
    
    Teacher teach = null;
    try (Connection con = ds.getConnection() ){
        PreparedStatement pstmt;
        pstmt = con.prepareStatement(sqlTeach);
        
        
        
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        
        
        
        while (rs.next())
        {
            int id = rs.getInt("teacherID");
            String name = rs.getString("t_Name");
            String email = rs.getString("t_Email");

            teach = new Teacher(name, id, email);
            System.out.println("Hey Teach");

        }
        if (teach !=null)
        {
            PreparedStatement psClass = con.prepareStatement(sqlClasses);
            psClass.setInt(1, teach.getId());
            
            ResultSet rsClasses = psClass.executeQuery();
            
            while (rsClasses.next())
            {
                String className = rsClasses.getString("e_Name");
                SchoolClass sClass = new SchoolClass(className);
                teach.addClass(sClass);
            }
        }
    }

    return teach;
}

    
}
