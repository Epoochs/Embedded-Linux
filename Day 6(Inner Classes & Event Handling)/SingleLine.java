import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SingleLine extends Applet
{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Override
    public void init()
    {
        addMouseListener(new MousePressHandler());
        addMouseMotionListener(new MouseDragReleaseHandler());
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawString("Pressed at: " + "(" + x1 + "," + y1 + ")", 10, 10);
        g.drawString("Released at: " + "(" + x2 + "," + y2 + ")", 10 , 20);
        g.drawLine(x1, y1, x2, y2);
    }



    public class MousePressHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }

    public class MouseDragReleaseHandler extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
}