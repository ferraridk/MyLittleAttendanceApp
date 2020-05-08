/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import be.Attendance;
import be.Student;
import be.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caspe
 */
public class DAOInterfaceTest
{
    
    public DAOInterfaceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }

    /**
     * Test of checkForDailyAttendance method, of class DAOInterface.
     */
    @Test
    public void testCheckForDailyAttendance() throws Exception
    {
    }

    /**
     * Test of checkForSchoolNetWork method, of class DAOInterface.
     */
    @Test
    public void testCheckForSchoolNetWork()
    {
    }

    /**
     * Test of removeStudent method, of class DAOInterface.
     */
    @Test
    public void testRemoveStudent() throws Exception
    {
    }

    /**
     * Test of askForAttendance method, of class DAOInterface.
     */
    @Test
    public void testAskForAttendance()
    {
    }

    /**
     * Test of getTeacher method, of class DAOInterface.
     */
    @Test
    public void testGetTeacher() throws Exception
    {
    }

    /**
     * Test of getStudent method, of class DAOInterface.
     */
    @Test
    public void testGetStudent() throws Exception
    {
    }

    /**
     * Test of removeTeacher method, of class DAOInterface.
     */
    @Test
    public void testRemoveTeacher() throws Exception
    {
    }

    /**
     * Test of addStudent method, of class DAOInterface.
     */
    @Test
    public void testAddStudent() throws Exception
    {
    }

    /**
     * Test of addTeacher method, of class DAOInterface.
     */
    @Test
    public void testAddTeacher() throws Exception
    {
    }

    public class DAOInterfaceImpl implements DAOInterface
    {

        public boolean checkForDailyAttendance(Date date) throws SQLServerException, IOException, SQLException
        {
            return false;
        }

        public boolean checkForSchoolNetWork()
        {
            return false;
        }

        public void removeStudent(Student StudToRemove) throws IOException, SQLServerException, SQLException
        {
        }

        public void askForAttendance(int id, Attendance chosenAttendance)
        {
        }

        public Teacher getTeacher(int id) throws SQLServerException, IOException, SQLException
        {
            return null;
        }

        public Student getStudent(int id) throws SQLServerException, IOException, SQLException
        {
            return null;
        }

        public void removeTeacher(Teacher TeachToRemove) throws IOException, SQLServerException, SQLException
        {
        }

        public Student addStudent(String name, int Id, String Email, int schoolClass) throws IOException, SQLServerException, SQLException
        {
            return null;
        }

        public Teacher addTeacher(String name, int Id, String Email) throws IOException, SQLServerException, SQLException
        {
            return null;
        }
    }
    
}
