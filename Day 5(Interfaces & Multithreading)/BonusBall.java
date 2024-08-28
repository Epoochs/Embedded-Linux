import java.awt.*;
import java.applet.Applet;


public class BonusBall extends Applet implements Runnable
{
    private int x;
    private int y;
    private int x2;
    private int y2;
    private boolean flag;
    private boolean flag2;

    @Override
    public void init()
    {
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void paint(Graphics g)
    {   
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50);

        g.setColor(Color.RED);
        g.fillOval(x2, y2, 50, 50);
    }

    @Override
    public void run()
    {
        while(true)
        {
            
        }        
    }
}