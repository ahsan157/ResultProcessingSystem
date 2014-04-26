/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.swing.JOptionPane;
import static result.processing.system.StudentList.t_studentList;

public class student_info 
{
    int d;
    public void student_info_create(String s1_session)
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
                String s2 =("CREATE TABLE t_session"+s1_session+"(student_id varchar(20), student_name varchar(50),dormitory varchar(50))");                               
                st.executeUpdate(s2); 
                System.out.println("yes.....main");
            }                        
            catch(Exception ex)            
            {  
               // for(int j=0;j<20;++j)                                                                                                                                     
                                
                //    try                    
                    {   
                        int p,q;
                            for(p=0;p<20;++p)
                            {
                                 result.processing.system.StudentList.StatusData[p][0]="";                                  
                                 result.processing.system.StudentList.StatusData[p][1]="";                                 
                                 result.processing.system.StudentList.StatusData[p][2]="";
                            
                            }                    
                        for(int f=0;f<2;++f)
                        {
                            if(f==0)
                            {
                                ResultSet res = st.executeQuery("select * from t_session"+s1_session+" where student_id like 'CE11%'  order by student_id asc");
                                int j=0;
                                while(res.next()==true)                                                                                                         
                               { // process results one row at a time                
                                   String a,b,c;
                                    
                                   a = res.getString("student_id");                                                       
                                   b = res.getString("student_name");                    
                                   c =res.getString("dormitory");
                                   System.out.println("   "+a+"     "+b+"\t"+c);
                                  result.processing.system.StudentList.StatusData[j][0]=a; 
                                  result.processing.system.StudentList.StatusData[j][1]=b;
                                  result.processing.system.StudentList.StatusData[j][2]=c;
                                  ++j;
                                  d=j;
                               }
                            }
                            if(f==1)
                            {
                                ResultSet res = st.executeQuery("select * from t_session"+s1_session+" where student_id not like 'CE11%'  order by student_id asc");
                                //int j=0;
                                while(res.next()==true)                                                                                                         
                               { // process results one row at a time                
                                   String a,b,c;                                 
                                   a = res.getString("student_id");                                                       
                                   b = res.getString("student_name");                    
                                   c =res.getString("dormitory");
                                   System.out.println("   "+a+"     "+b+"\t"+c);
                                  result.processing.system.StudentList.StatusData[d][0]=a; 
                                  result.processing.system.StudentList.StatusData[d][1]=b;
                                  result.processing.system.StudentList.StatusData[d][2]=c;
                                  ++d;
                               }
                            }
                          //System.out.println("yes");
                            
                            
                            
                            
                        }
                            
                            System.out.println("yes..kmkm");                             
                                    // String s6="insert into temp_"+s_student_id+"_"+s_student_name+"_"+s_dormitory+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                                                     
                            // st.executeUpdate(s6);                              
                            System.out.println("yes..2222");                             
                                               
                    }                    
                               
                //show info
                System.out.println("inner already table create..........");                
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........ppp");            
        }      
    }
    
    public void student_info_insert(String s1_session,String s2_student_id,String s3_name,String s4_dormitory)
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
               // st.executeUpdate("truncate table t_session"+s1_session+"");
                
                   String sub="",sub_re="",tag_re="",t_str="",st_session,st_studentid;
                   int i_re,p,q,p1,q1;                        
                   for(i_re=0;i_re<s2_student_id.length();++i_re)           
                   {
                        if(s2_student_id.charAt(i_re)>='0'&&s2_student_id.charAt(i_re)<='9')
                        {
                            break;
                        }
                   }
                   sub=((t_studentList.getModel().getValueAt(0, 0)).toString()).substring(i_re, i_re+2);
                   t_str=(t_studentList.getModel().getValueAt(0, 0)).toString();
                   sub_re=s2_student_id.substring(i_re, i_re+2);
                   System.out.println(sub_re);
                        
                       
                   if(sub_re.compareTo(sub)!=0&&t_str.length()==s2_student_id.length())
                   {
                       p=sub_re.charAt(0)-'0';
                       q=sub_re.charAt(1)-'0';
                       p=p*10+q;
                       p1=sub.charAt(0)-'0';
                       q1=sub.charAt(1)-'0';
                       p1=p1*10+q1;
                       
                       System.out.println("noman "+p);
                       
                       
                       for(int i=p;i<p1;++i)
                       {
                           String s=String.valueOf(i-1);
                           if(s.length()==1)
                           {
                               s="0"+s+"";
                           }
                           String s1=String.valueOf(i);
                           if(s1.length()==1)
                           {
                               s1="0"+s1+"";
                           }
                           st_session="20"+s+"_"+s1+"";
//                           JOptionPane.showMessageDialog(null, s2_student_id+" "+st_session);
                           student_info_delete(st_session, s2_student_id);
                           student_info_delete(st_session, s2_student_id+"(Re-Add)");
                       }
                       //student_info_delete(s1_session, s2_student_id);
                       System.out.println(sub+"    bbbbbbbbbbb");
                       s2_student_id=s2_student_id+"(Re-Add)";
                   }
                
                String s5="insert into t_session"+s1_session+"(student_id,student_name,dormitory)" + "values('"+s2_student_id+"','"+s3_name+"','"+s4_dormitory+"');";                                         
                st.executeUpdate(s5);
                ResultSet res = st.executeQuery("select * from t_session"+s1_session+"");
                //System.out.println("yes");
                String a,b,c;
                while(res.next()==true)                                                                                                         
                { // process results one row at a time                   
                    a = res.getString("student_id");                                                       
                    b = res.getString("student_name");                    
                    c =res.getString("dormitory");
                    System.out.println("   "+a+"     "+b+"\t"+c);
                }
            }                        
            catch(Exception ex)            
            {  
                //show info
                System.out.println("huuuuuuuuuuuuuuuuuu");
                System.out.println("inner already table create..........");                
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }      
    }
        public void student_info_delete(String s1_session,String s2_studentid)
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
                String s5="delete from t_session"+s1_session+" where student_id='"+s2_studentid+"';";                                         
                st.executeUpdate(s5);                
                ResultSet res = st.executeQuery("select * from t_session"+s1_session+"");
                String a,b,c;
                while(res.next()==true)                                                                                     
                { // process results one row at a time                   
                    a = res.getString("student_id");                                                       
                    b = res.getString("student_name");                    
                    c =res.getString("dormitory");
                    System.out.println("   "+a+"     "+b+"\t"+c);
                }
            }                        
            catch(Exception ex)            
            {  
                //show info
                System.out.println("inner already table create..........");                
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }      
    }
}
