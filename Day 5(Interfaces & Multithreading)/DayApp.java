import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class DayApp extends Applet
{

    public void init()
    {
        Thread th;
        th = new Thread(() -> {
            while(true)
            {
                repaint();
            try {
                Thread.sleep(1000); // Sleep for 1 second
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
        th.start();
    }

    @Override
    public void paint(Graphics g)
    {
        Date date = new Date();
        g.drawString(date.toString(), 50, 100);
    }
}