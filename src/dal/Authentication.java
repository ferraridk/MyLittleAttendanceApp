package dal;

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
public static Student validateStudentLogin(String username, String password) throws SQLException
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

public static Teacher validateTeacherLogin(String username, String password) throws SQLException
{
        boolean login = false;
    Teacher teach = null;
    try (Connection con = ds.getConnection() ){
        PreparedStatement pstmt;
        pstmt = con.prepareStatement("SELECT * FROM LoginTeach "
                + "JOIN Teacher ON LoginTeach.teacherID = Teacher.teacherID "
                + "JOIN TeacherClass ON TeacherClass.teacherID = TeacherClass.classID "
                + "WHERE username = ? AND password = ?");
        
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        
        
        
        while (rs.next())
        {
            int id = rs.getInt("teacherID");
            String name = rs.getString("t_Name");
            String email = rs.getString("t_Email");
            String className = rs.getString("c_Name");
            teach = new Teacher(name, id, email);
            System.out.println("Hey Teach");

        }
    }

    return teach;
}

    
}
