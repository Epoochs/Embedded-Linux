import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class DayApp extends Applet implements Runnable
{

    public void init()
    {
        Thread th;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint(Graphics g)
    {
        Date date = new Date();
        g.drawString(date.toString(), 50, 100);
    }

    public void run()
    {
        while (true)
        {
            repaint();
        }
    }
    public static void main(String[]args)
    {

    }
}