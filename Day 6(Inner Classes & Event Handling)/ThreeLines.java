import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ThreeLines extends Applet
{
    boolean isDragging = false;

    private Lines[] line = new Lines[3];

    private int counter = 0;

    @Override
    public void init()
    {
        addMouseListener(new MousePressHandler());
        addMouseMotionListener(new MouseDragReleaseHandler());
    }

    @Override
    public void paint(Graphics g)
    {
        if (isDragging)
        {
            g.drawLine(line[counter].getX1(), line[counter].getY1(), line[counter].getX2(), line[counter].getY2());
        }

        for (int i = 0; i < counter; i++)
        {
            g.drawLine(line[i].getX1(), line[i].getY1(), line[i].getX2(), line[i].getY2());
        }
    }

    public class Lines
    {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public Lines() { }

        public Lines(int x1, int y1, int x2, int y2)
        {
            this.x1 = x1;
            this.y1 = y1; // Corrected here
            this.x2 = x2;
            this.y2 = y2;
        }

        public int getX1() 
        {
             return x1; 
        }
        public int getY1() 
        { 
            return y1; 
        }
        public int getX2() 
        { 
            return x2; 
        }
        public int getY2() 
        { 
            return y2; 
        }

        public void setX1(int x1)
        {
            this.x1 = x1;
        }
        public void setX2(int x2)
        {
            this.x2 = x2;
        }
        public void setY1(int y1)
        {
            this.y1 = y1;
        }
        public void setY2(int y2)
        {
            this.y2 = y2;
        }
    }

    public class MousePressHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            if (counter < 3)
            {
                line[counter] = new Lines();
                line[counter].setX1(e.getX());
                line[counter].setY1(e.getY());
                isDragging = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            if (counter < 3)
            {
                line[counter].setX2(e.getX());
                line[counter].setY2(e.getY());
                counter++;
                isDragging = false;
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
                line[counter].setX2(e.getX());
                line[counter].setY2(e.getY());
                repaint();
            }
        }
    }
}
