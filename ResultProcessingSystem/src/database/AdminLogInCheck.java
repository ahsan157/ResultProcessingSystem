/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ahsan
 */
public class AdminLogInCheck 
{
    public int admin_login_check(String s1,String s2)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");            
            System.out.println(" successfull connect");            
            Statement st = conn.createStatement();            
            try                        
            {
                ResultSet res = st.executeQuery("select * from t_admin_info");
                String a = null,b = null,s_adminID=null,s_adminName=null;
                while(res.next()==true)                                                                                     
                { // process results one row at a time 
                    s_adminID=res.getString("admin_id");
                    s_adminName=res.getString("admin_name");
                    a = res.getString("username");                                                       
                    b = res.getString("password"); 
                    if(a.compareTo(s1)==0&&b.compareTo(s2)==0)
                    {                    
                        System.out.println("success");
                        return 1;
                    }
                
                }
                
                    System.out.println("no success");
                    return 0;
                
            }                        
            catch(Exception ex)            
            {            
                System.out.println("inner already table create..........");                
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }
        return 5;
      }
}
