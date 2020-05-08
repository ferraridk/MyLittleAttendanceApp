/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    gui.model.ModelSuite.class, gui.view.ViewSuite.class, gui.controller.ControllerSuite.class
})
public class GuiSuite
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
