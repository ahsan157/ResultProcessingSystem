
package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class tabulationShit extends JFrame 
{
   // public static String s1_course=null,s2_course=null,s3_course=null,s4_course=null,s5_course=null,s6_course=null,s7_course=null,s8_course=null,s9_course=null,s10_course=null,s11_course=null,s12_course=null;
    
    
    private  ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    public static String resdata[][]=new String[70][55];
    public static String rescolumn[]={"", "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    //private String rescolumn[]={"Student ID", "Student Name","MO","LG","GP","ps","MO","LG","GP","ps","MO","LG","GP","ps","MO","LG","GP","ps","MO","LG","GP","ps","MO","LG","GP","ps","MO","LG","GP","ps"};
    
    private String s_session,s_year;
    int c=90;
    public static JTable t_theoryresult;
    private JLabel l_theoryresult,l_resultcoursetitle,l_resultcoursecode,l_resultcoursecredit,l_resultsession;
    private JButton b_resultdone,b_logout;
    public tabulationShit(String session, String year)
    {
        s_session=session;
        s_year=year;
        System.out.println(s_year+"    "+s_session);
        
        setBounds(0, 0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
        l_theoryresult=new JLabel(image_home);
        l_theoryresult.setSize(1000, 700);
        l_theoryresult.setLayout(null);
        setContentPane(l_theoryresult);
        
        l_resultcoursetitle=new JLabel("Mawlana Bhasani Science and Technology University");
        l_resultcoursetitle.setBounds(500, 10, 600, 50);
        l_resultcoursetitle.setFont(new Font("Arial", Font.BOLD, 20));
        l_resultcoursetitle.setForeground(Color.WHITE);
        l_resultcoursetitle.setLayout(null);
        l_theoryresult.add(l_resultcoursetitle);
   
        l_resultcoursecode=new JLabel("Department Of CSE                                 session: "+s_session);
        l_resultcoursecode.setBounds(400, 50, 800, 50);
        l_resultcoursecode.setFont(new Font("Arial", Font.BOLD, 15));
        l_resultcoursecode.setForeground(Color.WHITE);
        l_resultcoursecode.setLayout(null);
        l_theoryresult.add(l_resultcoursecode);
        
        
          b_logout=new JButton("LogOut");
        b_logout.setBounds(1280,0,80,35);
        l_theoryresult.add(b_logout);
       b_logout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new MainWindows().setVisible(true);
                setVisible(false);
            }
        });
        
        int p,q;
        for(p=0;p<65;++p)
        {
            for(q=0;q<55;++q)
            {
                resdata[p][q]="";
            }
        }
            for(q=3;q<50;q+=4)
        {
            resdata[0][q]="Course Code:";
            resdata[1][q]="Credit:";
        }
        for(q=2;q<50;q+=4)
        {
            resdata[2][q]="MO";
            resdata[2][q+1]="LG";
            resdata[2][q+2]="GP";
            resdata[2][q+3]="PS";
        }
        resdata[0][50]="CT";
        resdata[0][51]="CE";
        resdata[0][52]="TPS";
        resdata[0][53]="GPA";
        resdata[0][54]="RESULT";
        
        new database.Db_tabulationShit().getcoursecode(s_session, s_year);
        //get student name,id of that session
       
            
        t_theoryresult= new JTable(resdata, rescolumn);
        t_theoryresult.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_theoryresult,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        t_theoryresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_theoryresult.setRowHeight(25);
        
        TableColumn c0 = t_theoryresult.getColumnModel().getColumn(0);
        c0.setPreferredWidth(100);
        TableColumn c1 = t_theoryresult.getColumnModel().getColumn(1);
        c1.setPreferredWidth(200);          
        TableColumn c2 = t_theoryresult.getColumnModel().getColumn(2);
        c2.setPreferredWidth(c);
        TableColumn c3 = t_theoryresult.getColumnModel().getColumn(3);
        c3.setPreferredWidth(c);
        TableColumn c4 = t_theoryresult.getColumnModel().getColumn(4);
        c4.setPreferredWidth(c);          
        TableColumn c5 = t_theoryresult.getColumnModel().getColumn(5);
        c5.setPreferredWidth(c);
        TableColumn c6 = t_theoryresult.getColumnModel().getColumn(6);
        c6.setPreferredWidth(c);
       TableColumn c7 = t_theoryresult.getColumnModel().getColumn(7);
        c7.setPreferredWidth(c);          
        TableColumn c8 = t_theoryresult.getColumnModel().getColumn(8);
        c8.setPreferredWidth(c);
        TableColumn c9 = t_theoryresult.getColumnModel().getColumn(9);
        c9.setPreferredWidth(c);
        TableColumn c10 = t_theoryresult.getColumnModel().getColumn(10);
        c10.setPreferredWidth(c);          
        TableColumn c11 = t_theoryresult.getColumnModel().getColumn(11);
        c11.setPreferredWidth(c);
        TableColumnModel cm = t_theoryresult.getColumnModel();
    //ColumnGroup g_name = new ColumnGroup("Name");
    //g_name.add(cm.getColumn(1));
    //g_name.add(cm.getColumn(2));
        
        TableColumn c12 = t_theoryresult.getColumnModel().getColumn(12);
        c12.setPreferredWidth(c);
        TableColumn c13 = t_theoryresult.getColumnModel().getColumn(13);
        c13.setPreferredWidth(c);
        TableColumn c14 = t_theoryresult.getColumnModel().getColumn(14);
        c14.setPreferredWidth(c);          
        TableColumn c15 = t_theoryresult.getColumnModel().getColumn(15);
        c15.setPreferredWidth(c);
        TableColumn c16 = t_theoryresult.getColumnModel().getColumn(16);
        c16.setPreferredWidth(c);
        TableColumn c17 = t_theoryresult.getColumnModel().getColumn(17);
        c17.setPreferredWidth(c);          
        TableColumn c18 = t_theoryresult.getColumnModel().getColumn(18);
        c18.setPreferredWidth(c);
        TableColumn c19 = t_theoryresult.getColumnModel().getColumn(19);
        c19.setPreferredWidth(c);
        TableColumn c20 = t_theoryresult.getColumnModel().getColumn(20);
        c20.setPreferredWidth(c);          
        TableColumn c21 = t_theoryresult.getColumnModel().getColumn(21);
        c21.setPreferredWidth(c);
        
        
        TableColumn c22 = t_theoryresult.getColumnModel().getColumn(22);
        c22.setPreferredWidth(c);
        TableColumn c23 = t_theoryresult.getColumnModel().getColumn(23);
        c23.setPreferredWidth(c);
        TableColumn c24 = t_theoryresult.getColumnModel().getColumn(24);
        c24.setPreferredWidth(c);          
        TableColumn c25 = t_theoryresult.getColumnModel().getColumn(25);
        c25.setPreferredWidth(c);
        TableColumn c26 = t_theoryresult.getColumnModel().getColumn(26);
        c26.setPreferredWidth(c);
        TableColumn c27 = t_theoryresult.getColumnModel().getColumn(27);
        c27.setPreferredWidth(c);          
        TableColumn c28 = t_theoryresult.getColumnModel().getColumn(28);
        c28.setPreferredWidth(c);
        TableColumn c29 = t_theoryresult.getColumnModel().getColumn(29);
        c29.setPreferredWidth(c);
        TableColumn c30 = t_theoryresult.getColumnModel().getColumn(30);
        c30.setPreferredWidth(c);          
        TableColumn c31 = t_theoryresult.getColumnModel().getColumn(31);
        c31.setPreferredWidth(c);
        
        TableColumn c32 = t_theoryresult.getColumnModel().getColumn(32);
        c32.setPreferredWidth(c);
        TableColumn c33 = t_theoryresult.getColumnModel().getColumn(33);
        c33.setPreferredWidth(c);
        TableColumn c34 = t_theoryresult.getColumnModel().getColumn(34);
        c34.setPreferredWidth(c);          
        TableColumn c35 = t_theoryresult.getColumnModel().getColumn(35);
        c35.setPreferredWidth(c);
        TableColumn c36 = t_theoryresult.getColumnModel().getColumn(36);
        c36.setPreferredWidth(c);
        TableColumn c37 = t_theoryresult.getColumnModel().getColumn(37);
        c37.setPreferredWidth(c);          
        TableColumn c38 = t_theoryresult.getColumnModel().getColumn(38);
        c38.setPreferredWidth(c);
        TableColumn c39 = t_theoryresult.getColumnModel().getColumn(39);
        c39.setPreferredWidth(c);
        TableColumn c40 = t_theoryresult.getColumnModel().getColumn(40);
        c40.setPreferredWidth(c);          
        TableColumn c41 = t_theoryresult.getColumnModel().getColumn(41);
        c41.setPreferredWidth(c);
        
        TableColumn c42 = t_theoryresult.getColumnModel().getColumn(42);
        c42.setPreferredWidth(c);
        TableColumn c43 = t_theoryresult.getColumnModel().getColumn(43);
        c43.setPreferredWidth(c);
        TableColumn c44 = t_theoryresult.getColumnModel().getColumn(44);
        c44.setPreferredWidth(c);          
        TableColumn c45 = t_theoryresult.getColumnModel().getColumn(45);
        c45.setPreferredWidth(c);
        TableColumn c46 = t_theoryresult.getColumnModel().getColumn(46);
        c46.setPreferredWidth(c);
        TableColumn c47 = t_theoryresult.getColumnModel().getColumn(47);
        c47.setPreferredWidth(c);          
        TableColumn c48 = t_theoryresult.getColumnModel().getColumn(48);
        c48.setPreferredWidth(c);
        TableColumn c49 = t_theoryresult.getColumnModel().getColumn(49);
        c49.setPreferredWidth(c);
        TableColumn c50 = t_theoryresult.getColumnModel().getColumn(50);
        c50.setPreferredWidth(c);          
        TableColumn c51 = t_theoryresult.getColumnModel().getColumn(51);
        c51.setPreferredWidth(c);
        TableColumn c52 = t_theoryresult.getColumnModel().getColumn(52);
        c52.setPreferredWidth(c);
        TableColumn c53 = t_theoryresult.getColumnModel().getColumn(53);
        c53.setPreferredWidth(c);
        TableColumn c54 = t_theoryresult.getColumnModel().getColumn(54);
        c54.setPreferredWidth(c);          
        
        
        
        pane.setBounds(25, 100, 1300,520);
        l_theoryresult.add(pane);
        t_theoryresult.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         new database.Db_tabulationShit().student_info(s_session,s_year);
        
      //  b_resultdone.setBounds(643, 640, 80,30);
        
    }
}
