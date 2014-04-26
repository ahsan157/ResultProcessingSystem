package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbcon_administrator_login 
{
    public void administrator_login_create()
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
                String table = "CREATE TABLE t_administrator_login(username varchar(20), password varchar(20))";                
                st.executeUpdate(table);                
                String insert_value_b_log_table="insert into t_administrator_login(username,password)" + "values('mbstu','cse');";                                         
                st.executeUpdate(insert_value_b_log_table);                
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
      }
    public void administrator_login_update(String s1,String s2)
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
                st.executeUpdate("truncate table t_administrator_login");
                String insert_value_b_log_table="insert into t_administrator_login(username,password)" + "values('"+s1+"','"+s2+"');";                                         
                st.executeUpdate(insert_value_b_log_table); 
                System.out.println("yes");
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
      }
    
    public int administrator_login_check(String s1,String s2)
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
                ResultSet res = st.executeQuery("select * from t_administrator_login");
                String a = null,b = null;
                while(res.next()==true)                                                                                     
                { // process results one row at a time                   
                    a = res.getString("username");                                                       
                    b = res.getString("password");                    
                }
                if(a.compareTo(s1)==0&&b.compareTo(s2)==0)
                {
                    
                    System.out.println("success");
                    return 1;
                    
                }
                else
                {
                    System.out.println("no success");
                    return 0;
                }
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


