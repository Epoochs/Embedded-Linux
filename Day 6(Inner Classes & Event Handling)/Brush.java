import java.applet.Applet;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.*;
import java.util.ArrayList;

abstract class Shape
{
   /* Dimensions of the Shapes */ 
   protected  int x1;
   protected  int y1;
   protected  int x2;
   protected  int y2;

/* Setting the color of the Shpaes */
   protected  Color c;

/* Fill State */
   protected  boolean Fill_s; 

/* Decide upon checking the fill box */
/* Draw Methods */
   public abstract void draw(Graphics g);

   /* Setters */
   public void setColor(Color col)
   {
        c = col;
   }

   public abstract void SetCoordinates(int xC1, int yC1, int xC2, int yC2);

      public void setFill(boolean fill) {
        Fill_s = fill;
    }


   /* Getters */
   public abstract int getX1();
   public abstract int getX2();
   public abstract int getY1();
   public abstract int getY2();
}

class Rectangle extends Shape
{
    /* Destructors */
    public Rectangle() {
        c = new Color(0,0,0);
    }

    public Rectangle(Color col)
    {
        c = col;
    }

    public Rectangle(Color col, int xC1, int yC1, int xC2, int yC2)
    {
        c = col;

        x1 = xC1;
        y1 = yC1;
        x2 = xC2 - xC1;
        y2 = yC2 - yC1;

    }

    /* Draw Methods */
    @Override
    public void draw(Graphics g)
    {
        if(Fill_s)
        {
          g.setColor(c);
          g.fillRect(x1, y1, x2, y2);
        }
        else
        {
            g.setColor(c);
            g.drawRect(x1, y1, x2, y2);
        }
    }

    @Override
    public void SetCoordinates(int xC1, int yC1, int xC2, int yC2)
    {
        x1 = Math.min(xC1,xC2);
        y1 = Math.min(yC1,yC2);
        x2 = Math.abs(xC2 - xC1);
        y2 = Math.abs(yC2 - yC1);
    }

    @Override
    public int getX1()
    {
        return x1;
    }

    @Override
    public int getX2()
    {
        return x2;
    }

    @Override
    public int getY1()
    {
        return y1;
    }

    @Override
    public int getY2()
    {
        return y2;
    }
}
class Line extends Shape
{

    /* Destructors */
    public Line()
    {

    }

    public Line(Color col, int xC1, int yC1, int xC2, int yC2)
    {
        c = col;

        x1 = xC1;
        y1 = yC1;
        x2 = xC2;
        y2 = yC2;

    }

    /* Draw Methods */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(c);
        g.drawLine(x1, y1, x2, y2);
    }
    /* Setters */
      @Override
    public void SetCoordinates(int xC1, int yC1, int xC2, int yC2)
    {
        x1 = xC1;
        y1 = yC1;
        x2 = xC2;
        y2 = yC2;
    }

    /* Getters */

    @Override
    public int getX1()
    {
        return x1;
    }

    @Override
    public int getX2()
    {
        return x2;
    }

    @Override
    public int getY1()
    {
        return y1;
    }

    @Override
    public int getY2()
    {
        return y2;
    }
}
class Oval extends Shape
{
    /* Destructors */
    public Oval()
    {
        c = new Color(0,0,0);
    }

    public Oval(Color col)
    {
        c = col;
    }

    public Oval(Color col, int xC1, int yC1, int xC2, int yC2)
    {
        c = col;

        x1 = xC1;
        y1 = yC1;
        x2 = xC2 - xC1;
        y2 = yC2 - yC1;

    }

    /* Draw Methods */
    @Override
    public void draw(Graphics g)
    {
        if(Fill_s)
        {
            g.setColor(c);
            g.fillOval(x1, y1, x2, y2);
        }
        else
        {
            g.setColor(c);
            g.drawOval(x1, y1, x2, y2);
        }
    }

    /* Setters */
    @Override
    public void SetCoordinates(int xC1, int yC1, int xC2, int yC2)
    {
        x1 = Math.min(xC1,xC2);
        y1 = Math.min(yC1,yC2);
        x2 = Math.abs(xC2 - xC1);
        y2 = Math.abs(yC2 - yC1);
    }

    /* Getters */
    @Override
    public int getX1()
    {
        return x1;
    }

    @Override
    public int getX2()
    {
        return x2;
    }

    @Override
    public int getY1()
    {
        return y1;
    }

    @Override
    public int getY2()
    {
        return y2;
    }
}


public class Brush extends Applet{

    /* To get the first point from the mousePress event */
    int x;
    int y;
    int x1;
    int y1;

    /* Drawing the Shapes */
    Button DrawLine_b;
    Button DrawOval_b;
    Button DrawRect_b;
    Button Undo_b;
    String currentShape_t = "Line";

    /* Free-Hand Button */
    Button FreeHand_b;
    boolean Free_s = true;

    /* Coloring the Shapes */
    Choice ColorBrush_b;
    Color color_s = Color.BLACK;

