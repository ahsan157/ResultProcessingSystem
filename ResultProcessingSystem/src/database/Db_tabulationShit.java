
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.swing.JOptionPane;

public class Db_tabulationShit 
{
    public String getlg(float mo)
                        {
                            if(mo==4)
                                return "A+";
                            else if(mo>=3.75)
                                return "A";
                            else if(mo>=3.50)
                                return "A-";
                            else if(mo>=3.25)
                                return "B+";
                            else if(mo>=3.00)
                                return "B";
                            else if(mo>=2.75)
                                return "B-";
                            else if(mo>=2.50)
                                return "C+";
                            else if(mo>=2.25)
                                return "C";
                            else if(mo>=2.00)
                                return "D";
                            else
                                return "F";
                        }
    
    
    
  float gl_credit=0;  
 public void getcoursecode(String s_session,String s_semester)
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
                ResultSet res = st.executeQuery("select * from t_session_"+s_session+"_"+s_semester+"");
                int j=4;
                while(res.next()==true)                                                                                                         
                { // process results one row at a time                                
                    String a,b,c;                                                            
                    a = res.getString("coursecode");                                     
                    b=res.getString("credit");
                    a=a.substring(0, 7);                    
                    result.processing.system.tabulationShit.resdata[0][j]=a;
                    result.processing.system.tabulationShit.resdata[1][j-1]="Credit: "+b;
                    gl_credit+=Float.parseFloat(b);
                    j+=4;
                    
                }
                //JOptionPane.showMessageDialog(null, ""+gl_credit);
            }   
            catch(Exception ex1)
            {
            }
                                                               
                                            
        }                  
        catch(Exception ex)        
        {        
            System.out.println("already table create..........ppp");            
        } 
 }
    int d;
    public void student_info(String s1_session, String s_semester)
    {
        String subsession;
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
                ResultSet res = st.executeQuery("select * from t_session_"+s1_session+"_"+s_semester+"");                
                while(res.next()==true)                                                                                                         
                { // process results one row at a time                                
                    String a,b,c;                                                                                
                    b=res.getString("credit");                    
                    gl_credit+=Float.parseFloat(b);                    
                    
                }                
            }   
            catch(Exception ex1)
            {
            }
            
            
            
            
            try                    
            {   
                        int p,q,int_course_code_index;
                            subsession=s1_session.substring(5, 7);
                            System.out.println(subsession);
                        for(int f=0;f<2;++f)
                        {
                            if(f==0)
                            {
                                ResultSet res = st.executeQuery("select * from t_session"+s1_session+" where student_id like 'CE"+subsession+"%' order by student_id asc");
                                int j=3;
                                
                                while(res.next()==true)                                                                                                         
                               { // process results one row at a time                
                                   float f_ce=0,f_tps=0,f_gpa=0,f_result=0;
                                   String a,b,course_code_session = null,temp;
                                    int_course_code_index=4;
                                   a = res.getString("student_id");                                                       

                                   b = res.getString("student_name");
                                   
                                   result.processing.system.tabulationShit.resdata[j][0]=a; 
                                   result.processing.system.tabulationShit.resdata[j][1]=b; 
                                   System.out.println("   "+a+"     "+b);                                  
                                 // JOptionPane.showMessageDialog(null, "1");
                                  course_code_session=(result.processing.system.tabulationShit.t_theoryresult.getModel().getValueAt(0, 4)).toString();
                                  // JOptionPane.showMessageDialog(null, course_code_session);
                                   
                                  while(course_code_session.compareTo("")!=0)
                                  {
                                   //   JOptionPane.showMessageDialog(null, "2");
                                      String s_mo = null,s_lg = null,s_gp = null,s_ps = null;
                                     course_code_session=course_code_session+s1_session;
                                     ResultSet res1=st1.executeQuery("select * from "+course_code_session+" where student_id='"+a+"'");
                                     ///JOptionPane.showMessageDialog(null, "3");
                                     while(res1.next()==true)                                         
                                     {
                                         s_mo = res1.getString("mo");                                                       
                                         s_lg = res1.getString("lg");
                                         s_gp = res1.getString("gp");                                                       
                                         s_ps = res1.getString("ps");
                                         
                                        // JOptionPane.showMessageDialog(null, "4");
                                     }
                                     if(s_lg.compareTo("F")!=0)
                                     {
                                         temp=(result.processing.system.tabulationShit.t_theoryresult.getModel().getValueAt(1, int_course_code_index-1)).toString();
                                         temp=temp.substring(8, 9);
                                         f_ce+=Float.parseFloat(temp);
                                         f_tps+=Float.parseFloat(s_ps);
                                         //JOptionPane.showMessageDialog(null, temp);
                                     }
                                  result.processing.system.tabulationShit.resdata[j][int_course_code_index-2]=s_mo; 
                                  result.processing.system.tabulationShit.resdata[j][int_course_code_index-1]=s_lg;                                  
                                  result.processing.system.tabulationShit.resdata[j][int_course_code_index]=s_gp; 
                                  result.processing.system.tabulationShit.resdata[j][int_course_code_index+1]=s_ps;                                  
                                  //JOptionPane.showMessageDialog(null, "5");
                                  
                                  int_course_code_index+=4;
                                  if(int_course_code_index>49)
                                      break;
                                  course_code_session=(result.processing.system.tabulationShit.t_theoryresult.getModel().getValueAt(0, int_course_code_index)).toString();
                                  }
                                  result.processing.system.tabulationShit.resdata[j][50]=""+gl_credit; 
                                  result.processing.system.tabulationShit.resdata[j][51]=""+f_ce; 
                                  result.processing.system.tabulationShit.resdata[j][52]=""+f_tps; 
                                  f_gpa=f_tps/f_ce;
                                  result.processing.system.tabulationShit.resdata[j][53]=""+f_gpa; 
                                  temp=getlg(f_gpa);
                                  result.processing.system.tabulationShit.resdata[j][54]=temp; 
                                  ++j;
                                  d=j;
                               }
                            }
                            if(f==1)
                            {
                                ResultSet res = st.executeQuery("select * from t_session"+s1_session+" where student_id not like 'CE"+subsession+"%'  order by student_id asc");
                                //int j=0;                                
                               
                                while(res.next()==true)                                                                                                         
                               { // process results one row at a time                
                                   String a,b,course_code_session = null,temp;
                                    int_course_code_index=4;
                                   a = res.getString("student_id");                                                       
                                   b = res.getString("student_name");
                                   
                                   result.processing.system.tabulationShit.resdata[d][0]=a; 
                                   result.processing.system.tabulationShit.resdata[d][1]=b;                                  
                                  
                                  course_code_session=(result.processing.system.tabulationShit.t_theoryresult.getModel().getValueAt(0, 4)).toString();
                                  while(course_code_session.compareTo("")!=0)
                                  {
                                      String s_mo = null,s_lg = null,s_gp = null,s_ps = null;
                                     course_code_session=course_code_session+s1_session;
                                     ResultSet res1=st1.executeQuery("select * from "+course_code_session+" where student_id='"+a+"'");
                                     while(res1.next()==true)
                                     {
                                         s_mo = res1.getString("mo");                                                       
                                         s_lg = res1.getString("lg");
                                         s_gp = res1.getString("gp");                                                       
                                         s_ps = res1.getString("ps");
                                     }
                                     
                                  result.processing.system.tabulationShit.resdata[d][int_course_code_index-2]=s_mo; 
                                  result.processing.system.tabulationShit.resdata[d][int_course_code_index-1]=s_lg;                                  
                                  result.processing.system.tabulationShit.resdata[d][int_course_code_index]=s_gp; 
                                  result.processing.system.tabulationShit.resdata[d][int_course_code_index+1]=s_ps;                                  
                                  
                                  
                                  int_course_code_index+=4;
                                  if(int_course_code_index>49)
                                      break;
                                  course_code_session=(result.processing.system.tabulationShit.t_theoryresult.getModel().getValueAt(0, int_course_code_index)).toString();
                                  }
                                  result.processing.system.tabulationShit.resdata[d][50]=""+gl_credit; 
                                  
                               }
                            }
                          //System.out.println("yes");
                            
                        }
            }   
            catch(Exception ex1)
            {
                            System.out.println("yes..kmkm");                             
                                    // String s6="insert into temp_"+s_student_id+"_"+s_student_name+"_"+s_dormitory+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                                                     
                            // st.executeUpdate(s6);                              
                            System.out.println("yes..2222"); 
            }
                                                               
                                            
        }                  
        catch(Exception ex)        
        {        
            System.out.println("already table create..........ppp");            
        }      
    }

}