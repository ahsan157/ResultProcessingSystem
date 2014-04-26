package result.processing.system;

import javax.swing.SwingUtilities;

public class MainClass
{
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){

            @Override 
            public void run()
            {  
                         // new database.DBshowTempTableOnAdmin_Theory().adminTheoryInsertRegular("CSE2101", "2010_11", "1001", "CE11002", "Nayem", "17", "10", "27", "50", "50", "", "50", "77", "3.75", "A", "3", "12");
                new MainWindows().setVisible(true);
              // new tabulationShit().setVisible(true);
            }
        });
    }
}
