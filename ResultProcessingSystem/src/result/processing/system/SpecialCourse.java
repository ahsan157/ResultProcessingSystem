
package result.processing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class SpecialCourse extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private JLabel l_special_course;
    private JLabel l_coursetitle , l_special_student_number,l_examSession,l_coursecode,l_credit,l_type,l_adminname;
    private JTextField jt_coursetitle , jt_special_student_number,jt_examSession,jt_coursecode,jt_credit,jt_type,jt_adminname;
    private JComboBox jc_examSession,jc_type,jc_adminname;
    private String combox[]={"2003_04","2004_05","2005_06","2006_07","2007_08","2008_09","2009_10","2010_11","2011_12","2012_13",
                "2013_14","2014_15","2015_16","2016_17","2017_18","2018_19","2020_21","2021_22","2023_24","2024_25","2025_26"};
   private String combox2[]={"Theory","Lab","Project","Thesis"};
   int p;
   ArrayList< String > items=new ArrayList<String>();
    private JButton b_specialcourse_done;

    public SpecialCourse()
    {
        setBounds(420, 0, 420, 600);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l_special_course=new JLabel(image_home);
        l_special_course.setSize(1000, 700);
        l_special_course.setLayout(null);
        
        setContentPane(l_special_course);
        
        l_coursecode=new JLabel("Course Code");
        l_coursecode.setForeground(Color.white);
        l_coursecode.setBounds(110, 50, 180, 30);
        
        jt_coursecode=new JTextField();
        jt_coursecode.setForeground(Color.BLACK);
        jt_coursecode.setBounds(110, 80, 180, 30);
        
        l_coursetitle=new JLabel("Course Title");
        l_coursetitle.setForeground(Color.white);
        l_coursetitle.setBounds(110, 120, 180, 30);
        
         jt_coursetitle=new JTextField();
        jt_coursetitle.setForeground(Color.BLACK);
        jt_coursetitle.setBounds(110, 150, 180, 30);
        
        
        l_examSession=new JLabel("Exam Session");
        l_examSession.setForeground(Color.white);
        l_examSession.setBounds(110, 190, 180, 30);
        
        
        jc_examSession=new JComboBox(combox);
        jc_examSession.setForeground(Color.BLACK);
        jc_examSession.setBounds(110, 220, 180, 30);
        
        
        l_credit=new JLabel("Course Credit");
        l_credit.setForeground(Color.white);
        l_credit.setBounds(110, 260, 180, 30);
        
        jt_credit=new JTextField();
        jt_credit.setForeground(Color.BLACK);
        jt_credit.setBounds(110, 290, 180, 30);
        
        
        l_type=new JLabel("Course type");
        l_type.setForeground(Color.white);
        l_type.setBounds(110, 330, 180, 30);
        
        jc_type=new JComboBox(combox2);
        jc_type.setForeground(Color.BLACK);
        jc_type.setBounds(110, 360, 180, 30);
        
        
        
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
                int i=0;
                while(res.next()==true)                                                                                                                         
                { 
                    a = res.getString("admin_id");   
                    items.add(a);                     
                     ++i;
                     
                }
                p=i;
               // JOptionPane.showMessageDialog(null, combox3);
            }
            catch(Exception ex)
            {
//                JOptionPane.showMessageDialog(null, "");
            }    
        }
        catch(Exception ex1)        
        {        
            System.out.println("already table create..........");            
        }      
    
        
        l_adminname=new JLabel("Admin ID");
        l_adminname.setForeground(Color.white);
        l_adminname.setBounds(110, 400, 180, 30);
        int g=0;
        String s[] = null;
        String combox3[]=new String[p];
        for(String item : items)
        {
            combox3[g]=item;
            ++g;
        }
        
        jc_adminname=new JComboBox(combox3);
        jc_adminname.setForeground(Color.BLACK);
        jc_adminname.setBounds(110, 430, 180, 30);
        

        jt_special_student_number=new JTextField();
        jt_special_student_number.setBounds(110, 210, 150, 30);
        
        b_specialcourse_done=new JButton("Done");
        b_specialcourse_done.setBounds(135, 490,100, 35);
        
        l_special_course.add(l_coursecode);
        l_special_course.add(l_coursetitle);
        l_special_course.add(l_examSession);
        l_special_course.add(l_credit);
        l_special_course.add(l_type);
        l_special_course.add(l_adminname);
        
        l_special_course.add(jt_coursecode);
        l_special_course.add(jt_coursetitle);
        l_special_course.add(jc_examSession);
        l_special_course.add(jt_credit);
        l_special_course.add(jc_type);
        l_special_course.add(jc_adminname);
        
        l_special_course.add(b_specialcourse_done);
     /*   l_special_course.add(jt_special_course_title);
        l_special_course.add(l_special_student_number);
        l_special_course.add(jt_special_student_number);
        l_special_course.add(b_specialcourse_done);
       */ 
        b_specialcourse_done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(jt_coursecode.getText().compareTo("")!=0&&jt_coursetitle.getText().compareTo("")!=0&&jt_credit.getText().compareTo("")!=0)
                {
                    int a=new database.DbSpecialCourse().SpecialCheck(jt_coursecode.getText());
                    if(a!=1)
                    {
                        new listOfSpecialCourse(jt_coursecode.getText(), jt_coursetitle.getText(), (String)jc_examSession.getSelectedItem(), jt_credit.getText(), (String)jc_type.getSelectedItem(), (String)jc_adminname.getSelectedItem()).setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "regular course.....");
                    }
                }
            }
        });
    }
}
