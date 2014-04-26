package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class listOfBacklog extends JFrame
{
    
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private String column[] = {"Student Id", "Session"};
    public static String StatusData[][];
    JTable t_listOfBacklog;
    JLabel l_listOfBacklog;
    private String s_session,s_admin_id,s_course_code,s_row_number,s_st_id_bl,s_st_name_bl,s_type;
    private JLabel l,l1,l2;
    JButton b_listOfBacklogDone;
    int n;
    public listOfBacklog(String s_ccode,String s_rnum,String s_adid) 
    {
        s_course_code=s_ccode;
        s_row_number=s_rnum;
        s_admin_id=s_adid;
        n=0;
        for(int p=0;p<s_row_number.length();p++)
        {
            n=n*10+(s_row_number.charAt(p)-'0');
        }
        System.out.println(n);
        setBounds(380, 100, 500,550);
        setLayout(null);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
        l_listOfBacklog=new JLabel(image_home);
        l_listOfBacklog.setSize(1000, 700);
        l_listOfBacklog.setLayout(null);
        setContentPane(l_listOfBacklog);

        l=new JLabel("BackLog Student List");
        l.setBounds(140,40,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_listOfBacklog.add(l);
        
        l1=new JLabel("Course Code: ");
        l1.setBounds(10,10,140, 30);
        l1.setFont(new Font("Arial", Font.ITALIC, 20));
        l1.setForeground(Color.WHITE);
        l1.setLayout(null);
        l_listOfBacklog.add(l1);
        
        l2=new JLabel(s_course_code);
        l2.setBounds(150,10,300, 30);
        l2.setFont(new Font("Arial", Font.ITALIC, 19));
        l2.setForeground(Color.WHITE);
        l2.setLayout(null);
        l_listOfBacklog.add(l2);
        
        StatusData = new String[n][2];
        t_listOfBacklog= new JTable(StatusData, column);
        t_listOfBacklog.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_listOfBacklog);
        t_listOfBacklog.setFont(new Font("Arial", Font.BOLD, 13));
        t_listOfBacklog.setRowHeight(20);
        
        TableColumn c0 = t_listOfBacklog.getColumnModel().getColumn(0);
        c0.setPreferredWidth(50);
        TableColumn c1 = t_listOfBacklog.getColumnModel().getColumn(1);            
        c1.setPreferredWidth(150);          
        
        if(n<=9)
        pane.setBounds(25, 80, 425, (43+(20*(n-1))));
        else
            pane.setBounds(25, 80, 425,223);
        l_listOfBacklog.add(pane);                    
        b_listOfBacklogDone=new JButton("Done");
        b_listOfBacklogDone.setBounds(210, 355, 70,40);
        l_listOfBacklog.add(b_listOfBacklogDone);
        
        b_listOfBacklogDone.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Connection conn = null;
                try                        
                {        
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");            
                    System.out.println(" successfull connect"); 
                    JOptionPane.showMessageDialog(null, "1");
                    Statement st = conn.createStatement(); 
                    String a = null,b=null;
                    try
                    {
                        ResultSet res = st.executeQuery("select * from allcourse where coursecode='"+s_course_code+"';");
                        
                        while(res.next()==true)                                                                                                         
                        {                                       
                             a = res.getString("admin_id");
                             System.out.println("   "+a+"\t");
                             s_admin_id=a;
                        }          
                        
                    }                    
                    catch(Exception e2)
                    {
                        
                    }
//                    JOptionPane.showMessageDialog(null, s_admin_id+"2");
                    System.out.println(s_admin_id);
                    
                    ResultSet res = st.executeQuery("select * from t_admin_course_"+s_admin_id+" where course_code = '"+s_course_code+"';" );                    
                    while(res.next()==true)                                                                                                         
                    {                                       
                         a = res.getString("session");
                         b=res.getString("type");
                         System.out.println("   "+a+"\t"+b); 
                    }
                    s_session=a;
                    s_type=b;
//                    JOptionPane.showMessageDialog(null, s_session+"  "+s_type+"  "+s_admin_id+"   "+s_course_code);
                    /*if(s_type.compareTo("Theory")==0)
                        new database.DB_CreateBL_SP().BL_SP__theory_table(s_course_code, s_session, s_admin_id);
                    if(s_type.compareTo("Lab")==0)
                        new database.DB_CreateBL_SP().BL_SP__Lab_table(s_course_code, s_session, s_admin_id);
                    if(s_type.compareTo("Project")==0)
                        new database.DB_CreateBL_SP().BL_SP__Project_table(s_course_code, s_session, s_admin_id);
                    if(s_type.compareTo("Thisis")==0)
                        new database.DB_CreateBL_SP().BL_SP__thesis_table(s_course_code, s_session, s_admin_id);*/
                    
                    try
                    {
                        if(s_type.compareTo("Theory")==0)
                        {
                            try
                            {

                                String s4 =("CREATE TABLE temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id varchar(20), student_name varchar(50),class_test varchar(20),attendence varchar(20),tctam varchar(20),internal varchar(20),external varchar(20),third_examiner varchar(20),avg varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                                st.executeUpdate(s4);
                            }
                            catch(Exception e2)
                            {
                                
                            }
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString();
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"   yes..111   "+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','','','','','');";                                         
                                    st.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex1)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }
                        else
                        {
                            try
                            {
                                 String s4 =("CREATE TABLE temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id varchar(20), student_name varchar(50),lab_quiz varchar(20),lab_viva varchar(20),lab_final varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                                 st.executeUpdate(s4);                            
                            }
                            catch(Exception e2)
                            {
                                
                            }
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                    st.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex1)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }
                        
                    }
                    catch(Exception es2)
                    {
                        if(s_type.compareTo("Theory")==0)
                        {                            
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','','','','','');";                                         
                                    st.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex3)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }
                        else
                        {
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                    st.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex3)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }
                    }
                 }
                 catch(Exception ex)
                 {
                     try
                     {
                        Statement st1 = conn.createStatement();
                        System.out.println("exp allcoures"); 
                        ResultSet res = st1.executeQuery("select * from t_admin_course_"+s_admin_id+" where course_code = '"+s_course_code+"';");
                        String a=null;
                        while(res.next()==true)                                                                                                         
                        {                                       
                         a = res.getString("session");
                         System.out.println("   "+a); 
                        }          
                        s_session=a;
                        
                        if(s_course_code.compareTo("CSE2112")==0 || s_course_code.compareTo("CSE3116")==0)
                        {
                            try
                            {
                                String s4 =("CREATE TABLE temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id varchar(20), student_name varchar(50),presentation varchar(20),project_viva varchar(20),mark_70 varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                                st1.executeUpdate(s4); 
                            }
                            catch(Exception e2)
                            {
                                
                            }
                            
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                    st1.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex3)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }
                        else
                        {
                            try
                            {
                                 String s4 =("CREATE TABLE temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id varchar(20), student_name varchar(50),internal varchar(20),external varchar(20),presentation varchar(20),mo varchar(20),gp varchar(20),lg varchar(20),credit varchar(20),ps varchar(20))");                               
                                st1.executeUpdate(s4);
                            }
                            catch(Exception e2)
                            {
                                
                            }
                            
                            for(int j=0;j<n;++j)                                                                                                                                     
                            {                   
                                try                    
                                {                    
                                    s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                    s_st_id_bl=s_st_id_bl+"(bl)";
                                    s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                    System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                    String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                    st1.executeUpdate(s5);
                                    System.out.println("yes...22222");
                                }                    
                                catch(Exception ex3)                    
                                {   
                                    System.out.println("try.....null");                         
                                }                    
                            }
                        }                        
                     }
                     catch(Exception ex4)
                     {
                         try
                         {
                            Statement st2 = conn.createStatement();
                                                  
                            if(s_course_code.compareTo("CSE2112")==0 || s_course_code.compareTo("CSE3116")==0)
                            {                            
                               for(int j=0;j<n;++j)                                                                                                                                     
                               {                   
                                   try                    
                                   {                    
                                       s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                       s_st_id_bl=s_st_id_bl+"(bl)";
                                       s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                       System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                       String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                       st2.executeUpdate(s5);
                                       System.out.println("yes...22222");
                                   }                    
                                   catch(Exception ex3)                    
                                   {   
                                       System.out.println("try.....null");                         
                                   }                    
                               }
                           }
                            else
                            {
                                for(int j=0;j<n;++j)                                                                                                                                     
                                {                   
                                    try                    
                                    {                    
                                        s_st_id_bl=(t_listOfBacklog.getModel().getValueAt(j, 0)).toString(); 
                                        s_st_id_bl=s_st_id_bl+"(bl)";
                                        s_st_name_bl=(t_listOfBacklog.getModel().getValueAt(j, 1)).toString();
                                        System.out.println(s_st_id_bl+"yes..111"+s_st_name_bl);
                                        String s5="insert into temp_"+s_course_code+"_"+s_session+"_"+s_admin_id+"_bl(student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps)" + "values('"+s_st_id_bl+"','"+s_st_name_bl+"','','','','','','','','');";                                         
                                        st2.executeUpdate(s5);
                                        System.out.println("yes...22222");
                                    }                    
                                    catch(Exception ex3)                    
                                    {   
                                        System.out.println("try.....null");                         
                                    }                    
                                }
                            }
                     }
                     catch(Exception ex5)
                     {}
                    }
                                         
                 }       
                JOptionPane.showMessageDialog(null,"Successfully Saved");
                setVisible(false);
            }
        });
    }    
}
