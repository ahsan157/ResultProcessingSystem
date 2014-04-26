package result.processing.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;


public class ShowTime
{
    ShowTime()
    {
        ActionListener timerListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String time = MainWindows.timeFormat.format(date);
                MainWindows.timeLabel.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        MainWindows.timeLabel.setBounds(990, 645, 350, 50);
        MainWindows.timeLabel.setFont(new Font("arial",Font.BOLD, 22));
        MainWindows.timeLabel.setForeground(Color.DARK_GRAY);
        
    }
}
