/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

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
    gui.controller.StudentViewControllerTest.class, gui.controller.TeacherViewControllerTest.class, gui.controller.RootLayoutControllerTest.class, gui.controller.LoginControllerTest.class
})
public class ControllerSuite
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
