package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.swing.JOptionPane;

public class Db_Admin_Info 
{
    public void Admin_info_create(String s1_id,String s2_adminname,String s3_username,String s4_password)
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
                String s5 =("CREATE TABLE t_admin_info(admin_id varchar(20), admin_name varchar(50),username varchar(50),password varchar(50),constraint pk_admin_info primary key(admin_id,username))");                               
                st.executeUpdate(s5); 
                System.out.println("yes1");
                String s6="insert into t_admin_info(admin_id,admin_name,username,password)" + "values('"+s1_id+"','"+s2_adminname+"','"+s3_username+"','"+s4_password+"');";                                         
                st.executeUpdate(s6);
                System.out.println("yes2");
                //show_admin();
            }
            catch(Exception ex)
            {
                //show info
                String s6="insert into t_admin_info(admin_id,admin_name,username,password)" + "values('"+s1_id+"','"+s2_adminname+"','"+s3_username+"','"+s4_password+"');";                                         
                st.executeUpdate(s6);
                System.out.println("yesexep");
                //show_admin();                                 
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }      
    }
    
    public void show_admin()
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
                ResultSet res = st.executeQuery("select * from t_admin_info");
                String a,b;                            
                int j=0;                            
                int p,q;
                for(p=0;p<60;++p)                            
                {                
                    result.processing.system.ViewAllAdmin.StatusData[p][0]="";                                                      
                    result.processing.system.ViewAllAdmin.StatusData[p][1]="";                                                                
                }                
                while(res.next()==true)                                                                                                                         
                { // process results one row at a time 
                    int z=0,t=0;
                    String a1,a2,a3,a4,a5;
                    a = res.getString("admin_id");                                                                           
                    b = res.getString("admin_name");                                                                      
                    System.out.println("   "+a+"     "+b);                    
                    result.processing.system.ViewAllAdmin.StatusData[j][0]="Teacher ID";                     
                    result.processing.system.ViewAllAdmin.StatusData[j][1]=a;
                    result.processing.system.ViewAllAdmin.StatusData[j+1][0]="Teacher Name";                     
                    result.processing.system.ViewAllAdmin.StatusData[j+1][1]=b;
                    try
                    {
                        ResultSet res1=st1.executeQuery("select * from t_admin_course_"+a+"");
                        while(res1.next()==true)
                        {
                            //course_code,course_title,session,credit,type
                            a1=res1.getString("course_code");
                            a2=res1.getString("course_title");
                            a3=res1.getString("session");
                            a4=res1.getString("credit");
                            a5=res1.getString("type");
                            System.out.println(a5);
                            if(t==0)
                            {
                                result.processing.system.ViewAllAdmin.StatusData[j+2][0]="Assigned Courses"; 
                                t=1;
                            }
                            result.processing.system.ViewAllAdmin.StatusData[j+2][1]="Course Code: "+a1+"     Course Title: "+a2+"     Session: "+a3+"     Credit: "+a4+"      Type:"+a5;
                            ++j;
                        }
                    }
                    catch(Exception ex2)
                    {
                    }
                    j+=3;                  
                }
            }
            catch(Exception ex)
            {                                 
            }    
        }
        catch(Exception ex1)        
        {        
            System.out.println("already table create..........");            
        }          
    }    
    
    public void Admin_course_assign_table(String s1_id)
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
                String s2 =("CREATE TABLE t_admin_course_"+s1_id+"(course_code varchar(20), course_title varchar(50),session varchar(20),credit varchar(20),type varchar(20),constraint pk_admincourse primary key(course_code))");                               
                st.executeUpdate(s2);                                
                System.out.println("yes");
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
    
