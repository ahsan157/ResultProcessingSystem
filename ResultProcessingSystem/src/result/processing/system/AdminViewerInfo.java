package result.processing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import static result.processing.system.StudentList.t_studentList;

/**
 *
 * @author Ahsan
 */
public class AdminViewerInfo extends JFrame
{
    
    public static String resdata[][];
    //student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps
    public static String rescolumn[]={"Student ID", "Student Name","Class Test", "Attendence","Total 30", "Internal",
                        "External", "Third Examinar","Avarage", "Mark Obtained","Grade Point", "Letter Grade"};
    public static String resdatalab[][];
    //student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps
    public static String rescolumnlab[]={"Student ID", "Student Name","lab_quiz", "lab_viva","lab_final",
        "Mark Obtained","Grade Point", "Letter Grade"};
    //student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps
    public static String resdataproject[][];
    public static String rescolumnproject[]={"Student ID", "Student Name","Presentation", "Project_viva","Mark_70"
            , "Mark Obtained","Grade Point", "Letter Grade"};
//student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps
        
    public static String resdatathesis[][];
    public static String rescolumnthesis[]={"Student ID", "Student Name","Internal", "External","presentation", 
        "Mark Obtained","Grade Point", "Letter Grade"};

    private JLabel l_theoryresult,l_Lab,l_project,l_thesis,l_default;
    private  ImageIcon image_home = new ImageIcon(getClass().getResource("image/picture.jpg"));
    private  ImageIcon image_home2 = new ImageIcon(getClass().getResource("image/mainwindows.jpg"));
    private String combox[]={"Theory","Lab","Project","Thesis"};
    public static JTable t_theoryresult,t_projectresult,t_Labresult,t_thesisresult;
    private JLabel l_coursename,l_courseID;
    private JLabel l_credit,l_teachername;
    private JComboBox combobox;
    private JButton jb_done,jb_done_lab,jb_done_thesis,jb_done_project,b_logout;
    String courseCode;
    String s_Admin_id,s_AdminName;
    ArrayList< String > items=new ArrayList<String>();
    ArrayList< String > item2=new ArrayList<String>();
    int p=0;
    String s_course_title,s_coursetype,s_courseSession,s_courseCredit;
    
