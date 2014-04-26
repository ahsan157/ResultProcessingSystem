package result.processing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame
{
    private JPanel p_adimLogin;
    private JLabel l_adimLogin_username,l_adimLogin_password;
    private JTextField jt_adimLogin_username;
    private  JPasswordField jpa_adimLogin_password;    
    private JButton b_adimLogin_done;
    MainWindows login_obj;
    public AdminLogin(MainWindows aa)
    {
        login_obj=aa;
        setBounds(350,50,320, 240);
        setLayout(null);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p_adimLogin=new JPanel();
        p_adimLogin.setLayout(null);
       
        setContentPane(p_adimLogin);
        
        l_adimLogin_username=new JLabel("user name");
        l_adimLogin_username.setBounds(23, 30, 80, 30);
        
        l_adimLogin_password=new JLabel("password");
        l_adimLogin_password.setBounds(23, 80, 80, 30);
        
        jt_adimLogin_username=new JTextField();
        jt_adimLogin_username.setBounds(130, 30, 150, 30);
        jpa_adimLogin_password=new JPasswordField();
        jpa_adimLogin_password.setBounds(130, 80, 150, 30);
        
        b_adimLogin_done=new JButton("LogIn");
        b_adimLogin_done.setBounds(120, 140,90, 40);
        
        p_adimLogin.add(l_adimLogin_username);
        p_adimLogin.add(l_adimLogin_password);
        p_adimLogin.add(jt_adimLogin_username);
        p_adimLogin.add(jpa_adimLogin_password);
        p_adimLogin.add(b_adimLogin_done);
        
       b_adimLogin_done.addActionListener(new ActionListener() 
       {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Connection conn = null;
                int a=0;
                String s_a = null,s_b = null,s_adminID=null,s_adminName=null;
                try        
                {        
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");            
                    System.out.println(" successfull connect");            
                                    
                    Statement st = conn.createStatement();            
                    try                        
                    {
                        String s1=jt_adimLogin_username.getText(), s2=jpa_adimLogin_password.getText();
                        ResultSet res = st.executeQuery("select * from t_admin_info");
                        
                        while(res.next()==true)                                                                                     
                        { // process results one row at a time 
                            s_adminName=res.getString("admin_name");
                            s_adminID=res.getString("admin_id");
                            s_a = res.getString("username");                                                       
                            s_b = res.getString("password"); 
                            if(s_a.compareTo(s1)==0&&s_b.compareTo(s2)==0)
                            {  
                                a=1;
                                System.out.println("success");
                                break;
                            }

                        }

                            System.out.println("no success");


                    }                        
                    catch(Exception ex)            
                    {            
                        System.out.println("inner already table create..........");                
                    }            
                }        
                catch(Exception ex)        
                {        
                    System.out.println("already table create..........");            
                }
                                                                                
                //a=new database.AdminLogInCheck().admin_login_check(jt_adimLogin_username.getText(), jpa_adimLogin_password.getText());
                if(a==1)
                 {
                     
                     new AdminViewerInfo(s_adminID,s_adminName).setVisible(true);
                    //new administratorInfo().setVisible(true);                
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
