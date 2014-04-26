/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Db_SpeacalCourseInsert 
{
   
    public void Special_theory_table(String s_Student_ID,String s_student_Name,String s_examSession,String s_coursecode,String s_CourseTitle,String s_session,String s_credit,String s_type,String s_admin_id)
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
                String s_table;
                
                    s_table="temp_"+s_coursecode+"_"+s_examSession+"_"+s_admin_id+"";
               
              
               // st.executeUpdate("drop table temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"");                
                try
                {
                      String s4 =("CREATE TABLE "+s_table+"(student_id varchar(20), student_name varchar(50),class_test varchar(20),attendence varchar(20),tctam varchar(20),internal varchar(20),external varchar(20),third_examiner varchar(20),avg varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                      st.executeUpdate(s4);
                }
                catch(Exception ex)
                {
//                    JOptionPane.showMessageDialog(null, s_table+"Not successfully table create");
                }
                
                try                        
                {
                    String s7="insert into t_admin_course_"+s_admin_id+"(course_code,course_title,session,credit,type)" + "values('"+s_coursecode+"','"+s_CourseTitle+"','"+s_examSession+"','"+s_credit+"','"+s_type+"');";                                         
                    st.executeUpdate(s7);                    
                }
                catch(Exception ex)
                {
                    //show info
                    System.out.println("inner already table create Admin_course_assign_insert..........");                
                }
                
                   String s6="insert into "+s_table+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+s_Student_ID+"(sp)','"+s_student_Name+"','','','','','','','','','','','','');";                                         
                   st.executeUpdate(s6);  
//                     JOptionPane.showMessageDialog(null, "yes.......theory");               
                //conn.close();
     
            }
            catch(Exception ex)
            {
//                JOptionPane.showMessageDialog(null, "sorry");
            }            
        }
        
        catch(Exception ex)        
        {        
            System.out.println("huda");            
        }      
    }
    
    public void Special_lab_table(String s_Student_ID,String s_student_Name,String s_examSession,String s_coursecode,String s_CourseTitle,String s_session,String s_credit,String s_type,String s_admin_id)
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
                String s_table;
               s_table="temp_"+s_coursecode+"_"+s_examSession+"_"+s_admin_id+"";
               
               try
                {
       
                    String s4 =("CREATE TABLE "+s_table+"(student_id varchar(20), student_name varchar(50),lab_quiz varchar(20),lab_viva varchar(20),lab_final varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                    st.executeUpdate(s4);                                                                   
                
                }
                catch(Exception ex)
                {
//                    JOptionPane.showMessageDialog(null, s_table+"Not successfully table create");
                }
                try                        
                {
                    String s7="insert into t_admin_course_"+s_admin_id+"(course_code,course_title,session,credit,type)" + "values('"+s_coursecode+"','"+s_CourseTitle+"','"+s_examSession+"','"+s_credit+"','"+s_type+"');";                                         
                    st.executeUpdate(s7);                    
                }
                catch(Exception ex)
                {
                    //show info
                    System.out.println("inner already table create Admin_course_assign_insert..........");                
                }
               // st.executeUpdate("drop table temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"");                
                                                          
                   String s6="insert into "+s_table+"(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+s_Student_ID+"(sp)','"+s_student_Name+"','','','','','','','','');";                                         
                    st.executeUpdate(s6);  
//                    JOptionPane.showMessageDialog(null, "yes.......Lab");               
                
                System.out.println("yes1111");
                //conn.close();
     
            }
            catch(Exception ex)
            {
                System.out.println("lab_ex");
            
            }            
        }
        
        catch(Exception ex)        
        {        
            System.out.println(ex);            
        }      
    }
    
    public void Special_project_table(String s_Student_ID,String s_student_Name,String s_examSession,String s_coursecode,String s_CourseTitle,String s_session,String s_credit,String s_type,String s_admin_id)
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
                String s_table;
                s_table="temp_"+s_coursecode+"_"+s_examSession+"_"+s_admin_id+"";
                
               // st.executeUpdate("drop table temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"");                
                
                 try
                {
                    String s4 =("CREATE TABLE "+s_table+"(student_id varchar(20), student_name varchar(50), presentation varchar(20),project_viva varchar(20),mark_70 varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                    st.executeUpdate(s4);                                                                                                                                                                     
                }
                catch(Exception ex)
                {
//                    JOptionPane.showMessageDialog(null, s_table+"Not successfully table create");
                }
                 
                try                        
                {
                    String s7="insert into t_admin_course_"+s_admin_id+"(course_code,course_title,session,credit,type)" + "values('"+s_coursecode+"','"+s_CourseTitle+"','"+s_examSession+"','"+s_credit+"','"+s_type+"');";                                         
                    st.executeUpdate(s7);                    
                }
                catch(Exception ex)
                {
                    //show info
                    System.out.println("inner already table create Admin_course_assign_insert..........");                
                }
                
                   String s6="insert into "+s_table+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s_Student_ID+"(sp)','"+s_student_Name+"','','','','','','','','');";                                         
                    st.executeUpdate(s6);  
                    
 //              JOptionPane.showMessageDialog(null, "yes.......project");               
                System.out.println("yes1111");
                //conn.close();
     
            }
            catch(Exception ex)
            {
                System.out.println(ex+"ggtggggggg"); 
            }            
        }
        
        catch(Exception ex)        
        {        
            System.out.println(ex);            
        }      
    }
    
    public void Special_thisis_table(String s_Student_ID,String s_student_Name,String s_examSession,String s_coursecode,String s_CourseTitle,String s_session,String s_credit,String s_type,String s_admin_id)
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
                String s_table;
                s_table="temp_"+s_coursecode+"_"+s_examSession+"_"+s_admin_id+"";
                
               // st.executeUpdate("drop table "+s_table+"");                
                                                                                  
                 try
                {
                     String s4 =("CREATE TABLE "+s_table+"(student_id varchar(20), student_name varchar(50),internal varchar(20),external varchar(20),presentation varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                    st.executeUpdate(s4);                                                                                                                                                                     
                }
                catch(Exception ex)
                {
//                    JOptionPane.showMessageDialog(null, s_table+"Not successfully table create");
                }
                 
                 try                        
                {
                    String s7="insert into t_admin_course_"+s_admin_id+"(course_code,course_title,session,credit,type)" + "values('"+s_coursecode+"','"+s_CourseTitle+"','"+s_examSession+"','"+s_credit+"','"+s_type+"');";                                         
                    st.executeUpdate(s7);                    
                }
                catch(Exception ex)
                {
                    //show info
                    System.out.println("inner already table create Admin_course_assign_insert..........");                
                }
                   String s6="insert into "+s_table+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+s_Student_ID+"(sp)','"+s_student_Name+"','','','','','','','','');";                                         
                    st.executeUpdate(s6);  
  //                  JOptionPane.showMessageDialog(null, "yes.......thesis");               
                         
                System.out.println("yes1111");
                //conn.close();
     
            }
            catch(Exception ex)
            {
                System.out.println("thesis_ex");
            
            }            
        }
        
        catch(Exception ex)        
        {        
            System.out.println(ex);            
        }      
    }
}
