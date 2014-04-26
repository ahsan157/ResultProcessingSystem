
package result.processing.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindows extends JFrame 
{

   private ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    JLabel l_MainWindows;
    JButton b_administrator,b_admin,b_viwer;
    final static JLabel timeLabel = new JLabel();
    final static DateFormat timeFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a");
    
    public MainWindows() 
    {
        setBounds(0,0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
          
        new ShowTime();
        
        l_MainWindows=new JLabel(image_home);
        l_MainWindows.setSize(1000, 700);
        l_MainWindows.setLayout(null);
        
        setContentPane(l_MainWindows);
        
        b_administrator=new JButton("Administrator");
        b_administrator.setBounds(583, 250,200, 50);
        l_MainWindows.add(b_administrator);
        
        b_admin=new JButton("Admin");
        b_admin.setBounds(583, 350,200, 50);
        l_MainWindows.add(b_admin);
        
        b_viwer=new JButton("Viwer");
        b_viwer.setBounds(583, 450,200, 50);
        l_MainWindows.add(b_viwer);
        
        add(timeLabel);
        
        final administratorLogin obj_administrator=new administratorLogin(this);
        final AdminLogin obj_admin=new AdminLogin(this);
        final ViewerLogin obj_viewer=new ViewerLogin(this);
        b_administrator.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
              obj_administrator.setVisible(true);
            }
        });
        
         b_admin.addActionListener(new ActionListener() 
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                obj_admin.setVisible(true);
                //new AdminViewerInfo().setVisible(true);
            }
        });
         
          b_viwer.addActionListener(new ActionListener() 
          {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                obj_viewer.setVisible(true);
            }
        });
    }
    
}
