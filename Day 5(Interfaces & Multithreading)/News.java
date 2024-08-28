import java.applet.Applet;
import java.awt.*;
import java.util.Date;


public class News extends Applet implements Runnable
{
    private int x;

    @Override
    public void init()
    {
        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g)
    {
        g.drawString("Ahmed Sherif", x, 100);
    }

    @Override
    public void run()
    {
        while(true)
        {
            try{
            x++;
            if(x == 400)
            {
                x = 0;
            }
            Thread.sleep(10);
            repaint();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[]args)
    {

    }
}