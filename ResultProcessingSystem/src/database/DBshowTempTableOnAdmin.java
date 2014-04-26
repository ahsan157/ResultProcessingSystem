
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.swing.JOptionPane;

public class DBshowTempTableOnAdmin 
{    
    public void studentcougseShow(String s1_coursecode,String s2_session,String s3_admin_id)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s_table; 

            Statement st = conn.createStatement();
            s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
            ResultSet res = st.executeQuery("select * from "+s_table+"");
            int i=0;
            //student_id,student_name,,,,,,,,,,,credit,ps
            for(int j=0;j<70;++j)
            {
                
                result.processing.system.AdminViewerInfo.resdata[j][0]="";                
                result.processing.system.AdminViewerInfo.resdata[j][1]="";
                result.processing.system.AdminViewerInfo.resdata[j][2]="";                
                result.processing.system.AdminViewerInfo.resdata[j][3]="";
                result.processing.system.AdminViewerInfo.resdata[j][4]="";                
                result.processing.system.AdminViewerInfo.resdata[j][5]="";
                result.processing.system.AdminViewerInfo.resdata[j][6]="";                
                result.processing.system.AdminViewerInfo.resdata[j][7]="";
                result.processing.system.AdminViewerInfo.resdata[j][8]="";                
                result.processing.system.AdminViewerInfo.resdata[j][9]="";
                result.processing.system.AdminViewerInfo.resdata[j][10]="";                
                result.processing.system.AdminViewerInfo.resdata[j][11]="";
            }
                while(res.next()==true)                                                                                                         
                {                                       
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    String c = res.getString("class_test");
                    String d = res.getString("attendence");
                    String e = res.getString("tctam");
                    String f = res.getString("internal");
                    String g = res.getString("external");
                    String h = res.getString("third_examiner");
                    String j = res.getString("avg");
                    String k = res.getString("mo");
                    String l = res.getString("gp");
                    String m = res.getString("lg");
                    System.out.println("   "+a+"     "+b+"\t"); 
                    result.processing.system.AdminViewerInfo.resdata[i][0]=a;
                    result.processing.system.AdminViewerInfo.resdata[i][1]=b;                    
                    result.processing.system.AdminViewerInfo.resdata[i][2]=c;                
                    result.processing.system.AdminViewerInfo.resdata[i][3]=d;
                    result.processing.system.AdminViewerInfo.resdata[i][4]=e;                
                    result.processing.system.AdminViewerInfo.resdata[i][5]=f;
                    result.processing.system.AdminViewerInfo.resdata[i][6]=g;                
                    result.processing.system.AdminViewerInfo.resdata[i][7]=h;
                    result.processing.system.AdminViewerInfo.resdata[i][8]=j;                
                    result.processing.system.AdminViewerInfo.resdata[i][9]=k;
                    result.processing.system.AdminViewerInfo.resdata[i][10]=l;                
                    result.processing.system.AdminViewerInfo.resdata[i][11]=m;
                    System.out.println(a+"   "+b);
                    ++i;
                }
                try
                {
                    s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                    ResultSet res1 = st.executeQuery("select * from "+s_table+"_bl");
                    while(res1.next()==true)                                                                                                         
                    {                                       
                        String a = res1.getString("student_id");                                                       
                        String b = res1.getString("student_name");
                        String c = res1.getString("class_test");
                        String d = res1.getString("attendence");
                        String e = res1.getString("tctam");
                        String f = res1.getString("internal");
                        String g = res1.getString("external");
                        String h = res1.getString("third_examiner");
                        String j = res1.getString("avg");
                        String k = res1.getString("mo");
                        String l = res1.getString("gp");
                        String m = res1.getString("lg");
                        System.out.println("   "+a+"     "+b+"\t"); 
                        result.processing.system.AdminViewerInfo.resdata[i][0]=a;
                        result.processing.system.AdminViewerInfo.resdata[i][1]=b;                    
                        result.processing.system.AdminViewerInfo.resdata[i][2]=c;                
                        result.processing.system.AdminViewerInfo.resdata[i][3]=d;
                        result.processing.system.AdminViewerInfo.resdata[i][4]=e;                
                        result.processing.system.AdminViewerInfo.resdata[i][5]=f;
                        result.processing.system.AdminViewerInfo.resdata[i][6]=g;                
                        result.processing.system.AdminViewerInfo.resdata[i][7]=h;
                        result.processing.system.AdminViewerInfo.resdata[i][8]=j;                
                        result.processing.system.AdminViewerInfo.resdata[i][9]=k;
                        result.processing.system.AdminViewerInfo.resdata[i][10]=l;                
                        result.processing.system.AdminViewerInfo.resdata[i][11]=m;
                        System.out.println(a+"   "+b);
                        ++i;
                    }
                }
                catch(Exception ex)
                {
                    
                }
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    
    public void studentcougseShowLab(String s1_coursecode,String s2_session,String s3_admin_id)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s_table; 

