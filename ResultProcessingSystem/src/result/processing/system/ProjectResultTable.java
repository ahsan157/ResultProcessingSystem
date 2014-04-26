package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class ProjectResultTable extends JFrame
{
    private  ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    private String rescolumn[]={"Student ID", "Student Name","Class Test", "Attendence","Total 30", "Internal",
                        "External", "Third Examinar","Avarage", "Mark Obtained","Grade Point", "Letter Grade"};
    private String resdata[][];
    private JTable t_theoryresult;
    private JLabel l_theoryresult,l_resultcoursetitle,l_resultcoursecode,l_resultcoursecredit,l_resultsession;
    private JButton b_resultdone;
    public ProjectResultTable()
    {
        setBounds(0, 0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
        l_theoryresult=new JLabel(image_home);
        l_theoryresult.setSize(1000, 700);
        l_theoryresult.setLayout(null);
        setContentPane(l_theoryresult);
        
        l_resultcoursetitle=new JLabel("ACM PROGRAMMING");
        l_resultcoursetitle.setBounds(550, 10, 400, 50);
        l_resultcoursetitle.setFont(new Font("Arial", Font.BOLD, 20));
        l_resultcoursetitle.setForeground(Color.WHITE);
        l_resultcoursetitle.setLayout(null);
        l_theoryresult.add(l_resultcoursetitle);
   
        l_resultcoursecode=new JLabel("Course Code : CSE_3201            Session : 2010_11           Credit : 3");
        l_resultcoursecode.setBounds(400, 50, 800, 50);
        l_resultcoursecode.setFont(new Font("Arial", Font.BOLD, 15));
        l_resultcoursecode.setForeground(Color.WHITE);
        l_resultcoursecode.setLayout(null);
        l_theoryresult.add(l_resultcoursecode);
        
        resdata=new String[70][12];
        //int p,q;
        //for(p=0;p<70;++p)
        //{
            //for(q=0;q<12;++q)
            //{
                //resdata[p][q]="";
            //}
        //}
        t_theoryresult= new JTable(resdata, rescolumn);
        t_theoryresult.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_theoryresult);
        t_theoryresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_theoryresult.setRowHeight(25);
        
        TableColumn c0 = t_theoryresult.getColumnModel().getColumn(0);
        c0.setPreferredWidth(2);
        TableColumn c1 = t_theoryresult.getColumnModel().getColumn(1);
        c1.setPreferredWidth(100);          
        TableColumn c2 = t_theoryresult.getColumnModel().getColumn(2);
        c2.setPreferredWidth(5);
        TableColumn c3 = t_theoryresult.getColumnModel().getColumn(3);
        c3.setPreferredWidth(5);
        TableColumn c4 = t_theoryresult.getColumnModel().getColumn(4);
        c4.setPreferredWidth(5);          
        TableColumn c5 = t_theoryresult.getColumnModel().getColumn(5);
        c5.setPreferredWidth(5);
        TableColumn c6 = t_theoryresult.getColumnModel().getColumn(6);
        c6.setPreferredWidth(5);
        TableColumn c7 = t_theoryresult.getColumnModel().getColumn(7);
        c7.setPreferredWidth(5);          
        TableColumn c8 = t_theoryresult.getColumnModel().getColumn(8);
        c8.setPreferredWidth(5);
        TableColumn c9 = t_theoryresult.getColumnModel().getColumn(9);
        c9.setPreferredWidth(5);
        TableColumn c10 = t_theoryresult.getColumnModel().getColumn(10);
        c10.setPreferredWidth(5);          
        TableColumn c11 = t_theoryresult.getColumnModel().getColumn(11);
        c11.setPreferredWidth(5);
        pane.setBounds(25, 100, 1300,520);
        l_theoryresult.add(pane);
        
        b_resultdone=new JButton("Save");
        b_resultdone.setBounds(643, 640, 80,30);
        l_theoryresult.add(b_resultdone);
    }
}
