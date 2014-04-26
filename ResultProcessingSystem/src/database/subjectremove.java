
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
public class subjectremove 
{
     public void Admin_info_create(String s1_Coursecode,String s_adminid)
     {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
            
           // String s_adminid ="";                               
            System.out.println("1..........");    
        
            ResultSet res1 = st.executeQuery("select * from t_admin_course_"+s_adminid+" where course_code='"+s1_Coursecode+"'");                                        
            String tac_course ="",tac_coursetitle="",tac_session= "",tac_credit= "",tac_type= "";                               
                System.out.println("2");
            while(res1.next()==true)                                                 
            { // process results one row at a time   
                //course_code,course_title,session,credit,type
                tac_course = res1.getString("course_code");
                tac_coursetitle = res1.getString("course_title");
                tac_session = res1.getString("session");
                tac_credit = res1.getString("credit");
                tac_type = res1.getString("type");
                System.out.println("2");
            }
            
            st.executeUpdate("delete from t_admin_course_"+s_adminid+" where course_code='"+s1_Coursecode+"'");  
            System.out.println("3");
            st.executeUpdate("drop table temp_"+tac_course+"_"+tac_session+"_"+s_adminid+"");
            System.out.println("4");
            st.executeUpdate("drop table "+tac_course+""+tac_session+"");
            System.out.println("5");
            st.executeUpdate("delete from allcourse where coursecode='"+s1_Coursecode+"'");    
            try
            {
                st.executeUpdate("delete from speacalcheck where course_code='"+s1_Coursecode+"'");  
//                JOptionPane.showMessageDialog(null, s1_Coursecode);
            }
            catch(Exception ex1)
            {
   //             JOptionPane.showMessageDialog(null, s1_Coursecode+"ex.......");
            }
            
            try
            {
                st.executeUpdate("drop table temp_"+tac_course+"_"+tac_session+"_"+s_adminid+"_bl");                
            }
            catch(Exception ex1)
            {
    //            JOptionPane.showMessageDialog(null, s1_Coursecode+"ex");
            }
            int i;
            String sub;
           
                for(i=0;i<tac_course.length();++i)
                {
                    if(tac_course.charAt(i)>='0'&&tac_course.charAt(i)<='9')
                    {
                        break;
                    }
                }
                sub=tac_course.substring(i, i+2);
                System.out.println(sub);
                
                st.executeUpdate("delete from t_session_"+tac_session+"_"+sub+" where coursecode='"+tac_course+""+tac_session+"'");  
                
                System.out.println("6");
                
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }      
    }    
}
