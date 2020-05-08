package bll;

import java.sql.Date;
import be.Attendance;
import be.Student;
import be.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.AttendanceDbDAO;
import dal.Authentication;
import dal.SchoolAppDAL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Christian Occhionero
 */
public class SchoolAppManager
{
    private final Authentication authentication;
    private final SchoolAppDAL dal;
    private AttendanceDbDAO DAL;

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

    public Teacher validateTeacherLogin(String text, String text0) throws SQLException {
        return authentication.validateTeacherLogin(text, text0);
    }

    public ArrayList<Attendance> getAttendance( int studId)throws SQLServerException, IOException, SQLException{
        return DAL.getAttendance(studId);
    }

}