public void Admin_course_assign_insert(String s1_id,String s2_coursecode,String s3_coursetitle,String s4_session,String s5_credit,String s6_type)
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
               String s7="insert into t_admin_course_"+s1_id+"(course_code,course_title,session,credit,type)" + "values('"+s2_coursecode+"','"+s3_coursetitle+"','"+s4_session+"','"+s5_credit+"','"+s6_type+"');";                                         
               st.executeUpdate(s7);
            try                        
            {   
                String s2 =("CREATE TABLE speacalcheck(course_code varchar(20),constraint pk_speacalcheck primary key(course_code))");
                st.executeUpdate(s2);
                String s8="insert into speacalcheck(course_code)" + "values('"+s2_coursecode+"');";                                         
                st.executeUpdate(s8);
                System.out.println("yes Admin_course_assign_insert");
               // st.executeUpdate(s2);                                
                System.out.println("yes");
//                JOptionPane.showMessageDialog(null, "success...");
            }
            catch(Exception ex)
            {
                //JOptionPane.showMessageDialog(null, "");
                try
                {
                    String s8="insert into speacalcheck(course_code)" + "values('"+s2_coursecode+"');";                                         
                    st.executeUpdate(s8);
                    System.out.println("yes Admin_course_assign_insert");
                    //show info                
//                    JOptionPane.showMessageDialog(null, "success");
                }
                catch(Exception ex1)
                {
//                    JOptionPane.showMessageDialog(null, "no......");
                }
            }
                
            }
            catch(Exception ex)
            {
                //show info
                System.out.println("inner already table create Admin_course_assign_insert..........");                
            }       
           // Master_Admin_info(s1_id);
            Session_Course_Info(s4_session, s2_coursecode, s5_credit);
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create Admin_course_assign_insert..........");            
        }      
    }
 /*   public void Master_Admin_info(String s1_id)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","p.p");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
            try                        
            {
                String s2 =("CREATE TABLE mt_admininfo_"+s1_id+"(admininfo_table varchar(20),admincourse_table varchar(20),username varchar(20),password varchar(20))");                               
                st.executeUpdate(s2);                                
                               
                ResultSet res = st.executeQuery("select * from t_admin_info_"+s1_id+"");                                        
                String a = null,b = null;                               
                
                while(res.next()==true)                                                 
                { // process results one row at a time                   
                    a = res.getString("username");                                                       
                    b = res.getString("password");  
                    System.out.println("   "+a+"    "+b);
                }                     
                String s3="insert into mt_admininfo_"+s1_id+"(admininfo_table,admincourse_table,username,password)" + "values('t_admin_info_"+s1_id+"','t_admin_course_"+s1_id+"','"+a+"','"+b+"');";                                         
                st.executeUpdate(s3);
                System.out.println("yes");
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
    }*/
    
    public int AllCourse(String s1_Adminid,String s2_AdminName,String s3_Coursecode,String s4_Coursetitle)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
          //allcourse  
            try                        
            {
                String s2 =("CREATE TABLE allcourse(admin_id varchar(20),admin_name varchar(20),coursecode varchar(20),coursetitle varchar(70),constraint pk_allcourse primary key(coursecode))");                               
                st.executeUpdate(s2);                                                                             
            }
            catch(Exception ex)
            {                   
                System.out.println("exception yes table create.......");
            }
            try                        
            {                                                                             
                String s3="insert into allcourse(admin_id,admin_name,coursecode,coursetitle)" + "values('"+s1_Adminid+"','"+s2_AdminName+"','"+s3_Coursecode+"','"+s4_Coursetitle+"');";                                         
                st.executeUpdate(s3);
                System.out.println("yes");
                return 2;
            }
            catch(Exception ex)
            {   
                
                System.out.println("exception yes........");
                //show info
                System.out.println("inner already table create..........");
                return 1;
            }       
            
            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }
        return 5;
    }
    public void Session_Course_Info(String s2_session,String s3_coursecode,String s4_credit)
    {
        Connection conn = null;
        try        
        {       
            String sub = null;
            int i;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect Session_Course_Info");
            Statement st = conn.createStatement();
            try                        
            {
                for(i=0;i<s3_coursecode.length();++i)
                {
                    if(s3_coursecode.charAt(i)>='0'&&s3_coursecode.charAt(i)<='9')
                    {
                        break;
                    }
                }
                sub=s3_coursecode.substring(i, i+2);
                System.out.println(sub);
               // st.executeUpdate("drop table t_session_"+s2_session+"_"+sub+"");
                String s6 =("CREATE TABLE t_session_"+s2_session+"_"+sub+"(coursecode varchar(20),credit varchar(50),constraint pk_Session_Course_Info primary key(coursecode))");
                st.executeUpdate(s6);
                System.out.println("yes");
                String s5="insert into t_session_"+s2_session+"_"+sub+"(coursecode,credit)" + "values('"+s3_coursecode+""+s2_session+"','"+s4_credit+"');";                                         
                st.executeUpdate(s5);
                System.out.println("yes");
                   
                System.out.println("yes Session_Course_Info");
            }
            catch(Exception ex)
            {
                //show info
                System.out.println("inner already table create..........");
                
                String s5="insert into t_session_"+s2_session+"_"+sub+"(coursecode,credit)" + "values('"+s3_coursecode+""+s2_session+"','"+s4_credit+"');";                                         
                st.executeUpdate(s5);
                System.out.println(s2_session+" "+sub);
                ResultSet res = st.executeQuery("select * from t_session_"+s2_session+"_"+sub+"");                                        
                String a = null,b = null;                               
                
                while(res.next()==true)                                                 
                { // process results one row at a time                   
                    a = res.getString("coursecode");                                                       
                    b = res.getString("credit");  
                    System.out.println("   "+a+"    "+b+"  Session_Course_Info 420");
                }
                System.out.println("inner already table create........Session_Course_Info..");                
            }       
                        
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create.........Session_Course_Info.");            
        }      
    }
    
}