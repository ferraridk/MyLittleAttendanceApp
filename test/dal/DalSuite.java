/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Caspe
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    dal.AttendanceDbDAOTest.class, dal.DbConnectionTest.class, dal.SchoolAppDALTest.class, dal.StudentDbDAOTest.class, dal.AuthenticationTest.class, dal.TesterTest.class, dal.TeacherDbDAOTest.class, dal.DAOInterfaceTest.class, dal.ClassDbDAOTest.class
})
public class DalSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }
    
}
