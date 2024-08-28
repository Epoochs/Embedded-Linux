import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class DragBall extends Applet
{
    int x1;
    int y1;

    @Override
    public void init()
    {
        addMouseListener(new MouseListenHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }
    @Override
    public void paint(Graphics g)
    {
        g.fillOval(x1, y1, 50, 50);
    }

    public class MouseListenHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {

        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            x1 = e.getX();
            y1 = e.getY();
            repaint();
        }
    }

    public class MouseMotionHandler extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            x1 = e.getX();
            y1 = e.getY();
            repaint();
        }
    }
}