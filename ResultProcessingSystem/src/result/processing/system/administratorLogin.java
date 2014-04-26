package result.processing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class administratorLogin extends JFrame
{
    private JPanel p_admsLogin;
    private JLabel l_admsLogin_username,l_admsLogin_password;
    private JTextField jt_admsLogin_username;
    private  JPasswordField jpa_admsLogin_password;    
    private JButton b_admsLogin_done;
    MainWindows login_obj;
    public administratorLogin(MainWindows aa)
    {
        login_obj=aa;
        setBounds(350,50,320, 240);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p_admsLogin=new JPanel();
        p_admsLogin.setLayout(null);
       
        setContentPane(p_admsLogin);
        
        l_admsLogin_username=new JLabel("user name");
        l_admsLogin_username.setBounds(23, 30, 80, 30);
        
        l_admsLogin_password=new JLabel("password");
        l_admsLogin_password.setBounds(23, 80, 80, 30);
        
        jt_admsLogin_username=new JTextField();
        jt_admsLogin_username.setBounds(130, 30, 150, 30);
        jpa_admsLogin_password=new JPasswordField();
        jpa_admsLogin_password.setBounds(130, 80, 150, 30);
        
        b_admsLogin_done=new JButton("LogIn");
        b_admsLogin_done.setBounds(120, 140,90, 40);
        
        p_admsLogin.add(l_admsLogin_username);
        p_admsLogin.add(l_admsLogin_password);
        p_admsLogin.add(jt_admsLogin_username);
        p_admsLogin.add(jpa_admsLogin_password);
        p_admsLogin.add(b_admsLogin_done);
        
       b_admsLogin_done.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int a=0;
                new database.Dbcon_administrator_login().administrator_login_create();
                a=new database.Dbcon_administrator_login().administrator_login_check(jt_admsLogin_username.getText(), jpa_admsLogin_password.getText());
                if(a==1)
                {
                    new administratorInfo().setVisible(true);                
                    setVisible(false);
                    login_obj.setVisible(false);           
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Username/Password");
                }
               
            }
        });
        
    }
    
}
