/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

/**
 *
 * @author Henrik Ferrari
 */
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
    
    
}