            Statement st = conn.createStatement();
            s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
            ResultSet res = st.executeQuery("select * from "+s_table+"");
            int i=0;
            //student_id,student_name,,,,,,,,,,,credit,ps
            for(int j=0;j<70;++j)
            {
                
                result.processing.system.AdminViewerInfo.resdatalab[j][0]="";                
                result.processing.system.AdminViewerInfo.resdatalab[j][1]="";
                result.processing.system.AdminViewerInfo.resdatalab[j][2]="";                
                result.processing.system.AdminViewerInfo.resdatalab[j][3]="";
                result.processing.system.AdminViewerInfo.resdatalab[j][4]="";                
                result.processing.system.AdminViewerInfo.resdatalab[j][5]="";
                result.processing.system.AdminViewerInfo.resdatalab[j][6]="";                
                result.processing.system.AdminViewerInfo.resdatalab[j][7]="";
            }
                while(res.next()==true)                                                                                                         
                { 
//(student_id varchar(20), student_name varchar(50),lab_quiz varchar(20),lab_viva varchar(20),lab_final varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");
                    
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    String c = res.getString("lab_quiz");
                    String d = res.getString("lab_viva");
                    String e = res.getString("lab_final");
                    String f = res.getString("mo");
                    String g = res.getString("gp");
                    String h = res.getString("lg");
                    System.out.println("   "+a+"     "+b+"\t"); 
                    result.processing.system.AdminViewerInfo.resdatalab[i][0]=a;
                    result.processing.system.AdminViewerInfo.resdatalab[i][1]=b;                    
                    result.processing.system.AdminViewerInfo.resdatalab[i][2]=c;                
                    result.processing.system.AdminViewerInfo.resdatalab[i][3]=d;
                    result.processing.system.AdminViewerInfo.resdatalab[i][4]=e;                
                    result.processing.system.AdminViewerInfo.resdatalab[i][5]=f;
                    result.processing.system.AdminViewerInfo.resdatalab[i][6]=g;                
                    result.processing.system.AdminViewerInfo.resdatalab[i][7]=h;
                    System.out.println(a+"   "+b);
                    ++i;
                }
                try
                {
                    s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                    ResultSet res1 = st.executeQuery("select * from "+s_table+"_bl");
                    while(res1.next()==true)                                                                                                         
                    {                                       
                        String a = res.getString("student_id");                                                       
                        String b = res.getString("student_name");
                        String c = res.getString("lab_quiz");
                        String d = res.getString("lab_viva");
                        String e = res.getString("lab_final");
                        String f = res.getString("mo");
                        String g = res.getString("gp");
                        String h = res.getString("lg");
                        System.out.println("   "+a+"     "+b+"\t"); 
                        result.processing.system.AdminViewerInfo.resdatalab[i][0]=a;
                        result.processing.system.AdminViewerInfo.resdatalab[i][1]=b;                    
                        result.processing.system.AdminViewerInfo.resdatalab[i][2]=c;                
                        result.processing.system.AdminViewerInfo.resdatalab[i][3]=d;
                        result.processing.system.AdminViewerInfo.resdatalab[i][4]=e;                
                        result.processing.system.AdminViewerInfo.resdatalab[i][5]=f;
                        result.processing.system.AdminViewerInfo.resdatalab[i][6]=g;                
                        result.processing.system.AdminViewerInfo.resdatalab[i][7]=h;
                        System.out.println(a+"   "+b);
                        ++i;
                    }
                }
                catch(Exception ex)
                {
                    
                }
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    
    public void studentcougseShowProject(String s1_coursecode,String s2_session,String s3_admin_id)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s_table; 

