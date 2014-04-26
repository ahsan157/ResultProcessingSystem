/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class SelectedSessionStudentTable extends JFrame
{   
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
   
    String [] column= new String[]{"Student Id", "Student name", "select"};
    String [][] data=new String[30][3];
    
    JTable t_CourseList;
    JLabel l_ListOfAssignCourse;
    private JLabel l;
    JButton b_ListOfAssignCourseDone;
    String ts1_coursecode,ts2_session,ts3_adminid,ts4_type;       
    public SelectedSessionStudentTable(String s1_coursecode,String s2_session,String s3_admin_id,String s4_type) 
    {
        ts1_coursecode=s1_coursecode;
        ts2_session=s2_session;
        ts3_adminid=s3_admin_id;
        ts4_type=s4_type;
        
        int n=70;
        setBounds(420, 50, 480,620);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
        l_ListOfAssignCourse=new JLabel(image_home);
        l_ListOfAssignCourse.setSize(1000, 700);
        l_ListOfAssignCourse.setLayout(null);
        setContentPane(l_ListOfAssignCourse);
    
        l=new JLabel("Course Code: "+s1_coursecode+"  Student List");
        l.setBounds(10,20,600, 60);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_ListOfAssignCourse.add(l);         
        //SData = new String[n][3];
        
        /*...............................start Set Value from Session Table on temporary table...............................*/
        Connection conn = null;            
        try                
        {                
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");            
            int i=0;            
            System.out.println(" successfull connect");            
            Statement st = conn.createStatement();            
            
            try                                    
            {               
                ResultSet res = st.executeQuery("select * from t_session"+s2_session+"");                               
                while(res.next()==true)                                                                                                                         
                {                                                       
                    String a = res.getString("student_id");                                                                           
                    String b = res.getString("student_name");                    
                    System.out.println("   "+a+"     "+b+"\t");                     
                    data[i][0]=a;                      
                    data[i][1]=b;  
                    
                    ++i;                    
                }                            
                conn.close();
                //conn.close();                               
        }            
        catch(Exception ex)            
        {            
                //show info                
                System.out.println("lab_ex");                                                                
        } 
/*...............................end  Set Value from Session Table on temporary table...............................*/            
            
        DefaultTableModel model = new DefaultTableModel(data, column);
  
        
         t_CourseList= new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        t_CourseList.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_CourseList);
        t_CourseList.setFont(new Font("Arial", Font.BOLD, 13));
        t_CourseList.setRowHeight(20);
      
        
        JCheckBox jc_select = new JCheckBox();
        jc_select.setHorizontalAlignment(SwingConstants.CENTER);  
        jc_select.setBackground(Color.white);
 
        TableColumn c0 = t_CourseList.getColumnModel().getColumn(0);
        c0.setPreferredWidth(50);
        TableColumn c1 = t_CourseList.getColumnModel().getColumn(1);
        c1.setPreferredWidth(200);          
        TableColumn c2 = t_CourseList.getColumnModel().getColumn(2);
        c2.setPreferredWidth(1); 
        
        c2.setCellEditor(new DefaultCellEditor(jc_select));
        pane.setBounds(25, 70, 425, 420);
       
        l_ListOfAssignCourse.add(pane);                    
        b_ListOfAssignCourseDone=new JButton("Save");
        b_ListOfAssignCourseDone.setBounds(210, 500, 70,40);
        l_ListOfAssignCourse.add(b_ListOfAssignCourseDone);
        
                      
                }

            catch(Exception ex)        
            {        
                System.out.println(ex);            
            }
        
        b_ListOfAssignCourseDone.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
/*......................................start select your required student for project.................................................*/                
                if(ts4_type.compareTo("Project")==0)
                {
                    Connection conn = null;
                    try        
                    {        
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");

                        System.out.println(" successfull connect");
                        Statement st = conn.createStatement();
                       // Statement st1 = conn.createStatement();
                        try                        
                        {   
                            //st.executeUpdate("drop table temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");                
                            String s4 =("CREATE TABLE temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id varchar(20), student_name varchar(50),presentation varchar(20),project_viva varchar(20),mark_70 varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                            st.executeUpdate(s4);                                                                   

                           // ResultSet res = st.executeQuery("select * from t_session"+ts2_session+"");
                            String s1_getvalue,s2_getvalue,s3_getvalue;
                            
                            for(int j=0;j<20;++j)                                                                                                         
                            {   
                                try
                                {
                                    s1_getvalue=(t_CourseList.getModel().getValueAt(j, 0)).toString();
                                    s2_getvalue=(t_CourseList.getModel().getValueAt(j, 1)).toString();
                                    s3_getvalue=(t_CourseList.getModel().getValueAt(j, 2)).toString();

                                    if(s3_getvalue.compareTo("true")==0)
                                    {
                                        System.out.println("yes.."); 
                                        String s6="insert into temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                         
                                        st.executeUpdate(s6);  
                                        System.out.println("yes..111"); 
                                    }
                                }
                                catch(Exception ex)
                                {
                                    System.out.println("try......"); 
                                }
                            }
                               System.out.println("yug1"); 
                            ResultSet res = st.executeQuery("select * from temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");               
                                System.out.println("yes..222"); 
                            while(res.next()==true)                                                                                                         
                            {                               
                                System.out.println("yes..333"); 
                                    String a = res.getString("student_id");                                                       
                                    String b = res.getString("student_name");
                                    System.out.println("   "+a+"     "+b+"\t yes........."); 
                             }
                             conn.close();
                            System.out.println("yes1111");
                            //conn.close();

                        }
                        catch(Exception ex)
                        {
                            //show info
                           st.executeUpdate("drop table temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");                
                            String s4 =("CREATE TABLE temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id varchar(20), student_name varchar(50),presentation varchar(20),project_viva varchar(20),mark_70 varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                            st.executeUpdate(s4);                                                                   

                           // ResultSet res = st.executeQuery("select * from t_session"+ts2_session+"");
                            String s1_getvalue,s2_getvalue,s3_getvalue;
                            
                            for(int j=0;j<20;++j)                                                                                                         
                            {   
                                try
                                {
                                    s1_getvalue=(t_CourseList.getModel().getValueAt(j, 0)).toString();
                                    s2_getvalue=(t_CourseList.getModel().getValueAt(j, 1)).toString();
                                    s3_getvalue=(t_CourseList.getModel().getValueAt(j, 2)).toString();

                                    if(s3_getvalue.compareTo("true")==0)
                                    {
                                        System.out.println("yes.."); 
                                        String s6="insert into temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                         
                                        st.executeUpdate(s6);  
                                        System.out.println("yes..111"); 
                                    }
                                }
                                catch(Exception ex1)
                                {
                                    System.out.println("try......"); 
                                }
                            }
                               System.out.println("yug1"); 
                            ResultSet res = st.executeQuery("select * from temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");               
                                System.out.println("yes..222"); 
                            while(res.next()==true)                                                                                                         
                            {                               
                                System.out.println("yes..333"); 
                                    String a = res.getString("student_id");                                                       
                                    String b = res.getString("student_name");
                                    System.out.println("   "+a+"     "+b+"\t yes........."); 
                             }
                             conn.close();
                            System.out.println("lab_ex");

                        }            
                    }

                    catch(Exception ex)        
                    {        
                        System.out.println(ex);            
                    }
                }
/*......................................end select your required student for project.................................................*/                                
               
                
                
/*......................................start select your required student for thesis.................................................*/                                                
                if(ts4_type.compareTo("Thisis")==0)
                {
                    Connection conn = null;
                    try        
                    {        
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");

                        System.out.println(" successfull connect");
                        Statement st = conn.createStatement();
                       // Statement st1 = conn.createStatement();
                        try                        
                        {   
                            
                             String s4 =("CREATE TABLE temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id varchar(20), student_name varchar(50),internal varchar(20),external varchar(20),presentation varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))"); 
                            st.executeUpdate(s4);                                                                   

                           // ResultSet res = st.executeQuery("select * from t_session"+ts2_session+"");
                            String s1_getvalue,s2_getvalue,s3_getvalue;
                            
                            for(int j=0;j<20;++j)                                                                                                         
                            {   
                                try
                                {
                                    s1_getvalue=(t_CourseList.getModel().getValueAt(j, 0)).toString();
                                    s2_getvalue=(t_CourseList.getModel().getValueAt(j, 1)).toString();
                                    s3_getvalue=(t_CourseList.getModel().getValueAt(j, 2)).toString();

                                    if(s3_getvalue.compareTo("true")==0)
                                    {
                                        System.out.println("yes.."); 
                                        String s6="insert into temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                         
                                         st.executeUpdate(s6);  
                  
                                        System.out.println("yes..111"); 
                                    }
                                }
                                catch(Exception ex)
                                {
                                    System.out.println("try......"); 
                                }
                            }
                               System.out.println("yug1"); 
                            ResultSet res = st.executeQuery("select * from temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");               
                                System.out.println("yes..222"); 
                            while(res.next()==true)                                                                                                         
                            {                               
                                System.out.println("yes..333"); 
                                    String a = res.getString("student_id");                                                       
                                    String b = res.getString("student_name");
                                    System.out.println("   "+a+"     "+b+"\t yes........."); 
                             }
                                                                       
                            System.out.println("yes1111");
                            //conn.close();

                        }
                        catch(Exception ex)
                        {
                            //show info
                              
                            st.executeUpdate("drop table temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");                
                             String s4 =("CREATE TABLE temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id varchar(20), student_name varchar(50),internal varchar(20),external varchar(20),presentation varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))"); 
                            st.executeUpdate(s4);                                                                   

                           // ResultSet res = st.executeQuery("select * from t_session"+ts2_session+"");
                            String s1_getvalue,s2_getvalue,s3_getvalue;
                            
                            for(int j=0;j<20;++j)                                                                                                         
                            {   
                                try
                                {
                                    s1_getvalue=(t_CourseList.getModel().getValueAt(j, 0)).toString();
                                    s2_getvalue=(t_CourseList.getModel().getValueAt(j, 1)).toString();
                                    s3_getvalue=(t_CourseList.getModel().getValueAt(j, 2)).toString();

                                    if(s3_getvalue.compareTo("true")==0)
                                    {
                                        System.out.println("yes.."); 
                                        String s6="insert into temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+s1_getvalue+"','"+s2_getvalue+"','','','','','','','','');";                                         
                                         st.executeUpdate(s6);  
                  
                                        System.out.println("yes..111"); 
                                    }
                                }
                                catch(Exception ex1)
                                {
                                    System.out.println("try......"); 
                                }
                            }
                               System.out.println("yug1"); 
                            ResultSet res = st.executeQuery("select * from temp_"+ts1_coursecode+"_"+ts2_session+"_"+ts3_adminid+"");               
                                System.out.println("yes..222"); 
                            while(res.next()==true)                                                                                                         
                            {                               
                                System.out.println("yes..333"); 
                                    String a = res.getString("student_id");                                                       
                                    String b = res.getString("student_name");
                                    System.out.println("   "+a+"     "+b+"\t yes........."); 
                             }
                             
                            System.out.println("lab_ex");

                        }            
                    }

                    catch(Exception ex)        
                    {        
                        System.out.println(ex);            
                    }
                }
                setVisible(false);
/*......................................end select your required student for thesis.................................................*/                
            }
        }
        );
    }
    
}
