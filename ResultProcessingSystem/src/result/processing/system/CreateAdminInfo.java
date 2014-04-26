package result.processing.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAdminInfo extends JFrame
{
    private ImageIcon image_home = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private JLabel l_create_admin;
    private JLabel l_admin_id , l_admin_name , l_user_id , l_password , l_con_pass;
    private JTextField jt_admin_id , jt_admin_name , jt_user_id ;
    private JPasswordField jp_password , jp_con_pass;
    private JButton b_createadmin_done;
    ViewAllAdmin obj1;
    public CreateAdminInfo(ViewAllAdmin aa)
    {
        obj1=aa;
        setBounds(400, 50, 500, 550);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        l_create_admin=new JLabel(image_home);
        l_create_admin.setSize(1000, 700);
        l_create_admin.setLayout(null);
        
        setContentPane(l_create_admin);
        
        l_admin_id=new JLabel("Admin Id");
        l_admin_id.setForeground(Color.white);
        l_admin_id.setBounds(50, 50, 100, 30);
        l_admin_name=new JLabel("Admin Name");
        l_admin_name.setForeground(Color.white);
        l_admin_name.setBounds(50, 100, 100, 30);
        l_user_id=new JLabel("User Id");
        l_user_id.setForeground(Color.white);
        l_user_id.setBounds(50, 150, 100, 30);
        l_password=new JLabel("Enter Password");
        l_password.setForeground(Color.white);
        l_password.setBounds(50, 200, 100, 30);
        l_con_pass=new JLabel("Confirm Password");
        l_con_pass.setForeground(Color.white);
        l_con_pass.setBounds(50, 250, 150, 30);
        
        jt_admin_id=new JTextField();
        jt_admin_id.setBounds(200, 50, 150, 30);
        jt_admin_name=new JTextField();
        jt_admin_name.setBounds(200, 100, 150, 30);
        jt_user_id=new JTextField();
        jt_user_id.setBounds(200, 150, 150, 30);
        jp_password=new JPasswordField();
        jp_password.setBounds(200, 200, 150, 30);
        jp_con_pass=new JPasswordField();
        jp_con_pass.setBounds(200, 250, 150, 30);
        
        b_createadmin_done=new JButton("Done");
        b_createadmin_done.setBounds(150, 350 , 90, 40);
        
        l_create_admin.add(l_admin_id);
        l_create_admin.add(jt_admin_id);
        l_create_admin.add(l_admin_name);
        l_create_admin.add(jt_admin_name);
        l_create_admin.add(l_user_id);
        l_create_admin.add(jt_user_id);
        l_create_admin.add(l_password);
        l_create_admin.add(jp_password);
        l_create_admin.add(l_con_pass);
        l_create_admin.add(jp_con_pass);
        l_create_admin.add(b_createadmin_done);
        
        b_createadmin_done.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {                
                    //new ViewAllAdmin().t_ViewAllAdmin.setVisible(false);
                if(jp_con_pass.getText().compareTo(jp_password.getText())==0)
                { new database.Db_Admin_Info().Admin_info_create(jt_admin_id.getText(), jt_admin_name.getText(), jt_user_id.getText(), jp_password.getText());
                    obj1.t_ViewAllAdmin.setVisible(false);
                    new database.Db_Admin_Info().show_admin();
                    obj1.t_ViewAllAdmin.setVisible(true);
                    //obj1.setVisible(false);
                    
                    //new ViewAllAdmin().setVisible(true);
                    setVisible(false);}
                else
                {
                    JOptionPane.showMessageDialog(null, "password doesn't match");
                }
                    
            }
        });
    }
}
