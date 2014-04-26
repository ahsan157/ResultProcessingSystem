
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.swing.JOptionPane;

/**
 *
 * @author Ahsan
 */
public class DbSpecialCourse 
{
    public int SpecialCheck(String s_CourseCode)
    {
         
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
            Statement st1 = conn.createStatement();
            try
            {
                 ResultSet res = st.executeQuery("select * from speacalcheck");
                 String a,b;      
                
                  while(res.next()==true)
                  {    
                      String a1_courseCOde;                      
                      //course_code,course_title,session,credit,type                      
                      a1_courseCOde=res.getString("course_code");                      
                      if(a1_courseCOde.compareTo(s_CourseCode)==0)                                                
                      return 1;                                                    
                  }
                    
            }                    
            catch(Exception ex2)                    
            { 
//                JOptionPane.showMessageDialog(null, "oh nooooo");
            }
   
        }
        catch(Exception ex1)        
        {        
            System.out.println("already table create..........");            
        } 
        return 5;
    }
}
