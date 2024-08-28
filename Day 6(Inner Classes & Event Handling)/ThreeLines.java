import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class ThreeLines extends Applet
{
    private int[] x1 = new int[3];
    private int[] y1 = new int[3];
    private int[] x2 = new int[3];
    private int[] y2 = new int[3];
    boolean isDragging = false;

    private int counter;

    private Thread[] ThreadsContainer = new Thread[3];
    Thread t1;
    Thread t2;
    Thread t3;

    @Override
    public void init()
    {
        addMouseListener(new MousePressHandler());
        addMouseMotionListener(new MouseDragReleaseHandler());
    }

    @Override
    public void paint(Graphics g)
    {

        if(isDragging)
        {
            g.drawLine(x1[counter], y1[counter], x2[counter], y2[counter]);
        }


        for(int i = 0; i < counter; i++)
        {
            g.drawLine(x1[i], y1[i], x2[i], y2[i]);
        }
    }
    
    public class Lines implements Runnable
    {
        @Override
        public void run()
        {
            while(true)
            {

                repaint();

                try{
                Thread.sleep(500);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public class MousePressHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            if(counter < 3)
            {
                x1[counter] = e.getX();
                y1[counter] = e.getY();
                x2[counter] = x1[counter];
                y2[counter] = y1[counter];
                isDragging = true;
            }
            else
            {
                // Do nothing
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            if(counter < 3)
            {
                x2[counter] = e.getX();
                y2[counter] = e.getY();
                isDragging = false;
                counter++;
            }
            else
            {
                // Do nothing
            }
           
        }
    } 

    public class MouseDragReleaseHandler extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            if (counter < 3)
            {
                x2[counter] = e.getX();
                y2[counter] = e.getY();
                ThreadsContainer[counter] = new Thread(new Lines());
                ThreadsContainer[counter].start();
            }
            else
            {
                // Nothing
            }
        }      
    }
}