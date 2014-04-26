
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ParmanentResultSessionTable 
{
    public void parmanent_theory_table(String s1_coursecode,String s2_session,String s3_admin_id)
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
               // st.executeUpdate("drop table temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"");                
                String s4 =("CREATE TABLE temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"(student_id varchar(20), student_name varchar(50),class_test varchar(20),attendence varchar(20),tctam varchar(20),internal varchar(20),external varchar(20),third_examiner varchar(20),avg varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                st.executeUpdate(s4);                                                                   
                ResultSet res = st.executeQuery("select * from t_session"+s2_session+"");
                while(res.next()==true)                                                                                                         
                {                                       
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    System.out.println("   "+a+"     "+b+"\t"); 
                   String s6="insert into temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+a+"','"+b+"','','','','','','','','','','','','');";                                         
                    st1.executeUpdate(s6);  
                    
                }            
                System.out.println("yes1111");
                //conn.close();
     
            }
            catch(Exception ex)
            {
                //show info
                st.executeUpdate("drop table temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"");                
                String s4 =("CREATE TABLE temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"(student_id varchar(20), student_name varchar(50),class_test varchar(20),attendence varchar(20),tctam varchar(20),internal varchar(20),external varchar(20),third_examiner varchar(20),avg varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                st.executeUpdate(s4);                                                                   
                ResultSet res = st.executeQuery("select * from t_session"+s2_session+"");
                while(res.next()==true)                                                                                                         
                {                                       
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    System.out.println("   "+a+"     "+b+"\t"); 
                   String s6="insert into temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+a+"','"+b+"','','','','','','','','','','','','');";                                         
                    st1.executeUpdate(s6);  
                    
                }
                System.out.println("theory ex");
            
            }            
        }
        
        catch(Exception ex)        
        {        
            System.out.println(ex);            
        }      
    }
}