    public AdminViewerInfo(String ss,String sa) 
    {
        s_Admin_id=ss;
        s_AdminName=sa;
//        JOptionPane.showMessageDialog(null, s_Admin_id+s_AdminName);
       setBounds(0, 0,1366,720);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l_theoryresult=new JLabel(image_home2);
        l_theoryresult.setBounds(0,50,1366, 650);
        l_theoryresult.setLayout(null);
      //  setContentPane(l_theoryresult);
        add(l_theoryresult);
        
        l_Lab=new JLabel(image_home2);
        l_Lab.setBounds(0,50,1366, 650);
        l_Lab.setLayout(null);
      //  setContentPane(l_theoryresult);
        add(l_Lab);
        
        l_project=new JLabel(image_home2);
        l_project.setBounds(0,50,1366, 650);
        l_project.setLayout(null);
      //  setContentPane(l_theoryresult);
        add(l_project);
        
        l_thesis=new JLabel(image_home2);
        l_thesis.setBounds(0,50,1366, 650);
        l_thesis.setLayout(null);
      //  setContentPane(l_theoryresult);
        add(l_thesis);
        
        l_default=new JLabel(image_home2);
        l_default.setBounds(0,50,1366, 650);
        l_default.setLayout(null);
      //  setContentPane(l_theoryresult);
        add(l_default);

        
                l_teachername=new JLabel("Teacher Name: "+s_AdminName);
                l_teachername.setBounds(100,20,550, 10);
                l_teachername.setFont(new Font("Arial", Font.BOLD, 13));
                l_teachername.setLayout(null);
                add(l_teachername);
                
                l_coursename=new JLabel();
                l_coursename.setBounds(100,20,800, 15);
                l_coursename.setFont(new Font("Arial", Font.BOLD, 13));
                l_coursename.setLayout(null);
                

                l_courseID=new JLabel();
                l_courseID.setBounds(500,20,1000, 15);
                l_courseID.setFont(new Font("Arial", Font.BOLD, 13));
                l_courseID.setLayout(null);


                l_credit=new JLabel();
                l_credit.setBounds(700,20,550, 15);
                l_credit.setFont(new Font("Arial", Font.BOLD, 13));
                l_credit.setLayout(null);
               
        
                jb_done=new JButton("Done");
                jb_done.setBounds(630, 580, 100, 50);
                jb_done_lab=new JButton("Done");
                jb_done_lab.setBounds(630, 580, 100, 50);
                jb_done_project=new JButton("Done");
                jb_done_project.setBounds(630, 580, 100, 50);
                jb_done_thesis=new JButton("Done");
                jb_done_thesis.setBounds(630, 580, 100, 50);
                //l_theoryresult.add(jb_done);
                //l_Lab.add(jb_done);
                //l_project.add(jb_done);
                //l_thesis.add(jb_done);
         b_logout=new JButton("LogOut");
        b_logout.setBounds(1280,0,80,35);
        add(b_logout);
       b_logout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new MainWindows().setVisible(true);
                setVisible(false);
            }
        });    
        /*.............subject show.........*/
        
        Connection conn = null;
        try        
        {        
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
            System.out.println(" successfull connect");
            Statement st = conn.createStatement();
        
            try                        
            {   
                ResultSet res = st.executeQuery("select * from t_admin_course_"+s_Admin_id+"");
                String a,b;                            
                int i=0;
                while(res.next()==true)                                                                                                                         
                { 
                    a = res.getString("course_code");                   
                    items.add(a);                     
                     ++i;
                     
                }
                p=i;
               // JOptionPane.showMessageDialog(null, combox3);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "....");
            }    
        }
        catch(Exception ex1)        
        {        
            System.out.println("already table create..........");            
        }      
        int g=0;
                String combox3[]=new String[p];
                for(String item : items)
                {
                    combox3[g]=item;
                    ++g;
                }
                
                combobox=new JComboBox(combox3);
                combobox.setBounds(1100, 20, 100, 30);
                add(combobox);
        /*..................end.................*/
        /*............theory..............*/
        resdata=new String[70][12];
        t_theoryresult= new JTable(resdata, rescolumn);
        
        
        t_theoryresult.setBackground(Color.WHITE);
        JScrollPane pane = new JScrollPane(t_theoryresult);
        t_theoryresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_theoryresult.setRowHeight(25);
        
        TableColumn c0 = t_theoryresult.getColumnModel().getColumn(0);
        c0.setPreferredWidth(25);
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
        pane.setBounds(25, 50, 1300,520);
        
        l_theoryresult.add(pane);
        
        /*........Lab...*/
        resdatalab=new String[70][8];
        t_Labresult= new JTable(resdatalab, rescolumnlab);
        t_Labresult.setBackground(Color.WHITE);
        JScrollPane pane1 = new JScrollPane(t_Labresult);
        t_Labresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_Labresult.setRowHeight(25);
        
       
        TableColumn d0 = t_Labresult.getColumnModel().getColumn(0);
        d0.setPreferredWidth(25);
        TableColumn d1 = t_Labresult.getColumnModel().getColumn(1);
        d1.setPreferredWidth(100);          
        TableColumn d2 = t_Labresult.getColumnModel().getColumn(2);
        d2.setPreferredWidth(5);
        TableColumn d3 = t_Labresult.getColumnModel().getColumn(3);
        d3.setPreferredWidth(5);
        TableColumn d4 = t_Labresult.getColumnModel().getColumn(4);
        d4.setPreferredWidth(5);          
        TableColumn d5 = t_Labresult.getColumnModel().getColumn(5);
        d5.setPreferredWidth(5);
        TableColumn d6 = t_Labresult.getColumnModel().getColumn(6);
        d6.setPreferredWidth(5);
        TableColumn d7 = t_Labresult.getColumnModel().getColumn(7);
        d7.setPreferredWidth(5); 
        pane1.setBounds(25, 50, 1300,520);                
        l_Lab.add(pane1);
        /*........project...........*/
        resdataproject=new String[70][8];
        t_projectresult= new JTable(resdataproject, rescolumnproject);
        t_projectresult.setBackground(Color.WHITE);
        JScrollPane pane2 = new JScrollPane(t_projectresult);
        t_projectresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_projectresult.setRowHeight(25);
        
        TableColumn e0 = t_projectresult.getColumnModel().getColumn(0);
        e0.setPreferredWidth(25);
        TableColumn e1 = t_projectresult.getColumnModel().getColumn(1);
        e1.setPreferredWidth(100);          
        TableColumn e2 = t_projectresult.getColumnModel().getColumn(2);
        e2.setPreferredWidth(5);
        TableColumn e3 = t_projectresult.getColumnModel().getColumn(3);
        e3.setPreferredWidth(5);
        TableColumn e4 = t_projectresult.getColumnModel().getColumn(4);
        e4.setPreferredWidth(5);          
        TableColumn e5 = t_projectresult.getColumnModel().getColumn(5);
        e5.setPreferredWidth(5);
        TableColumn e6 = t_projectresult.getColumnModel().getColumn(6);
        e6.setPreferredWidth(5);
        TableColumn e7 = t_projectresult.getColumnModel().getColumn(7);
        e7.setPreferredWidth(5); 
        pane2.setBounds(25, 50, 1300,520);                
        l_project.add(pane2);
       /*........thesis...*/
       
        resdatathesis=new String[70][8];
        t_thesisresult= new JTable(resdatathesis, rescolumnthesis);
        t_thesisresult.setBackground(Color.WHITE);
        JScrollPane pane3 = new JScrollPane(t_thesisresult);
        t_thesisresult.setFont(new Font("Arial", Font.BOLD, 13));
        t_thesisresult.setRowHeight(25);
        
        TableColumn f0 = t_thesisresult.getColumnModel().getColumn(0);
        f0.setPreferredWidth(25);
        TableColumn f1 = t_thesisresult.getColumnModel().getColumn(1);
        f1.setPreferredWidth(100);          
        TableColumn f2 = t_thesisresult.getColumnModel().getColumn(2);
        f2.setPreferredWidth(5);
        TableColumn f3 = t_thesisresult.getColumnModel().getColumn(3);
        f3.setPreferredWidth(5);
        TableColumn f4 = t_thesisresult.getColumnModel().getColumn(4);
        f4.setPreferredWidth(5);          
        TableColumn f5 = t_thesisresult.getColumnModel().getColumn(5);
        f5.setPreferredWidth(5);
        TableColumn f6 = t_thesisresult.getColumnModel().getColumn(6);
        f6.setPreferredWidth(5);
        TableColumn f7 = t_thesisresult.getColumnModel().getColumn(7);
        f7.setPreferredWidth(5); 
        pane3.setBounds(25, 50, 1300,520);                
        l_thesis.add(pane3);
        
        l_theoryresult.setVisible(false);
        l_Lab.setVisible(false);
        l_project.setVisible(false);
        l_thesis.setVisible(false);
        combobox.addActionListener(new ActionListener() 
        {
        @Override
        public void actionPerformed(ActionEvent e) 
        {     
            l_theoryresult.setVisible(false);
            l_Lab.setVisible(false);
            l_project.setVisible(false);
            l_thesis.setVisible(false);
            
                
                
                
                courseCode=(String)combobox.getSelectedItem();
                
                Connection conn = null;
                try        
                {        
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","lol");
                    System.out.println(" successfull connect");
                    Statement st = conn.createStatement();

                    try                        
                    {   
                        ResultSet res = st.executeQuery("select * from t_admin_course_"+s_Admin_id+" where course_code='"+courseCode+"'");
                        String a,b;                            
                        int i=0;
                        while(res.next()==true)                                                                                                                         
                        { 
                            s_course_title = res.getString("course_title");                   
                            s_coursetype=res.getString("type");                   
                            s_courseSession=res.getString("session");
                            s_courseCredit=res.getString("credit");

                        }
                        p=i;
                       // JOptionPane.showMessageDialog(null, combox3);
                    }
                    catch(Exception ex)
                    {
                        //JOptionPane.showMessageDialog(null, "....");
                    }    
                }
                catch(Exception ex1)        
                {        
                    System.out.println("already table create..........");            
                }

                
              
                
                
                if(s_coursetype.compareTo("Theory")==0)        
                {
                    l_coursename.setText("Course Title: "+s_course_title);
                    l_courseID.setText("session:"+s_courseSession);
                    l_credit.setText("Credit:"+s_courseCredit);
                    
                    l_theoryresult.add(jb_done);
                    l_theoryresult.add(l_coursename);
                    l_theoryresult.add(l_courseID);
                    l_theoryresult.add(l_credit);
                    l_theoryresult.setVisible(true);  
                    
                    new database.DBshowTempTableOnAdmin().studentcougseShow(courseCode, s_courseSession, s_Admin_id);
                    
                    jb_done.addActionListener(new ActionListener() 
                    {
                        public float getgpa(float mo)
                        {
                            if(mo>=80)
                                return 4.00f;
                            else if(mo>=75 && mo<80)
                                return 3.75f;
                            else if(mo>=70 && mo<75)
                                return 3.50f;
                            else if(mo>=65 && mo<70)
                                return 3.25f;
                            else if(mo>=60 && mo<65)
                                return 3.00f;
                            else if(mo>=55 && mo<60)
                                return 2.75f;
                            else if(mo>=50 && mo<55)
                                return 2.50f;
                            else if(mo>=45 && mo<50)
                                return 2.25f;
                            else if(mo>=40 && mo<45)
                                return 2.00f;
                            else
                                return 0.00f;
                        }
    
                        public String getlg(float mo)
                        {
                            if(mo>=80)
                                return "A+";
                            else if(mo>=75 && mo<80)
                                return "A";
                            else if(mo>=70 && mo<75)
                                return "A-";
                            else if(mo>=65 && mo<70)
                                return "B+";
                            else if(mo>=60 && mo<65)
                                return "B";
                            else if(mo>=55 && mo<60)
                                return "B-";
                            else if(mo>=50 && mo<55)
                                return "C+";
                            else if(mo>=45 && mo<50)
                                return "C";
                            else if(mo>=40 && mo<45)
                                return "D";
                            else
                                return "F";
                        }
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                            
                            //int j=0,flag=0;
                            //float mo,ct = 0,avg = 0;
                           // String sid="",sname="",sct="",sat="",sint="",sext="",sthird="",sctam="",savg="",smo="",sgp="",slg="",sps="";
                            new database.DBshowTempTableOnAdmin().adminTruncate(courseCode, s_courseSession, s_Admin_id);
                            for(int i=0;i<70;i++)
                            {
                                 int j=0,flag=0;
                                float mo,ct = 0,avg = 0;
                                String sid="",sname="",sct="",sat="",sint="",sext="",sthird="",sctam="",savg="",smo="",sgp="",slg="",sps="";
                           
                                flag=0;
                                if(((t_theoryresult.getModel().getValueAt(i,j)).toString()).compareTo("")==0)
                                {
                                    break;
                                }
                                else
                                {//student_id,student_name,class_test,attendence,tctam,internal,external,third_examiner,avg,mo,gp,lg,credit,ps
                                    sid=(t_theoryresult.getModel().getValueAt(i, j)).toString();
                                    sname=(t_theoryresult.getModel().getValueAt(i, j+1)).toString();
                                    sct=(t_theoryresult.getModel().getValueAt(i, j+2)).toString();
                                    sat=(t_theoryresult.getModel().getValueAt(i, j+3)).toString();
                                    
                                    if(sct.compareTo("")!=0 && sat.compareTo("")!=0)
                                    {
                                        ct=Float.parseFloat(sct);
                                        float at=Float.parseFloat(sat);
                                        ct=ct+at;
                                        sctam=String.valueOf(ct);
                                    
                                        //System.out.println(ct+"  "+resdata[i][j+4]);
                                        ++flag;
                                    }
                                    sint=(t_theoryresult.getModel().getValueAt(i, j+5)).toString();
                                    sext=(t_theoryresult.getModel().getValueAt(i, j+6)).toString();
                                    
                                    if(sint.compareTo("")!=0 && sext.compareTo("")!=0)
                                    {
                                        float internal=Float.parseFloat(sint);
                                        float external=Float.parseFloat(sext);
                                        float def=Math.abs(internal-external);
                                        if(def<15)
                                        {                                            
                                            avg=(internal+external)/2;
                                            savg=String.valueOf(avg);
                                            
                                            ++flag;
                                        }
                                        else
                                        {
                                            sthird=(t_theoryresult.getModel().getValueAt(i, j+7)).toString();
                                            
                                            if(sthird.compareTo("")!=0)
                                            {
                                                float third=Float.parseFloat(sthird);
                                                float th1=Math.abs(internal-third);
                                                float th2=Math.abs(external-third);
                                                if(th1<th2)
                                                {
                                                    avg=(internal+third)/2;
                                                    savg=String.valueOf(avg);
                                            
                                                    ++flag;
                                                }
                                                else
                                                {
                                                    avg=(external+third)/2;
                                                    savg=String.valueOf(avg);
                                            
                                                    ++flag;
                                                }
                                            }
                                        }
                                        if(flag==2)
                                        {
                                            mo=avg+ct;
                                            smo=String.valueOf(mo);
                                            
                                            float gpa=getgpa(mo);
                                            sgp=String.valueOf(gpa);
                                            
                                            slg=getlg(mo);   
                                            
                                            float ps=gpa*(Float.parseFloat(s_courseCredit));
                                            sps=String.valueOf(ps);
                                            
                                        }
                                    }
                                    new database.DBshowTempTableOnAdmin().adminTheoryInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, sct, sat, sctam, sint, sext, sthird, savg, smo, sgp, slg, s_courseCredit, sps);
                                }
                               // JOptionPane.showMessageDialog(null, courseCode+ s_courseSession+ s_Admin_id+ sid+ sname+ sct+ sat+ sctam+ sint+ sext+ sthird+ savg+ smo+ sgp+ slg+ s_courseCredit+ sps);
                             //(String courseCode,String session,String adminID,String StudentID,String StudentName,String ClassTest,String Attendence,String Total30,String Internal,String External,String ThirdExaminar,String Avarage,String MarkObtained,String GradePoint,String LetterGrade,String credit,String ps)
                                   //new database.DBshowTempTableOnAdmin().adminTheoryInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, sct, sat, sctam, sint, sext, sthird, savg, smo, sgp, slg, s_courseCredit, sps);
                                
                               // t_theoryresult.setVisible(false);
                               // new database.DBshowTempTableOnAdmin().studentcougseShow(courseCode, s_courseSession, s_Admin_id);
                               // t_theoryresult.setVisible(true);
                            }
                            
                             t_theoryresult.setVisible(false);
                             new database.DBshowTempTableOnAdmin().studentcougseShow(courseCode, s_courseSession, s_Admin_id);
                             t_theoryresult.setVisible(true);
                        }
                    });                    
                }
                if(s_coursetype.compareTo("Lab")==0)
                {
                    l_coursename.setText("Course Title: "+s_course_title);
                    l_courseID.setText("session:"+s_courseSession);
                    l_credit.setText("Credit:"+s_courseCredit);
                    l_Lab.add(jb_done_lab);
                    l_Lab.add(l_coursename);
                    l_Lab.add(l_courseID);
                    l_Lab.add(l_credit);

                    l_Lab.setVisible(true);
                    new database.DBshowTempTableOnAdmin().studentcougseShowLab(courseCode, s_courseSession, s_Admin_id);
                    jb_done_lab.addActionListener(new ActionListener() 
                    {
                        public float getgpa(float mo)
                        {
                            if(mo>=80)
                                return 4.00f;
                            else if(mo>=75 && mo<80)
                                return 3.75f;
                            else if(mo>=70 && mo<75)
                                return 3.50f;
                            else if(mo>=65 && mo<70)
                                return 3.25f;
                            else if(mo>=60 && mo<65)
                                return 3.00f;
                            else if(mo>=55 && mo<60)
                                return 2.75f;
                            else if(mo>=50 && mo<55)
                                return 2.50f;
                            else if(mo>=45 && mo<50)
                                return 2.25f;
                            else if(mo>=40 && mo<45)
                                return 2.00f;
                            else
                                return 0.00f;
                        }
    
                        public String getlg(float mo)
                        {
                            if(mo>=80)
                                return "A+";
                            else if(mo>=75 && mo<80)
                                return "A";
                            else if(mo>=70 && mo<75)
                                return "A-";
                            else if(mo>=65 && mo<70)
                                return "B+";
                            else if(mo>=60 && mo<65)
                                return "B";
                            else if(mo>=55 && mo<60)
                                return "B-";
                            else if(mo>=50 && mo<55)
                                return "C+";
                            else if(mo>=45 && mo<50)
                                return "C";
                            else if(mo>=40 && mo<45)
                                return "D";
                            else
                                return "F";
                        }
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                            
                            
                            
                            new database.DBshowTempTableOnAdmin().adminTruncate(courseCode, s_courseSession, s_Admin_id);
                            for(int i=0;i<70;i++)
                            {
                                int j=0,flag=0;
                                 float mo,lq = 0,lv=0,lf=0,avg = 0;
                                String sid="",sname="",slq="",slv="",slf="",smo="",sgp="",slg="",sps="";
                                
                                
                               
                               // JOptionPane.showMessageDialog(null, "good");
                                flag=0;
                                if(((t_Labresult.getModel().getValueAt(i,j)).toString()).compareTo("")==0)
                                {
                                 //   JOptionPane.showMessageDialog(null, "break");
                                    break;                                   
                                }
                                else 
                                {//student_id,student_name,lab_quiz,lab_viva,lab_final,mo,gp,lg,credit,ps
                                    System.out.println("1");
                                    sid=(t_Labresult.getModel().getValueAt(i, j)).toString();
                                    System.out.println("2");
                                    sname=(t_Labresult.getModel().getValueAt(i, j+1)).toString();
                                    slq=(t_Labresult.getModel().getValueAt(i, j+2)).toString();
                                    slv=(t_Labresult.getModel().getValueAt(i, j+3)).toString();
                                    slf=(t_Labresult.getModel().getValueAt(i, j+4)).toString();
//                                    JOptionPane.showMessageDialog(null, slq+" "+slv+"  "+slf);
                                    if(slq.compareTo("")!=0 && slv.compareTo("")!=0 && slf.compareTo("")!=0)
                                    {
                                        lq=Float.parseFloat(slq);
                                        lv=Float.parseFloat(slv);
                                        lf=Float.parseFloat(slf);
                                        mo=lq+lv+lf;
                                        smo=String.valueOf(mo);
//                                        JOptionPane.showMessageDialog(null, smo);
                                            float gpa=getgpa(mo);
                                            sgp=String.valueOf(gpa);
//                                            JOptionPane.showMessageDialog(null, sgp);
                                            slg=getlg(mo);   
     //                                       JOptionPane.showMessageDialog(null, slg);
                                            float ps=gpa*(Float.parseFloat(s_courseCredit));
                                            sps=String.valueOf(ps);
       //                                     JOptionPane.showMessageDialog(null, sps);                                        
                                            new database.DBshowTempTableOnAdmin().adminLabInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, slq, slv, slf, smo, sgp, slg, s_courseCredit, sps);
                                    }
                                    else
                                    {
                                        new database.DBshowTempTableOnAdmin().adminLabInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, "", "", "", "", "", "", "", "");
                                    }
                                    
                                }
                                
                                //JOptionPane.showMessageDialog(null, sid);
                            }
                            
                            t_Labresult.setVisible(false);
                             new database.DBshowTempTableOnAdmin().studentcougseShowLab(courseCode, s_courseSession, s_Admin_id);
                             t_Labresult.setVisible(true);
                        }
                    }); 
                }
                
                if(s_coursetype.compareTo("Project")==0)
                {
                    l_coursename.setText("Course Title: "+s_course_title);
                    l_courseID.setText("session:"+s_courseSession);
                    l_credit.setText("Credit:"+s_courseCredit);
                    l_project.add(jb_done_project);
                    l_project.add(l_coursename);
                    l_project.add(l_courseID);
                    l_project.add(l_credit);

                    l_project.setVisible(true);
                    
                    new database.DBshowTempTableOnAdmin().studentcougseShowProject(courseCode, s_courseSession, s_Admin_id);
                    jb_done_project.addActionListener(new ActionListener() 
                    {
                        public float getgpa(float mo)
                        {
                            if(mo>=80)
                                return 4.00f;
                            else if(mo>=75 && mo<80)
                                return 3.75f;
                            else if(mo>=70 && mo<75)
                                return 3.50f;
                            else if(mo>=65 && mo<70)
                                return 3.25f;
                            else if(mo>=60 && mo<65)
                                return 3.00f;
                            else if(mo>=55 && mo<60)
                                return 2.75f;
                            else if(mo>=50 && mo<55)
                                return 2.50f;
                            else if(mo>=45 && mo<50)
                                return 2.25f;
                            else if(mo>=40 && mo<45)
                                return 2.00f;
                            else
                                return 0.00f;
                        }
    
                        public String getlg(float mo)
                        {
                            if(mo>=80)
                                return "A+";
                            else if(mo>=75 && mo<80)
                                return "A";
                            else if(mo>=70 && mo<75)
                                return "A-";
                            else if(mo>=65 && mo<70)
                                return "B+";
                            else if(mo>=60 && mo<65)
                                return "B";
                            else if(mo>=55 && mo<60)
                                return "B-";
                            else if(mo>=50 && mo<55)
                                return "C+";
                            else if(mo>=45 && mo<50)
                                return "C";
                            else if(mo>=40 && mo<45)
                                return "D";
                            else
                                return "F";
                        }
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                            
                            int j=0,flag=0;
                            float mo,lq = 0,lv=0,lf=0,avg = 0;
                            String sid="",sname="", spres="",sprv="",sprf="",smo="",sgp="",slg="",sps="";
                            new database.DBshowTempTableOnAdmin().adminTruncate(courseCode, s_courseSession, s_Admin_id);
                            for(int i=0;i<70;i++)
                            {
                                flag=0;
                                if(((t_projectresult.getModel().getValueAt(i,j)).toString()).compareTo("")==0)
                                {
                                    break;
                                }
                                else
                                {//student_id,student_name,presentation,project_viva,mark_70,mo,gp,lg,credit,ps
                                    sid=(t_projectresult.getModel().getValueAt(i, j)).toString();
                                    sname=(t_projectresult.getModel().getValueAt(i, j+1)).toString();
                                    spres=(t_projectresult.getModel().getValueAt(i, j+2)).toString();
                                    sprv=(t_projectresult.getModel().getValueAt(i, j+3)).toString();
                                    sprf=(t_projectresult.getModel().getValueAt(i, j+4)).toString();
//                                    JOptionPane.showMessageDialog(null, spres+" "+sprv+"  "+sprf);
                                    if(spres.compareTo("")!=0 && sprv.compareTo("")!=0 && sprf.compareTo("")!=0)
                                    {
                                        lq=Float.parseFloat(spres);
                                        lv=Float.parseFloat(sprv);
                                        lf=Float.parseFloat(sprf);
                                        mo=lq+lv+lf;
                                        smo=String.valueOf(mo);
         //                               JOptionPane.showMessageDialog(null, smo);
                                            float gpa=getgpa(mo);
                                            sgp=String.valueOf(gpa);
           //                                 JOptionPane.showMessageDialog(null, sgp);
                                            slg=getlg(mo);   
             //                               JOptionPane.showMessageDialog(null, slg);
                                            float ps=gpa*(Float.parseFloat(s_courseCredit));
                                            sps=String.valueOf(ps);
               //                             JOptionPane.showMessageDialog(null, sps);                                        
                                            new database.DBshowTempTableOnAdmin().adminProjectInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, spres, sprv, sprf, smo, sgp, slg, s_courseCredit, sps);
                                    }
                                    else
                                    {
                                         new database.DBshowTempTableOnAdmin().adminProjectInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, "", "", "", "", "", "", "", "");
                                    }
                                }
                                
                            }
                            
                            t_projectresult.setVisible(false);
                             new database.DBshowTempTableOnAdmin().studentcougseShowProject(courseCode, s_courseSession, s_Admin_id);
                             t_projectresult.setVisible(true);
                        }
                    });
                }
                                                
                if(s_coursetype.compareTo("Thisis")==0)
                {
                    l_coursename.setText("Course Title: "+s_course_title);
                    l_courseID.setText("session:"+s_courseSession);
                    l_credit.setText("Credit:"+s_courseCredit);
                    l_thesis.add(jb_done_thesis);
                    l_thesis.add(l_coursename);
                    l_thesis.add(l_courseID);
                    l_thesis.add(l_credit);

                    l_thesis.setVisible(true);
                    new database.DBshowTempTableOnAdmin().studentcougseShowThesis(courseCode, s_courseSession, s_Admin_id);
                    jb_done_thesis.addActionListener(new ActionListener() 
                    {
                        public float getgpa(float mo)
                        {
                            if(mo>=80)
                                return 4.00f;
                            else if(mo>=75 && mo<80)
                                return 3.75f;
                            else if(mo>=70 && mo<75)
                                return 3.50f;
                            else if(mo>=65 && mo<70)
                                return 3.25f;
                            else if(mo>=60 && mo<65)
                                return 3.00f;
                            else if(mo>=55 && mo<60)
                                return 2.75f;
                            else if(mo>=50 && mo<55)
                                return 2.50f;
                            else if(mo>=45 && mo<50)
                                return 2.25f;
                            else if(mo>=40 && mo<45)
                                return 2.00f;
                            else
                                return 0.00f;
                        }
    
                        public String getlg(float mo)
                        {
                            if(mo>=80)
                                return "A+";
                            else if(mo>=75 && mo<80)
                                return "A";
                            else if(mo>=70 && mo<75)
                                return "A-";
                            else if(mo>=65 && mo<70)
                                return "B+";
                            else if(mo>=60 && mo<65)
                                return "B";
                            else if(mo>=55 && mo<60)
                                return "B-";
                            else if(mo>=50 && mo<55)
                                return "C+";
                            else if(mo>=45 && mo<50)
                                return "C";
                            else if(mo>=40 && mo<45)
                                return "D";
                            else
                                return "F";
                        }
                        @Override
                        public void actionPerformed(ActionEvent e) 
                        {
                            
                            int j=0,flag=0;
                            float mo,lq = 0,lv=0,lf=0,avg = 0;
                            String sid="",sname="", stsint="",stsex="",stspres="",smo="",sgp="",slg="",sps="";
                            new database.DBshowTempTableOnAdmin().adminTruncate(courseCode, s_courseSession, s_Admin_id);
                            for(int i=0;i<70;i++)
                            {
                                flag=0;
                                if(((t_thesisresult.getModel().getValueAt(i,j)).toString()).compareTo("")==0)
                                {
                                    break;
                                }
                                else
                                {//student_id,student_name,internal,external,presentation,mo,gp,lg,credit,ps
                                    sid=(t_thesisresult.getModel().getValueAt(i, j)).toString();
                                    sname=(t_thesisresult.getModel().getValueAt(i, j+1)).toString();
                                    stsint=(t_thesisresult.getModel().getValueAt(i, j+2)).toString();
                                    stsex=(t_thesisresult.getModel().getValueAt(i, j+3)).toString();
                                    stspres=(t_thesisresult.getModel().getValueAt(i, j+4)).toString();
                 //                   JOptionPane.showMessageDialog(null, stsint+" "+stsex+"  "+stspres);
                                    if(stsint.compareTo("")!=0 && stsex.compareTo("")!=0 && stspres.compareTo("")!=0)
                                    {
                                        lq=Float.parseFloat(stsint);
                                        lv=Float.parseFloat(stsex);
                                        lf=Float.parseFloat(stspres);
                                        mo=lq+lv+lf;
                                        smo=String.valueOf(mo);
                   //                     JOptionPane.showMessageDialog(null, smo);
                                            float gpa=getgpa(mo);
                                            sgp=String.valueOf(gpa);
                     //                       JOptionPane.showMessageDialog(null, sgp);
                                            slg=getlg(mo);   
//                                            JOptionPane.showMessageDialog(null, slg);
                                            float ps=gpa*(Float.parseFloat(s_courseCredit));
                                            sps=String.valueOf(ps);
  //                                          JOptionPane.showMessageDialog(null, sps);  
                                            
                                            new database.DBshowTempTableOnAdmin().adminThesisInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, stsint, stsex, stspres, smo, sgp, slg, s_courseCredit, sps);
                                    }
                                    else
                                    {
                                        new database.DBshowTempTableOnAdmin().adminThesisInsertRegular(courseCode, s_courseSession, s_Admin_id, sid, sname, "", "", "", "", "", "", "", "");
                                    }
                                }
                            }
                            
                            t_thesisresult.setVisible(false);
                             new database.DBshowTempTableOnAdmin().studentcougseShowThesis(courseCode, s_courseSession, s_Admin_id);
                             t_thesisresult.setVisible(true);
                        }
                    });
                }

        }
      });
        
        
    }
    
}
