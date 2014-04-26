
package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class StudentList extends JFrame
{

    private  ImageIcon image_home = new ImageIcon(getClass().getResource("image/administratorInfo.jpg"));
    public String column[] = {"Student ID", "Student Name", "Hall"};
    public static String StatusData[][];
    public static JTable t_studentList;
    public JLabel l_studentlist,l_edit;
    private JLabel l;
    public JButton b_studentlistDone,b_delete,b_visitSession;
    public JCheckBox cb_editable;
    public String s_session;
    String combobox_session;
    public String s_student_id,s_student_name,s_dormitory;
    private JComboBox combobox;
    private String combox[]={"2003_04","2004_05","2005_06","2006_07","2007_08","2008_09","2009_10","2010_11","2011_12","2012_13",
                "2013_14","2014_15","2015_16","2016_17","2017_18","2018_19","2020_21","2021_22","2023_24","2024_25","2025_26"};
    private JLabel l_studentsission;
    private JScrollPane pane;
    public StudentList() 
    {
        setBounds(250, 0, 770,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
        
        
        l_studentlist=new JLabel(image_home);
        l_studentlist.setSize(1000, 700);
        l_studentlist.setLayout(null);
        setContentPane(l_studentlist);

        l=new JLabel("Student List");
        l.setBounds(290,10,300, 30);
        l.setFont(new Font("Arial", Font.ITALIC, 20));
        l.setForeground(Color.WHITE);
        l.setLayout(null);
        l_studentlist.add(l);
        
         l_studentsission=new JLabel("Enter Session");
         l_studentsission.setFont(new Font("Arial", Font.ITALIC, 23));
        l_studentsission.setForeground(Color.white);
        l_studentsission.setBounds(230, 50, 180, 30);
        
        combobox=new JComboBox(combox);
        combobox.setBounds(380, 50, 100, 30);

        l_studentlist.add(l_studentsission);
        l_studentlist.add(combobox);
        
        StatusData = new String[50][3];
        int p,q;
        for(p=0;p<20;++p)
        {
            for(q=0;q<3;++q)
            {
                StatusData[p][q]="";
            }
        }
        
        t_studentList= new JTable(StatusData, column);
        t_studentList.setBackground(Color.WHITE);
        pane = new JScrollPane(t_studentList);
        t_studentList.setFont(new Font("Arial", Font.BOLD, 13));
        t_studentList.setRowHeight(22);
        
        TableColumn c0 = t_studentList.getColumnModel().getColumn(0);
        c0.setPreferredWidth(5);
        TableColumn c1 = t_studentList.getColumnModel().getColumn(1);
        c1.setPreferredWidth(250);          
        TableColumn c2 = t_studentList.getColumnModel().getColumn(2);
        c2.setPreferredWidth(5);
        pane.setBounds(55, 100, 650, 450);
        l_studentlist.add(pane);

         combobox.addActionListener(new ActionListener() 
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                t_studentList.setVisible(false);
                combobox_session=(String)combobox.getSelectedItem();              
                new database.student_info().student_info_create(combobox_session);
                t_studentList.setVisible(true);
            }
        });
         
        cb_editable=new JCheckBox();
        cb_editable.setBounds(25, 570, 20, 20);
        l_studentlist.add(cb_editable);
        l_edit=new JLabel("Editable");
        l_edit.setBounds(55, 530, 50, 100);
        l_edit.setFont(new Font("Arial", Font.BOLD, 12));
        l_edit.setForeground(Color.WHITE);
        l_studentlist.add(l_edit);
        
        b_studentlistDone=new JButton("Save");
        b_studentlistDone.setBounds(300, 590, 70,40);
        l_studentlist.add(b_studentlistDone);
        
        b_delete=new JButton("Delete");
        b_delete.setBounds(600, 560, 70,30);
        l_studentlist.add(b_delete);
        
        t_studentList.setEnabled(false);
        
        b_studentlistDone.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Connection conn = null;
                try                        
                {        
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");            
                    System.out.println(" successfull connect");            
                    Statement st = conn.createStatement();            

                    st.executeUpdate("truncate table t_session"+combobox_session+"");
                    conn.close();
                 }
                 catch(Exception ex)
                 {

                 }
                for(int j=0;j<20;++j)                                                                                                                                     
                {                   
                    try                    
                    {                    
                        s_student_id=(t_studentList.getModel().getValueAt(j, 0)).toString(); 
                        s_student_name=(t_studentList.getModel().getValueAt(j, 1)).toString();                        
                        s_dormitory=(t_studentList.getModel().getValueAt(j, 2)).toString(); 
                        
                        
                        new database.student_info().student_info_insert(combobox_session, s_student_id, s_student_name, s_dormitory);                            
                        System.out.println("yes..");                             
                                                  
                        System.out.println("yes..111");                                                                           
                    }                    
                    catch(Exception ex1)                    
                    {   
                        System.out.println("try......omara");                         
                    }                    
                }                
                //setVisible(false);
                JOptionPane.showMessageDialog(null,"Successfully Saved");
            }            
        });
        
        cb_editable.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(cb_editable.isSelected())
                {
                    t_studentList.setEnabled(true);
                }
                else
                {
                    t_studentList.setEnabled(false);
                }
            }
        });
        
        b_delete.addActionListener(new ActionListener() 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                t_studentList.setVisible(false);
                String combobox_session;
                combobox_session=(String)combobox.getSelectedItem(); 
                int row=t_studentList.getSelectedRow();                
                String s_studentID=StatusData[row][0];              
                new database.student_info().student_info_delete(combobox_session, s_studentID);
                new database.student_info().student_info_create(combobox_session);
                t_studentList.setVisible(true);
            }
        });
    }
}