            Statement st = conn.createStatement();
            s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
            ResultSet res = st.executeQuery("select * from "+s_table+"");
            int i=0;
            //student_id,student_name,,,,,,,,,,,credit,ps
            for(int j=0;j<70;++j)
            {
                
                result.processing.system.AdminViewerInfo.resdataproject[j][0]="";                
                result.processing.system.AdminViewerInfo.resdataproject[j][1]="";
                result.processing.system.AdminViewerInfo.resdataproject[j][2]="";                
                result.processing.system.AdminViewerInfo.resdataproject[j][3]="";
                result.processing.system.AdminViewerInfo.resdataproject[j][4]="";                
                result.processing.system.AdminViewerInfo.resdataproject[j][5]="";
                result.processing.system.AdminViewerInfo.resdataproject[j][6]="";                
                result.processing.system.AdminViewerInfo.resdataproject[j][7]="";
            }
                while(res.next()==true)                                                                                                         
                { 
//(student_id varchar(20), student_name varchar(50),lab_quiz varchar(20),lab_viva varchar(20),lab_final varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");
//(student_id varchar(20), student_name varchar(50),presentation varchar(20),project_viva varchar(20),mark_70 varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))                    
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    String c = res.getString("presentation");
                    String d = res.getString("project_viva");
                    String e = res.getString("mark_70");
                    String f = res.getString("mo");
                    String g = res.getString("gp");
                    String h = res.getString("lg");
                    System.out.println("   "+a+"     "+b+"\t"); 
                    result.processing.system.AdminViewerInfo.resdataproject[i][0]=a;
                    result.processing.system.AdminViewerInfo.resdataproject[i][1]=b;                    
                    result.processing.system.AdminViewerInfo.resdataproject[i][2]=c;                
                    result.processing.system.AdminViewerInfo.resdataproject[i][3]=d;
                    result.processing.system.AdminViewerInfo.resdataproject[i][4]=e;                
                    result.processing.system.AdminViewerInfo.resdataproject[i][5]=f;
                    result.processing.system.AdminViewerInfo.resdataproject[i][6]=g;                
                    result.processing.system.AdminViewerInfo.resdataproject[i][7]=h;
                    System.out.println(a+"   "+b);
                    ++i;
                }
                try
                {
                    s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                    ResultSet res1 = st.executeQuery("select * from "+s_table+"_bl");
                    while(res1.next()==true)                                                                                                         
                    {                                       
                        String a = res.getString("student_id");                                                       
                        String b = res.getString("student_name");
                        String c = res.getString("presentation");
                        String d = res.getString("project_viva");
                        String e = res.getString("mark_70");
                        String f = res.getString("mo");
                        String g = res.getString("gp");
                        String h = res.getString("lg");
                        System.out.println("   "+a+"     "+b+"\t"); 
                        result.processing.system.AdminViewerInfo.resdataproject[i][0]=a;
                        result.processing.system.AdminViewerInfo.resdataproject[i][1]=b;                    
                        result.processing.system.AdminViewerInfo.resdataproject[i][2]=c;                
                        result.processing.system.AdminViewerInfo.resdataproject[i][3]=d;
                        result.processing.system.AdminViewerInfo.resdataproject[i][4]=e;                
                        result.processing.system.AdminViewerInfo.resdataproject[i][5]=f;
                        result.processing.system.AdminViewerInfo.resdataproject[i][6]=g;                
                        result.processing.system.AdminViewerInfo.resdataproject[i][7]=h;
                        System.out.println(a+"   "+b);
                        ++i;
                    }
                }
                catch(Exception ex)
                {
                    
                }
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    
     public void studentcougseShowThesis(String s1_coursecode,String s2_session,String s3_admin_id)
    {
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s_table; 

            Statement st = conn.createStatement();
            s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
            ResultSet res = st.executeQuery("select * from "+s_table+"");
            int i=0;
            //student_id,student_name,,,,,,,,,,,credit,ps
            for(int j=0;j<70;++j)
            {
                
                result.processing.system.AdminViewerInfo.resdatathesis[j][0]="";                
                result.processing.system.AdminViewerInfo.resdatathesis[j][1]="";
                result.processing.system.AdminViewerInfo.resdatathesis[j][2]="";                
                result.processing.system.AdminViewerInfo.resdatathesis[j][3]="";
                result.processing.system.AdminViewerInfo.resdatathesis[j][4]="";                
                result.processing.system.AdminViewerInfo.resdatathesis[j][5]="";
                result.processing.system.AdminViewerInfo.resdatathesis[j][6]="";                
                result.processing.system.AdminViewerInfo.resdatathesis[j][7]="";
            }
                while(res.next()==true)                                                                                                         
                { 
//(student_id varchar(20), student_name varchar(50),lab_quiz varchar(20),lab_viva varchar(20),lab_final varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");
//student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps                    
                    String a = res.getString("student_id");                                                       
                    String b = res.getString("student_name");
                    String c = res.getString("internal");
                    String d = res.getString("external");
                    String e = res.getString("presentation");
                    String f = res.getString("mo");
                    String g = res.getString("gp");
                    String h = res.getString("lg");
                    System.out.println("   "+a+"     "+b+"\t"); 
                    result.processing.system.AdminViewerInfo.resdatathesis[i][0]=a;
                    result.processing.system.AdminViewerInfo.resdatathesis[i][1]=b;                    
                    result.processing.system.AdminViewerInfo.resdatathesis[i][2]=c;                
                    result.processing.system.AdminViewerInfo.resdatathesis[i][3]=d;
                    result.processing.system.AdminViewerInfo.resdatathesis[i][4]=e;                
                    result.processing.system.AdminViewerInfo.resdatathesis[i][5]=f;
                    result.processing.system.AdminViewerInfo.resdatathesis[i][6]=g;                
                    result.processing.system.AdminViewerInfo.resdatathesis[i][7]=h;
                    System.out.println(a+"   "+b);
                    ++i;
                }
                try
                {
                    s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                    ResultSet res1 = st.executeQuery("select * from "+s_table+"_bl");
                    while(res1.next()==true)                                                                                                         
                    {                                       
                        String a = res.getString("student_id");                                                       
                        String b = res.getString("student_name");
                        String c = res.getString("internal");
                        String d = res.getString("external");
                        String e = res.getString("presentation");
                        String f = res.getString("mo");
                        String g = res.getString("gp");
                        String h = res.getString("lg");
                        System.out.println("   "+a+"     "+b+"\t"); 
                        result.processing.system.AdminViewerInfo.resdatathesis[i][0]=a;
                        result.processing.system.AdminViewerInfo.resdatathesis[i][1]=b;                    
                        result.processing.system.AdminViewerInfo.resdatathesis[i][2]=c;                
                        result.processing.system.AdminViewerInfo.resdatathesis[i][3]=d;
                        result.processing.system.AdminViewerInfo.resdatathesis[i][4]=e;                
                        result.processing.system.AdminViewerInfo.resdatathesis[i][5]=f;
                        result.processing.system.AdminViewerInfo.resdatathesis[i][6]=g;                
                        result.processing.system.AdminViewerInfo.resdatathesis[i][7]=h;
                        System.out.println(a+"   "+b);
                        ++i;
                    }
                }
                catch(Exception ex)
                {
                    
                }
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    //Student ID", "","", "","", "",
     
                       // "", "","", "","", ""
    public void adminTruncate(String courseCode,String session,String adminID)
    {
        
        Connection conn = null;
        try        
        {                 
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                    st.executeUpdate("truncate table "+s_table+"");
                
                s_table=""+s1_coursecode+""+s2_session+"";
                    st.executeUpdate("truncate table "+s_table+"");
                
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"_bl";
                    st.executeUpdate("truncate table "+s_table+"");
                 
            }
            catch(Exception ex)
            {
//                JOptionPane.showMessageDialog(null, "no...");
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    
    public void adminTheoryInsertRegular(String courseCode,String session,String adminID,String StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+ClassTest+"','"+Attendence+"','"+Total30+"','"+Internal+"','"+External+"','"+ThirdExaminar+"','"+Avarage+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);
  //               JOptionPane.showMessageDialog(null, "yes.....");
            }
            catch(Exception ex)
            {
    //            JOptionPane.showMessageDialog(null, "no...");
            }
            
            try
            {
                s_table=""+s1_coursecode+""+s2_session+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                if(StudentID.length()==7||StudentID.length()==15) 
                {
                    String s6="insert into "+s_table+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+ClassTest+"','"+Attendence+"','"+Total30+"','"+Internal+"','"+External+"','"+ThirdExaminar+"','"+Avarage+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                    st.executeUpdate(s6);
                }
      //           JOptionPane.showMessageDialog(null, "yes.....");
            }
            catch(Exception ex)
            {
//                JOptionPane.showMessageDialog(null, "no...");
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    public void adminTheoryInsertBL_Special(String courseCode,String session,String adminID,String StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"_bl";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+ClassTest+"','"+Attendence+"','"+Total30+"','"+Internal+"','"+External+"','"+ThirdExaminar+"','"+Avarage+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);  
            }
            catch(Exception ex)
            {
                
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
                                                                                                                //student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps
    public void adminLabInsertRegular(String courseCode,String session,String adminID,String StudentID,String StudentName,String lab_quiz,String lab_viva,String lab_final,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+lab_quiz+"','"+lab_viva+"','"+lab_final+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);
                                  
            }
            catch(Exception ex)
            {
    //            JOptionPane.showMessageDialog(null, "no...");
            }
            
            try
            {
                s_table=""+s1_coursecode+""+s2_session+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                if(StudentID.length()==7||StudentID.length()==15) 
                {
                    String s6="insert into "+s_table+"(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+lab_quiz+"','"+lab_viva+"','"+lab_final+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                     st.executeUpdate(s6);
                }
      //          JOptionPane.showMessageDialog(null, "yes.....");
            }
            catch(Exception ex)
            {
  //              JOptionPane.showMessageDialog(null, "no...");
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    public void adminLabInsertBL_Special(String courseCode,String session,String adminID,String StudentID,String StudentName,String lab_quiz,String lab_viva,String lab_final,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
           String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"_bl";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+lab_quiz+"','"+lab_viva+"','"+lab_final+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);  
            }
            catch(Exception ex)
            {
                
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
                                                                                                                        //student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps
    public void adminProjectInsertRegular(String courseCode,String session,String adminID,String StudentID,String StudentName,String presentation,String project_viva,String mark_70,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 
                String s6="insert into "+s_table+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+presentation+"','"+project_viva+"','"+mark_70+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);
    //             JOptionPane.showMessageDialog(null, "yes.....");
            }
            catch(Exception ex)
            {
      //          JOptionPane.showMessageDialog(null, "no...");
            }
            
            try
            {
                s_table=""+s1_coursecode+""+s2_session+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 if(StudentID.length()==7||StudentID.length()==15) 
                 {
                    String s6="insert into "+s_table+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+presentation+"','"+project_viva+"','"+mark_70+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                    st.executeUpdate(s6);                 
                 }
        //         JOptionPane.showMessageDialog(null, "yes.....");
            }
            catch(Exception ex)
            {
          //      JOptionPane.showMessageDialog(null, "no...");
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    public void adminProjectInsertBL_Special(String courseCode,String session,String adminID,String StudentID,String StudentName,String presentation,String project_viva,String mark_70,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"_bl";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+presentation+"','"+project_viva+"','"+mark_70+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);  
            }
            catch(Exception ex)
            {
                
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
                                                                                                                        //student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps
    public void adminThesisInsertRegular(String courseCode,String session,String adminID,String StudentID,String StudentName,String Internal,String External,String presentation,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+Internal+"','"+External+"','"+presentation+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);
//                 JOptionPane.showMessageDialog(null, "hoiseito.............:)..:):-)yes.....");
            }
            catch(Exception ex)
            {
  //              JOptionPane.showMessageDialog(null, "no...");
            }
            
            try
            {
                s_table=""+s1_coursecode+""+s2_session+"";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                if(StudentID.length()==7||StudentID.length()==15) 
                {
                    String s6="insert into "+s_table+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+Internal+"','"+External+"','"+presentation+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                    st.executeUpdate(s6);
                }
    //            JOptionPane.showMessageDialog(null, "hoiseito.............:)..:):-)yes.....");
            }
            catch(Exception ex)
            {
      //          JOptionPane.showMessageDialog(null, "no...");
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    public void adminThesisInsertBL_Special(String courseCode,String session,String adminID,String StudentID,String StudentName,String Internal,String External,String presentation,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
    {
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println("Successfully connect");
            String s1_coursecode=courseCode,s2_session=session,s3_admin_id=adminID,s_table; 

            Statement st = conn.createStatement();
            try
            {
                s_table="temp_"+s1_coursecode+"_"+s2_session+"_"+s3_admin_id+"_bl";
                int i=0;
                            //StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                 String s6="insert into "+s_table+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+StudentID+"','"+StudentName+"','"+Internal+"','"+External+"','"+presentation+"','"+MarkObtained+"','"+GradePoint+"','"+LetterGrade+"','"+credit+"','"+ps+"');";
                 st.executeUpdate(s6);  
            }
            catch(Exception ex)
            {
                
            }
            //student_id,student_name,,,,,,,,,,,credit,ps
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception");
        }
    }
    
    
}
