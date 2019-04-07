package be;

import java.util.ArrayList;

/**
 *
 * @author Christian Occhionero
 */
<<<<<<< HEAD
public class Teacher 
{
    private String tName;
    private String tEmail;
    private int id;

    public Teacher(String tName, String tEmail, int id)
    {
        this.tName = tName;
        this.tEmail = tEmail;
        this.id = id;
    }

    public String gettName()
    {
        return tName;
    }

    public void settName(String tName)
    {
        this.tName = tName;
    }

    public String gettEmail()
    {
        return tEmail;
    }

    public void settEmail(String tEmail)
    {
        this.tEmail = tEmail;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Teacher{" + "tName=" + tName + ", tEmail=" + tEmail + ", id=" + id + '}';
    }
    
    
=======
public class Teacher extends Person
{
private ArrayList<SchoolClass> classes;

 public Teacher (String name, int id, String email)
    {
       super(name,  id, email);
        classes = new ArrayList<>();
        
    }
 
 public void addClass(SchoolClass classToAdd)
 {
     classes.add(classToAdd);
 }
 
 public ArrayList<SchoolClass> getAllClasses()
 {
     return classes;
 }
>>>>>>> f7b4c219253bb5d4c30f2c771d73fe95e1173a6a
}

