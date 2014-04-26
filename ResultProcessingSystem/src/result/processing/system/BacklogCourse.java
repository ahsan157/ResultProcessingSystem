package result.processing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BacklogCourse extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private JLabel l_BacklogCourseInfo;
    private JLabel l_backlog_course_code , l_backlog_student_number,l_admin_id;
    private JTextField jt_backlog_course_code , jt_backlog_student_number,jt_admin_id;
    private JComboBox jc_admin_id,jc_backlog_course_code;
    private JButton b_backlog_course_done;
    ArrayList< String > items=new ArrayList<String>();
    ArrayList< String > items2=new ArrayList<String>();
    int p,q;
    public BacklogCourse()
    {
        setBounds(483, 150, 400, 400);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l_BacklogCourseInfo=new JLabel(image_home);
        l_BacklogCourseInfo.setSize(1000, 700);
        l_BacklogCourseInfo.setLayout(null);
        
        setContentPane(l_BacklogCourseInfo);
        
        l_backlog_course_code=new JLabel("Course Code");
        l_backlog_course_code.setForeground(Color.white);
        l_backlog_course_code.setBounds(110, 60, 80, 30);
        l_backlog_student_number=new JLabel("Number Of Backlog Students");
        l_backlog_student_number.setForeground(Color.white);
        l_backlog_student_number.setBounds(110, 130, 200, 50);
        l_admin_id=new JLabel("Enter Admin Id");
        l_admin_id.setForeground(Color.white);
        l_admin_id.setBounds(110, 200, 150, 30);
        
        jc_backlog_course_code=new JComboBox();
        jc_backlog_course_code.setBounds(110, 100, 150, 30);
        jt_backlog_student_number=new JTextField();
        jt_backlog_student_number.setBounds(110, 170, 150, 30);
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
        
            try                        
            {   
                ResultSet res = st.executeQuery("select * from t_admin_info");
                String a,b;                            
                int i=0,j = 0;
                while(res.next()==true)                                                                                                                         
                { 
                    a = res.getString("admin_id");   
                    items.add(a);                     
                     ++i;
                     
                }
                p=i;
                ResultSet res1 = st.executeQuery("select * from speacalcheck");
                
                while(res1.next()==true)                                                                                                                         
                { 
                    b = res1.getString("course_code");   
                    items2.add(b);                     
                     ++j;
                     
                }
                
                q=j;
               // JOptionPane.showMessageDialog(null, combox3);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "....");
            }    
        }
        catch(Exception ex1)        
        {        
            System.out.println("already table create..........");            
        }          
        
        int g=0;
        String s[] = null;
        String combox1[]=new String[p];
        for(String item : items)
        {
            combox1[g]=item;
            ++g;
        }
        
        g=0;        
        String combox2[]=new String[q];
        for(String item1 : items2)
        {            
            combox2[g]=item1;
            ++g;
        }
        
        jc_admin_id=new JComboBox(combox1);
        jc_admin_id.setBounds(110, 240, 150, 30);
        jc_admin_id.setBackground(Color.WHITE);
        
        jc_backlog_course_code=new JComboBox(combox2);
        jc_backlog_course_code.setBounds(110, 100, 150, 30);
        
        b_backlog_course_done=new JButton("Done");
        b_backlog_course_done.setBounds(135, 300,100, 35);
        
        
        l_BacklogCourseInfo.add(l_backlog_course_code);
        l_BacklogCourseInfo.add(jc_backlog_course_code);
        l_BacklogCourseInfo.add(l_backlog_student_number);
        l_BacklogCourseInfo.add(jt_backlog_student_number);
        l_BacklogCourseInfo.add(l_admin_id);
        l_BacklogCourseInfo.add(jc_admin_id);
        l_BacklogCourseInfo.add(b_backlog_course_done);
        
        jc_admin_id.setEnabled(false);
        
        jc_backlog_course_code.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String s;
                s=(String)jc_backlog_course_code.getSelectedItem();
                //System.out.println(jt_backlog_course_code.getText());
                if((s.compareTo("CSE2112")==0 || s.compareTo("CSE3116")==0) ||s.compareTo("CSE5000")==0)
                {
                    jc_admin_id.setEnabled(true);
                    jc_admin_id.setBackground(Color.white);
                }
                else
                {
                    jc_admin_id.setEnabled(false);
                }
            }
        });
        
        
        b_backlog_course_done.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                /*if(((jt_backlog_course_code.getText()).compareTo("CSE1209")==0 || (jt_backlog_course_code.getText()).compareTo("CSE3109")==0) )
                {
                    jt_admin_id.setEnabled(true);
                    JOptionPane.showMessageDialog(null,"Enter Admin Id");
                    new listOfBacklog(jt_backlog_course_code.getText(),jt_backlog_student_number.getText(),jt_admin_id.getText()).setVisible(true);
                }*/
                if(jt_backlog_student_number.getText().compareTo("")!=0)
                {
                    new listOfBacklog((String)jc_backlog_course_code.getSelectedItem(),jt_backlog_student_number.getText(),(String)jc_admin_id.getSelectedItem()).setVisible(true);
                    setVisible(false);
                }
            }
        });
    }
}
