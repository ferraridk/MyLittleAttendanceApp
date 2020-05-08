package gui.model;

import java.util.ArrayList;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import be.Attendance;
import be.SchoolClass;
import be.Student;
import be.Teacher;
import bll.SchoolAppManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Christian Occhionero
 */
public class SchoolAppModel
{

     private final SchoolAppManager manager;
    private Student s;
    private ObservableList<Attendance> oList;
    private ObservableList<SchoolClass> classList;
    private Teacher t;

    public SchoolAppModel() throws IOException
    {
        this.manager = new SchoolAppManager();
        classList=FXCollections.observableArrayList();
        classList.add(new SchoolClass("Hold"));
    }
    
    
    public ObservableList<SchoolClass> getAllClasses()
    {

        return classList;
    }
    
    public boolean checkForSchoolNetwork()
    {
        return manager.checkForSchoolNetwork();
    }

    public boolean checkForDailyAttendance(Date date)
    {
        return manager.checkForDailyAttendance(date);
    }

    public void askForAttendance(int id, Attendance chosenAttendance)
    {
        manager.askForAttendance(id,chosenAttendance);
    }
}
