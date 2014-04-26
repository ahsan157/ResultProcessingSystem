package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class ListOfAssignCourse extends JFrame
{

    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private String column[] = {"Course Code","Course Title", "session", "Cradit","Type"};
    public static String StatusData[][];
    JTable t_CourseList;
    JLabel l_ListOfAssignCourse,l_ListOfAssigndefault;
    private JLabel l;
    JButton b_ListOfAssignCourseDone;
    JComboBox dpt;
    int row=0,col,n;
    JComboBox comboBox;
    CourseAssignInfo obj3;
    String a,st_admin_name,st_admin_id;
    private String dept_course[] = {"Select Department", "N/A", "CSE", "ICT", "TE", "ESRM", "BGE", "CPS", "FTNS", "PHY", "STA", "CHE","MATH", "ECO", "ENG", "SCO"};
    
    String s_adminID1,s_number1;
    ViewAllAdmin ob;
    public ListOfAssignCourse(String s_adminID,String s_admin_name,ViewAllAdmin aa)  
    {
      
        ob=aa;
        setBounds(420, 100, 480,420);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 
                st_admin_id=s_adminID;
                int n1=0,i;
                for(i=0;i<"10".length();++i)
                {
                    n1=10*n1+("10".charAt(i)-'0');
                }
                n=n1;
        /*...................end................*/
          
        l_ListOfAssignCourse=new JLabel(image_home);
        l_ListOfAssignCourse.setSize(1000, 700);
        l_ListOfAssignCourse.setLayout(null);
        setContentPane(l_ListOfAssignCourse);        
        
        
        dpt = new JComboBox(dept_course);
        dpt.setBackground(Color.black);
        dpt.setForeground(Color.yellow);

        l=new JLabel("Course List");
        l.setBounds(180,40,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_ListOfAssignCourse.add(l);
        
       l=new JLabel("Course List");
        l.setBounds(180,40,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_ListOfAssignCourse.add(l);
        
        JLabel l1=new JLabel("Teacher Name :");
        l1.setBounds(10,10,150, 30);
        l1.setFont(new Font("Arial", Font.ITALIC, 20));
        l1.setForeground(Color.WHITE);
        l1.setLayout(null);
        l_ListOfAssignCourse.add(l1);
                
                
        JLabel l2=new JLabel(s_admin_name);
        l2.setBounds(160,10,300, 30);
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        l2.setForeground(Color.WHITE);
        l2.setLayout(null);
        l_ListOfAssignCourse.add(l2);
                       
       //JOptionPane.showMessageDialog(null, n);
        StatusData = new String[n][5];
         for(int j=0;j<n;++j)
        {
           StatusData[j][0]="";
           StatusData[j][1]="";
           StatusData[j][2]="";
           StatusData[j][3]="";
           StatusData[j][4]="";
        }
        t_CourseList= new JTable(StatusData, column);
        t_CourseList.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_CourseList);
        t_CourseList.setFont(new Font("Arial", Font.BOLD, 13));
        t_CourseList.setRowHeight(20);
        
        TableColumn c0 = t_CourseList.getColumnModel().getColumn(0);
        c0.setPreferredWidth(50);
        TableColumn c1 = t_CourseList.getColumnModel().getColumn(1);
        c1.setPreferredWidth(140);
                  
        TableColumn c2 = t_CourseList.getColumnModel().getColumn(2);
        c2.setPreferredWidth(30);
        
        TableColumn c3 = t_CourseList.getColumnModel().getColumn(3);
        c3.setPreferredWidth(10);                
        
        TableColumn c4 = t_CourseList.getColumnModel().getColumn(4);
        c4.setPreferredWidth(25);
        
        comboBox = new JComboBox();
        
        comboBox.addItem("Theory");
        comboBox.addItem("Lab");
        comboBox.addItem("Project");
        comboBox.addItem("Thesis");
        
        c4.setCellEditor(new DefaultCellEditor(comboBox));
        //c3..setCellEditor(new DefaultCellEditor(dpt));

        if(n<=9)
        pane.setBounds(25, 80, 425, (43+(20*(n-1))));
        else
            pane.setBounds(25, 80, 425,223);

        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
            try                        
            {
                ResultSet res = st.executeQuery("select * from t_admin_info where admin_id="+s_adminID+"");
                // String a = null;                               
                
                while(res.next()==true)                                                 
                { // process results one row at a time                   
                    st_admin_name = res.getString("admin_name"); 
                    System.out.println("ListOfAssignCourse name= "+st_admin_name);
                }
            }
            catch(Exception ex)
            {
            }            
        }        
        catch(Exception ex)        
        {        
            System.out.println("already table create..........");            
        }  
        
        l_ListOfAssignCourse.add(pane);                    
        b_ListOfAssignCourseDone=new JButton("Save");
        b_ListOfAssignCourseDone.setBounds(210, 305, 70,40);
        l_ListOfAssignCourse.add(b_ListOfAssignCourseDone);
        
        b_ListOfAssignCourseDone.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                for(int i=0;i<n;++i)
                {                    
                    int a=0;                   
                   try
                   {
                       if(((t_CourseList.getModel().getValueAt(i,4)).toString()).compareTo("Theory")==0 || ((t_CourseList.getModel().getValueAt(i,4)).toString()).compareTo("Lab")==0)
                       {
                            try
                            {
                                a=new database.Db_Admin_Info().AllCourse(st_admin_id, st_admin_name, ((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,1)).toString()));
                            }
                            catch(Exception ex)
                            {

                                System.out.println("noo"+"   "+i);
                            }
                       }
                        else if(((t_CourseList.getModel().getValueAt(i,4)).toString()).compareTo("Thisis")==0 || ((t_CourseList.getModel().getValueAt(i,4)).toString()).compareTo("Project")==0)
                        {
                            a=2;
                        }
                   }
                   catch(Exception exe)
                   {
                       System.out.println("no2222222222");
                   }
                    if(a==2)
                    {
                        String s=(t_CourseList.getModel().getValueAt(i,4)).toString();
                        // System.out.println((t_CourseList.getModel().getValueAt(col,0)).toString());
                       
                      //  System.out.println(s+"  "+col);
                         if(s.compareTo("Theory")==0)
                         {
                      
                             new database.temporaryResult().temporary_theory_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "temp_");
                             new database.temporaryResult().temporary_theory_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "par");
                         }
                         else if(s.compareTo("Lab")==0)
                         {
                             new database.temporaryResult().temporary_lab_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "temp_");
                             new database.temporaryResult().temporary_lab_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "par");
                         }
                         else if(s.compareTo("Project")==0)
                         {
                       
                             new SelectedSessionStudentTable(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "Project").setVisible(true);
                             new database.temporaryResult().temporary_project_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "par");
                         }
                         else if(s.compareTo("Thisis")==0)
                         {
                       
                             new SelectedSessionStudentTable(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "Thisis").setVisible(true);
                             new database.temporaryResult().temporary_thisis_table(((t_CourseList.getModel().getValueAt(i,0)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), st_admin_id, "par");
                         }
                        System.out.println("yes...  start 1");
                        new database.Db_Admin_Info().Admin_course_assign_table(st_admin_id);
                        new database.Db_Admin_Info().Admin_course_assign_insert(st_admin_id, ((t_CourseList.getModel().getValueAt(i,0)).toString()),((t_CourseList.getModel().getValueAt(i,1)).toString()), ((t_CourseList.getModel().getValueAt(i,2)).toString()), ((t_CourseList.getModel().getValueAt(i,3)).toString()), ((t_CourseList.getModel().getValueAt(i,4)).toString()));
                        System.out.println("yes...  1");
                }
                    else
                    {
                        System.out.println("no.......1");
                    }
                }      
            
                ob.t_ViewAllAdmin.setVisible(false);                
                new database.Db_Admin_Info().show_admin();                
                ob.t_ViewAllAdmin.setVisible(true);    
                
                setVisible(false);                
            }
        });   
    }    
}
