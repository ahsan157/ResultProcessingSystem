package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import static result.processing.system.ListOfAssignCourse.StatusData;

public class listOfSpecialCourse extends JFrame
{
    
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private String column[] = {"Student Id", "STudent Name","Session"};
    public static String StatusData[][];
    JTable t_listOfSpecialScourse;
    JLabel l_listOfSpecialScourse;
    private JLabel l,l1,l2;
    JButton b_listOfSpecialScourse;
    int n=20;
    String s_CourseCode,s_CourseTitle,s_examSession,s_CourseCredit,s_CourseType,s_AdminID;
    public listOfSpecialCourse(String s_CourseCode1,String s_CourseTitle1,String s_examSession1, String s_CourseCredit1,String s_CourseType1,String s_AdminID1) 
    {
        
        s_CourseCode=s_CourseCode1;
        s_CourseTitle=s_CourseTitle1;
        s_examSession=s_examSession1;
        s_CourseCredit=s_CourseCredit1;
        s_CourseType=s_CourseType1;
        s_AdminID=s_AdminID1;
        setBounds(420, 100, 480,420);
        setLayout(null);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
        l_listOfSpecialScourse=new JLabel(image_home);
        l_listOfSpecialScourse.setSize(1000, 700);
        l_listOfSpecialScourse.setLayout(null);
        setContentPane(l_listOfSpecialScourse);

        l=new JLabel("Special Course Student List");
        l.setBounds(130,40,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_listOfSpecialScourse.add(l);
        
        l1=new JLabel("Course Name: ");
        l1.setBounds(10,10,140, 30);
        l1.setFont(new Font("Arial", Font.ITALIC, 20));
        l1.setForeground(Color.WHITE);
        l1.setLayout(null);
        l_listOfSpecialScourse.add(l1);
        
        l2=new JLabel(s_CourseTitle);
        l2.setBounds(150,10,300, 30);
        l2.setFont(new Font("Arial", Font.ITALIC, 19));
        l2.setForeground(Color.WHITE);
        l2.setLayout(null);
        l_listOfSpecialScourse.add(l2);
        
        StatusData = new String[n][3];
        StatusData = new String[n][5];
         for(int j=0;j<n;++j)
        {
           StatusData[j][0]="";
           StatusData[j][1]="";
           StatusData[j][2]="";
        }
        t_listOfSpecialScourse= new JTable(StatusData, column);
        t_listOfSpecialScourse.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_listOfSpecialScourse);
        t_listOfSpecialScourse.setFont(new Font("Arial", Font.BOLD, 13));
        t_listOfSpecialScourse.setRowHeight(20);
        
        TableColumn c0 = t_listOfSpecialScourse.getColumnModel().getColumn(0);
        c0.setPreferredWidth(50);
        TableColumn c1 = t_listOfSpecialScourse.getColumnModel().getColumn(1);            
        c1.setPreferredWidth(150);          
        
        if(n<=9)
        pane.setBounds(25, 80, 425, (43+(20*(n-1))));
        else
            pane.setBounds(25, 80, 425,223);
        l_listOfSpecialScourse.add(pane);                    
        b_listOfSpecialScourse=new JButton("Done");
        b_listOfSpecialScourse.setBounds(210, 305, 70,40);
        l_listOfSpecialScourse.add(b_listOfSpecialScourse);
        
        b_listOfSpecialScourse.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 for(int j=0;j<n;++j)
                {
                    String s_Student_ID=((t_listOfSpecialScourse.getModel().getValueAt(j,0)).toString()),s_student_Name=((t_listOfSpecialScourse.getModel().getValueAt(j,1)).toString()),s_Session=((t_listOfSpecialScourse.getModel().getValueAt(j,2)).toString());
                    if(s_Student_ID.compareTo("")!=0&&s_student_Name.compareTo("")!=0&&s_Session.compareTo("")!=0)
                    {
                        int a=new database.DbSpecialCourse().SpecialCheck(s_CourseCode);
                        if(a==1)
                       JOptionPane.showMessageDialog(null, "No.......");
                        else
                        {
                            if(s_CourseType.compareTo("Theory")==0)
                                new database.Db_SpeacalCourseInsert().Special_theory_table(s_Student_ID, s_student_Name,s_examSession,s_CourseCode, s_CourseTitle,s_Session,s_CourseCredit,s_CourseType, s_AdminID);
                            if(s_CourseType.compareTo("Lab")==0)
                                new database.Db_SpeacalCourseInsert().Special_lab_table(s_Student_ID, s_student_Name,s_examSession,s_CourseCode, s_CourseTitle,s_Session,s_CourseCredit,s_CourseType, s_AdminID);
                            if(s_CourseType.compareTo("Project")==0)
                                new database.Db_SpeacalCourseInsert().Special_project_table(s_Student_ID, s_student_Name,s_examSession,s_CourseCode, s_CourseTitle,s_Session,s_CourseCredit,s_CourseType, s_AdminID);
                            if(s_CourseType.compareTo("Thisis")==0)
                                new database.Db_SpeacalCourseInsert().Special_thisis_table(s_Student_ID, s_student_Name,s_examSession,s_CourseCode, s_CourseTitle,s_Session,s_CourseCredit,s_CourseType, s_AdminID);
//                                JOptionPane.showMessageDialog(null, "Yes");
                        }
                    }
                        
                }
                setVisible(false);
            }
        });
    }    
}
