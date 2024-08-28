import java.applet.Applet;
import java.awt.*;
import java.util.Date;


public class Ball extends Applet implements Runnable
{
    private int x;
    private int y;
    private boolean flagX = true;
    private boolean flagY = true;

    @Override
    public void init()
    {
        Thread t = new Thread(this);
        t.start();
    }
    @Override
    public void paint(Graphics g)
    {
        g.fillOval(x, y, 50, 50);
    }

    @Override
    public void run()
    {
        while(true)
        {
            try{
/* -------------------------------------(X-Coordinates)------------------------------------------------------ */
                if(flagX)
                {
                    x++;
                }
                else{
                    x--;
                }
                if(x == 350)
                {
                    flagX = false;
                }
                if(x == 0)
                {
                    flagX = true;
                }
/* -------------------------------------(Y-Coordinates)------------------------------------------------------ */
                if(flagY)
                {
                    y++;
                }
                else
                {
                    y--;
                }
                if(y == 300)
                {
                    flagY = false;
                }
                if(y == 0)
                {
                    flagY = true;
                }
/* --------------------------------(Implementation of Thread)------------------------------------------------- */
                Thread.sleep(10);
                repaint();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }
}