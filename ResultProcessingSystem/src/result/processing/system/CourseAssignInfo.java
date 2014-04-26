
package result.processing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CourseAssignInfo extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private JLabel l_admin_course_assign;
    private JLabel l_admin_id , l_course_number;
    private JTextField jt_admin_id , jt_course_number;
    private JButton b_course_assign_done;

    public CourseAssignInfo()
    {
        setBounds(483, 150, 400, 450);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        l_admin_course_assign=new JLabel(image_home);
        l_admin_course_assign.setSize(1000, 700);
        l_admin_course_assign.setLayout(null);
        
        setContentPane(l_admin_course_assign);
        
        l_admin_id=new JLabel("Enter Admin Id");
        l_admin_id.setForeground(Color.white);
        l_admin_id.setBounds(110, 100, 100, 30);
        l_course_number=new JLabel("Enter How Many course");
        l_course_number.setForeground(Color.white);
        l_course_number.setBounds(110, 170, 150, 50);
        
        jt_admin_id=new JTextField();
        jt_admin_id.setBounds(110, 140, 150, 30);
        jt_course_number=new JTextField();
        jt_course_number.setBounds(110, 210, 150, 30);
        
        b_course_assign_done=new JButton("Done");
        b_course_assign_done.setBounds(135, 300,100, 35);
        
        l_admin_course_assign.add(l_admin_id);
        l_admin_course_assign.add(jt_admin_id);
        l_admin_course_assign.add(l_course_number);
        l_admin_course_assign.add(jt_course_number);
        l_admin_course_assign.add(b_course_assign_done);
        
        b_course_assign_done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //new ListOfAssignCourse(jt_admin_id.getText(),jt_course_number.getText()).setVisible(true);
                setVisible(false);
            }
        });
    }
}
