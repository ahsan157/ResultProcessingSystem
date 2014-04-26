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

public class LabResultTable extends JFrame
{
    private  ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    private String rescolumn[]={"Student ID", "Student Name","Lab Quize", "Viva","Total 30", "Lab Performance",
                                "Mark Obtained","Grade Point", "Letter Grade"};
    private String resdata[][];
    private JTable t_labresult;
    private JLabel l_labresult,l_resultcoursetitle,l_resultcoursecode,l_resultcoursecredit,l_resultsession;
    private JButton b_resultdone;
    public LabResultTable()
    {
        setBounds(0, 0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
        l_labresult=new JLabel(image_home);
        l_labresult.setSize(1000, 700);
        l_labresult.setLayout(null);
        setContentPane(l_labresult);
        
        l_resultcoursetitle=new JLabel("ACM PROGRAMMING LAB");
        l_resultcoursetitle.setBounds(550, 10, 400, 50);
        l_resultcoursetitle.setFont(new Font("Arial", Font.BOLD, 20));
        l_resultcoursetitle.setForeground(Color.WHITE);
        l_resultcoursetitle.setLayout(null);
        l_labresult.add(l_resultcoursetitle);
   
        l_resultcoursecode=new JLabel("Course Code : CSE_3202            Session : 2010_11           Credit : 1");
        l_resultcoursecode.setBounds(400, 50, 800, 50);
        l_resultcoursecode.setFont(new Font("Arial", Font.BOLD, 15));
        l_resultcoursecode.setForeground(Color.WHITE);
        l_resultcoursecode.setLayout(null);
        l_labresult.add(l_resultcoursecode);
        
        resdata=new String[70][9];
        //int p,q;
        //for(p=0;p<70;++p)
        //{
            //for(q=0;q<12;++q)
            //{
                //resdata[p][q]="";
            //}
        //}
        t_labresult= new JTable(resdata, rescolumn);
        t_labresult.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_labresult);
        t_labresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_labresult.setRowHeight(25);
        
        TableColumn c0 = t_labresult.getColumnModel().getColumn(0);
        c0.setPreferredWidth(2);
        TableColumn c1 = t_labresult.getColumnModel().getColumn(1);
        c1.setPreferredWidth(150);          
        TableColumn c2 = t_labresult.getColumnModel().getColumn(2);
        c2.setPreferredWidth(5);
        TableColumn c3 = t_labresult.getColumnModel().getColumn(3);
        c3.setPreferredWidth(5);
        TableColumn c4 = t_labresult.getColumnModel().getColumn(4);
        c4.setPreferredWidth(5);          
        TableColumn c5 = t_labresult.getColumnModel().getColumn(5);
        c5.setPreferredWidth(5);
        TableColumn c6 = t_labresult.getColumnModel().getColumn(6);
        c6.setPreferredWidth(5);
        TableColumn c7 = t_labresult.getColumnModel().getColumn(7);
        c7.setPreferredWidth(5);          
        TableColumn c8 = t_labresult.getColumnModel().getColumn(8);
        c8.setPreferredWidth(5);
        pane.setBounds(25, 100, 1300,520);
        l_labresult.add(pane);
        
        b_resultdone=new JButton("Save");
        b_resultdone.setBounds(643, 640, 80,30);
        l_labresult.add(b_resultdone);
    }
}
