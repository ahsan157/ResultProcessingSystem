
package result.processing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class tabulationShitInfo extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private JLabel l_tabulationShitInfo;
    private JLabel l_session , l_year,l_semester;
    //private JTextField jt_backlog_course_code , jt_backlog_student_number,jt_admin_id;
    private JComboBox jc_session,jc_year,jc_semester;
    private String combox1[]={"2003_04","2004_05","2005_06","2006_07","2007_08","2008_09","2009_10","2010_11","2011_12","2012_13",
                "2013_14","2014_15","2015_16","2016_17","2017_18","2018_19","2019_20","2020_21","2021_22","2022_23","2023_24","2024_25","2025_26"};
    private String combox2[]={"1st","2nd","3rd","4th"};
    private String combox3[]={"1st","2nd"};
    private JButton b_backlog_course_done;
    int p,q;
    public tabulationShitInfo()
    {
        setBounds(483, 150, 400, 400);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l_tabulationShitInfo=new JLabel(image_home);
        l_tabulationShitInfo.setSize(1000, 700);
        l_tabulationShitInfo.setLayout(null);
        
        setContentPane(l_tabulationShitInfo);
        
        l_session=new JLabel("Session");
        l_session.setForeground(Color.white);
        l_session.setBounds(110, 60, 80, 30);
        l_year=new JLabel("Year");
        l_year.setForeground(Color.white);
        l_year.setBounds(110, 130, 200, 50);
        l_semester=new JLabel("Semester");
        l_semester.setForeground(Color.white);
        l_semester.setBounds(110, 200, 150, 30);
        
        jc_session=new JComboBox(combox1);
        jc_session.setBounds(110, 100, 150, 30);
        jc_year=new JComboBox(combox2);
        jc_year.setBounds(110, 170, 150, 30);
        jc_semester=new JComboBox(combox3);
        jc_semester.setBounds(110, 240, 150, 30);
        
        b_backlog_course_done=new JButton("Done");
        b_backlog_course_done.setBounds(135, 300,100, 35);
        
        
        l_tabulationShitInfo.add(l_session);
        l_tabulationShitInfo.add(jc_session);
        l_tabulationShitInfo.add(l_year);
        l_tabulationShitInfo.add(jc_year);
        l_tabulationShitInfo.add(l_semester);
        l_tabulationShitInfo.add(jc_semester);
        l_tabulationShitInfo.add(b_backlog_course_done);
        
        b_backlog_course_done.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String s_session,s_year,s_semeter;
                s_session=(String)jc_session.getSelectedItem();
                s_year=(String)jc_year.getSelectedItem();
                s_semeter=(String)jc_semester.getSelectedItem();
                s_year=(s_year.substring(0, 1))+(s_semeter.substring(0, 1));                
                s_semeter=s_session.substring(5, 7);
                System.out.println(s_year+"    "+s_session+"    "+s_semeter);
                new tabulationShit(s_session, s_year).setVisible(true);
                setVisible(false);
            }
        });
    }
}
