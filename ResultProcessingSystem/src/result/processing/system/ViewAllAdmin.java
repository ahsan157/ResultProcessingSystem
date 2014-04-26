package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import static result.processing.system.StudentList.StatusData;
import static result.processing.system.StudentList.t_studentList;

public class ViewAllAdmin extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    private String column[] = {"Info","Description"};
    public static String StatusData[][];
    JTable t_ViewAllAdmin;
    JLabel l_ViewAllAdmin;
    private JLabel l;
    JButton b_ViewAllAdminDone,b_AddNewAdmin,b_AssignCourse,b_delete,b_delete_admin;
    ViewAllAdmin ob1;
    private JButton b_specialcourse_done;
    JScrollPane pane;
    ArrayList< String > items=new ArrayList<String>();
    public ViewAllAdmin()  
    {
       // ob1=new ViewAllAdmin();
      
       // ob1.setVisible(true);
        ob1=this;
        setBounds(200, 0, 1000,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        l_ViewAllAdmin=new JLabel(image_home);
        l_ViewAllAdmin.setSize(1000, 700);
        l_ViewAllAdmin.setLayout(null);
        setContentPane(l_ViewAllAdmin);

        l=new JLabel("All Admin Info");
        l.setBounds(450,20,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_ViewAllAdmin.add(l);
        
        b_AddNewAdmin=new JButton("Add Admin");
        b_AddNewAdmin.setBounds(50, 60, 150, 40);
        l_ViewAllAdmin.add(b_AddNewAdmin);
        b_AssignCourse=new JButton("Assign Courses");
        b_AssignCourse.setBounds(300, 60, 150, 40);
        l_ViewAllAdmin.add(b_AssignCourse);
        b_delete=new JButton("Course Delete");
        b_delete.setBounds(550, 60, 150, 40);
        l_ViewAllAdmin.add(b_delete);
        
        b_delete_admin=new JButton("Admin Delete");
        b_delete_admin.setBounds(800, 60, 150, 40);
        l_ViewAllAdmin.add(b_delete_admin);
        
        StatusData = new String[60][2];
        t_ViewAllAdmin= new JTable(StatusData, column);
        t_ViewAllAdmin.setBackground(Color.WHITE);
        pane = new JScrollPane(t_ViewAllAdmin);
        t_ViewAllAdmin.setFont(new Font("Arial", Font.BOLD, 13));
        t_ViewAllAdmin.setRowHeight(20);
                
        TableColumn c0 = t_ViewAllAdmin.getColumnModel().getColumn(0);
        c0.setPreferredWidth(60);
        TableColumn c1 = t_ViewAllAdmin.getColumnModel().getColumn(1);
        c1.setPreferredWidth(600);
        
        pane.setBounds(50, 120, 900, 500);
        
        l_ViewAllAdmin.add(pane);    
        
        b_ViewAllAdminDone=new JButton("Close");
        b_ViewAllAdminDone.setBounds(440, 640, 70,40);
        l_ViewAllAdmin.add(b_ViewAllAdminDone);   
        
        final CreateAdminInfo obj=new CreateAdminInfo(this);
        //final CourseAssignInfo objj=new CourseAssignInfo();
       // final ListOfAssignCourse objj=new ListOfAssignCourse("", "",ob1);
        new database.Db_Admin_Info().show_admin();
        
        b_AddNewAdmin.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                obj.setVisible(true);
                    
            }
        });
        
        b_AssignCourse.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    String table_course,temp_course = "",temp_type = "";            
                    int row=t_ViewAllAdmin.getSelectedRow();                                                                
                    String s_studentID=StatusData[row][1],s_studentID2,s_admin_name;
                    int i = 0,j=s_studentID.length()-1;
                    System.out.println(j);
                    if(j<50&&j>0)
                    {
                        s_studentID2=StatusData[row][0];
                        s_admin_name=StatusData[row+1][1];
                        if(s_studentID2.compareTo("Teacher ID")==0)
                        {
                            //objj.setVisible(true);
                            new ListOfAssignCourse(s_studentID, s_admin_name, ob1).setVisible(true);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry......");
                    }

                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Select a row");
                }
                
                //setVisible(false);
               // final ListOfAssignCourse objj=new ListOfAssignCourse("", "",this);
                 
               // s_count="jkk";
              //  objj.setVisible(true);
                
            }
        });
        
        b_ViewAllAdminDone.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 
               setVisible(false);
            }
        }); 
        
        b_delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {                        
                try
                {
                    //  t_studentList.setVisible(false);
                    String table_course,temp_course = "",temp_type = "";            
                    int row=t_ViewAllAdmin.getSelectedRow();                                                                
                    String s_studentID=StatusData[row][1];
                    int i = 0,j=s_studentID.length()-1;
                    System.out.println(j);
                    if(j>60)
                    {
                        for(i=15;;++i)
                        {
                            if(s_studentID.charAt(i)==' ')
                            {
                                break;
                            }
                        }

                        while(true)
                        {
                            if(s_studentID.charAt(j)==' ')
                            {
                                break;
                            }
                            --j;
                        }
                    temp_type=s_studentID.substring(j+6 , s_studentID.length());
                     temp_course=s_studentID.substring(13,i);             
                    System.out.println(temp_course);
                    System.out.println(temp_type);

                    }
                    if(temp_type.compareTo("Thisis")==0||temp_type.compareTo("Project")==0)
                    {       
                        int len;
                        String admin_id,admin_id2;
                        while(true)
                        {
                            --row;
                            admin_id=StatusData[row][1];
                            len=admin_id.length();
                            if(len<50)
                            {
                                admin_id2=StatusData[row][0];
                                if(admin_id2.compareTo("Teacher ID")==0)
                                {
                                    break;
                                }
                            }

                        }
                        System.out.println(admin_id);
                        new database.project_tresisSubjectremove().Admin_info_createPT(temp_course, admin_id);
                       t_ViewAllAdmin.setVisible(false);
                        new database.Db_Admin_Info().show_admin();
                        t_ViewAllAdmin.setVisible(true);
                    }
                    else if(temp_type.compareTo("Theory")==0||temp_type.compareTo("Lab")==0)
                    {
                         int len;
                        String admin_id,admin_id2;
                        while(true)
                        {
                            --row;
                            admin_id=StatusData[row][1];
                            len=admin_id.length();
                            if(len<50)
                            {
                                admin_id2=StatusData[row][0];
                                if(admin_id2.compareTo("Teacher ID")==0)
                                {
                                    break;
                                }
                            }

                        }
                        new database.subjectremove().Admin_info_create(temp_course,admin_id);
                       t_ViewAllAdmin.setVisible(false);
                        new database.Db_Admin_Info().show_admin();
                        t_ViewAllAdmin.setVisible(true);                           
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Select a row");
                }

            }
        });
        b_delete_admin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try
                {                                   
                    String table_course,temp_course = "",temp_type = "";            
                    int row=t_ViewAllAdmin.getSelectedRow();                                                                
                    String s_studentID=StatusData[row][1],s_studentID2;
                    int i = 0,j=s_studentID.length()-1;
                    System.out.println(j);
                    if(j<50&&j>0)
                    {
                        s_studentID2=StatusData[row][0];
                        if(s_studentID2.compareTo("Teacher ID")==0)
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
                                    String a_course_code,b_course_type;
                                    //JOptionPane.showMessageDialog(null, s_studentID);
                                    st.executeUpdate("delete from t_admin_info where admin_id='"+s_studentID+"'");  
                                    ResultSet res = st.executeQuery("select * from t_admin_course_"+s_studentID+"");

                                       
                                    while(res.next()==true)
                                    {                                    
                                        a_course_code=res.getString("course_code");
                                        b_course_type=res.getString("type");
                                        if(b_course_type.compareTo("Thisis")==0||b_course_type.compareTo("Project")==0)
                                        {                                            
                                            new database.project_tresisSubjectremove().Admin_info_createPT(a_course_code,s_studentID);
                                        }
                                        else if(b_course_type.compareTo("Theory")==0||b_course_type.compareTo("Lab")==0)
                                        {                                        
                                            new database.subjectremove().Admin_info_create(a_course_code,s_studentID);
                                        }
                                    }
                                            //t_ViewAllAdmin.removeAll();
                                           t_ViewAllAdmin.setVisible(false);
                                            new database.Db_Admin_Info().show_admin();
                                            t_ViewAllAdmin.setVisible(true);                           


                                }
                                catch(Exception ex)
                                {
                                }            
                            }        
                            catch(Exception ex)        
                            {        

                            }  
                            System.out.println(s_studentID);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry......");
                    }
                }                
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Select a row");
                }

                
            }
        });
        
    }
}
