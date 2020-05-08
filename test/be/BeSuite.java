/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

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
    be.PersonTest.class, be.StudentTest.class, be.TeacherTest.class, be.AttendanceTest.class, be.AttendanceTestTest.class, be.SchoolClassTest.class
})
public class BeSuite
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
