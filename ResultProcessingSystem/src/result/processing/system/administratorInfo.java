
package result.processing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class administratorInfo extends JFrame
{
  private ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    JLabel l_adminastrator;
    private JButton b_student_info,b_admin_info,b_backLog,b_special;
    private JButton b_back,b_logout;
    public administratorInfo() 
    {
        setBounds(0,0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        l_adminastrator=new JLabel(image_home);
        l_adminastrator.setSize(1000, 700);
        l_adminastrator.setLayout(null);
        
        setContentPane(l_adminastrator);
        
        b_student_info=new JButton("Student Info");
        b_student_info.setBounds(583, 200,200, 50);
        l_adminastrator.add(b_student_info);
        
        b_admin_info=new JButton("Admin info");
        b_admin_info.setBounds(583, 300,200, 50);
        l_adminastrator.add(b_admin_info);
        
        b_backLog=new JButton("BackLog Course");
        b_backLog.setBounds(583, 400,200, 50);
        l_adminastrator.add(b_backLog);
        
        b_special=new JButton("Special Course");
        b_special.setBounds(583, 500,200, 50);
        l_adminastrator.add(b_special);
        
        b_back=new JButton("Back");
        b_back.setBounds(20,650,80,35);
        //l_adminastrator.add(b_back);
        
        b_logout=new JButton("LogOut");
        b_logout.setBounds(1250,10,80,35);
        l_adminastrator.add(b_logout);
        
        add(MainWindows.timeLabel);
        
        b_student_info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                new StudentList().setVisible(true);
            }
        });
        
        b_admin_info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ViewAllAdmin().setVisible(true);
                //setVisible(false);
            }
        });
        b_backLog.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                new BacklogCourse().setVisible(true);
            }
        });
        b_special.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                new SpecialCourse().setVisible(true);
            }
        });
        b_logout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new MainWindows().setVisible(true);
                setVisible(false);
            }
        });
    }
    
    
}
