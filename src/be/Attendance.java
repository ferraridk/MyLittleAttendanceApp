package be;

import java.util.Calendar;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Philip
 */
public class Attendance
{

    private Date dateo; 
    private Calendar curDate;
    private final BooleanProperty wasThere= new SimpleBooleanProperty();
    private final StringProperty attendance=new SimpleStringProperty();
    private final StringProperty date=new SimpleStringProperty();
    private boolean requestAttendance;

    public Attendance(Calendar dt, boolean here)
    {
        requestAttendance=false;
 
        this.curDate = dt;
        wasThere.setValue(here);
        if(here==true)
        {
            attendance.set("Godkendt");
        }
        else
        {
            attendance.set("Fravær");
        }
        
        // set the time with date and year
        int day = curDate.get(Calendar.DAY_OF_MONTH);
        int month = curDate.get(Calendar.MONTH);
         month++;
        int year = curDate.get(Calendar.YEAR);
        date.set(""+day+"/"+month+"-"+year);
    }

    public Attendance(java.sql.Date date, Boolean wasThere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Calendar getCurDate()
    {
        return curDate;
    }

    public Boolean getWasThere()
    {
        return wasThere.get();
    }

    public String getDate()
    {
        return date.get();
    }

    public String getAttendance()
    {
        return attendance.get();
    }
    
    
   public void setAttendance(String insert)
   {
       attendance.set(insert);
   }
   
   public void setRequestAttendance(boolean x)
   {
       requestAttendance=x;
   }
   
   public boolean getRequestAttendance()
   {
       return requestAttendance;
   }
}