    /* Clearing Options */
    Button ClearWindow_b;
    Button Eraser_b;

    /* Deciding either on Filling the Shapes or Not */
    Checkbox FillorNoFill_b;
    boolean fill_s;

    /* Shapes' list */

    ArrayList<Shape>shapes = new ArrayList<Shape>();
    Shape currentShape = null;

    @Override
    public void init()
    {
        /* Line Button */
        DrawLine_b = new Button("Line");
        DrawLine_b.addActionListener(new LineButtonHandler());
        add(DrawLine_b);
        
        /* Oval Button */
        DrawOval_b = new Button("Oval");
        DrawOval_b.addActionListener(new OvelButtonHandler());
        add(DrawOval_b);

        /* Rectangle Button */
        DrawRect_b = new Button("Rectangle");
        DrawRect_b.addActionListener(new RectButtonHandler());
        add(DrawRect_b);

        /* Undo Button */
        Undo_b = new Button("Undo");
        Undo_b.addActionListener(new UndoButtonHandler());
        add(Undo_b);

        /* Clearing Window */
        ClearWindow_b = new Button("Clear");
        ClearWindow_b.addActionListener(new ClearButtonHandler());
        add(ClearWindow_b);

        /* Erasing Specific Parts Button */
        Eraser_b = new Button("Eraser");
        Eraser_b.addActionListener(new EraserButtonHandler());
        add(Eraser_b);

        /* Free-Hand Button to doddle the dragging option */
        FreeHand_b = new Button("FreeHand");
        FreeHand_b.addActionListener(new FreeButtonHandler());
        add(FreeHand_b);

        /* Fill-or-Not-to-fill Checkbox */
        FillorNoFill_b = new Checkbox("Fill");
        FillorNoFill_b.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fill_s = FillorNoFill_b.getState();
            }
        });
        add(FillorNoFill_b);

        /* Color Choices */
        ColorBrush_b = new Choice();
        ColorBrush_b.add("Red");
        ColorBrush_b.add("Green");
        ColorBrush_b.add("Blue");
        ColorBrush_b.add("Black");
        ColorBrush_b.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch (ColorBrush_b.getSelectedItem()) {
                    case "Red":
                        color_s = Color.RED;
                        break;
                    case "Green":
                        color_s = Color.GREEN;
                        break;
                    case "Blue":
                        color_s = Color.BLUE;
                        break;
                    case "Black":
                        color_s = Color.BLACK;
                        break;
                    default:
                        color_s = Color.BLACK;
                        break;
                }
            }
        });
        add(ColorBrush_b);

        setBackground(Color.WHITE);
        setSize(800, 800);
    }

    @Override
    public void paint(Graphics g)
    {
        for(Shape sh : shapes)
        {
            sh.draw(g);
        }
    }
    public class MousePressHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            x = e.getX();
            y = e.getY();

            if (currentShape_t.equals("Line")) 
            {
                currentShape = new Line(color_s, x, y, x, y);
            } 
            else 
            {
                if (currentShape_t.equals("Oval")) 
                {
                    currentShape = new Oval(color_s, x, y, x, y);
                } 
                else 
                {
                    if (currentShape_t.equals("Rectangle")) 
                    {
                        currentShape = new Rectangle(color_s, x, y, x, y);
                    }
                    else
                    {
                        if (currentShape_t.equals("Eraser"))
                        {
                            currentShape = new Rectangle(color_s, x, y, x, y);
                        }
                    }
                }
            }

            if (currentShape != null) 
            {
                if(currentShape_t.equals("Eraser"))
                {
                    currentShape.setColor(Color.white);
                    currentShape.setFill(true);
                }
                else
                {
                    currentShape.setColor(color_s);
                    currentShape.setFill(fill_s);
                }
                shapes.add(currentShape);
            }
        }
    }
    public class MouseDragReleaseHandler extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            x1 = e.getX();
            y1 = e.getY();

            if(currentShape != null)
            {
                currentShape.SetCoordinates(x, y, x1, y1);
                repaint();
            }

        }
    }
    public class LineButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            addMouseListener(new MousePressHandler());
            addMouseMotionListener(new MouseDragReleaseHandler());
            currentShape_t = "Line";
        }
    }
     public class OvelButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            currentShape_t = "Oval";   
        }
    }
     public class RectButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            currentShape_t = "Rectangle";
        }
    }

     public class FreeButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Free_s = !Free_s;

            if (Free_s) 
            {
                addMouseListener(new MousePressHandler());
                addMouseMotionListener(new MouseDragReleaseHandler());
            } 
            else 
            {
                removeMouseListener(new MousePressHandler());
                removeMouseMotionListener(new MouseDragReleaseHandler());
            }
        }

    }
    
     public class ClearButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            shapes.clear();
            repaint();
        }
    }

     public class EraserButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            currentShape_t = "Eraser";
        }
    }

    public class UndoButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (!shapes.isEmpty())
            {
                shapes.remove(shapes.size() - 1);
                repaint();
            }
        }
    }
}