package bll;

import java.sql.Date;
import be.Attendance;
import be.Student;
import be.Teacher;
import dal.Authentication;
import dal.SchoolAppDAL;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Christian Occhionero
 */
public class SchoolAppManager
{
    private final Authentication authentication;
    private final SchoolAppDAL dal;

    public SchoolAppManager() throws IOException
    {
        authentication = new Authentication();
        this.dal = new SchoolAppDAL();
    }
    
    public Student getStudent(String username, String password)
    {
        return dal.getStudent(0);
    }
    
    public Student getLoginStudent (String username, String password) throws SQLException{
        return authentication.validateStudentLogin(username, password);
    }

    public boolean checkForSchoolNetwork()
    {
        return dal.checkForSchoolNetWork();
               
    }

    public boolean checkForDailyAttendance(Date date)
    {
       return dal.checkForDailyAttendance(date);
    }

    public void askForAttendance(int id, Attendance chosenAttendance)
    {
        dal.askForAttendance(id, chosenAttendance);
    }

    public Teacher getLoginTeacher(String username, String password) throws SQLException
    {
       return authentication.validateTeacherLogin(username, password);
    }

    public Teacher getTeacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Teacher validateTeacherLogin(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
