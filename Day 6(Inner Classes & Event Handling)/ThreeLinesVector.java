import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class ThreeLinesVector extends Applet {
    private Vector<Integer> x1 = new Vector<Integer>();
    private Vector<Integer> y1 = new Vector<Integer>();
    private Vector<Integer> x2 = new Vector<Integer>();
    private Vector<Integer> y2 = new Vector<Integer>();
    boolean isDragging = false;

    private int counter;

    private Vector<Thread> ThreadsContainer = new Vector<Thread>(3);

    @Override
    public void init() {
        addMouseListener(new MousePressHandler());
        addMouseMotionListener(new MouseDragReleaseHandler());
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {

        if(isDragging)
        {
            g.drawLine(x1.get(counter), y1.get(counter), x2.get(counter), y2.get(counter));
        }

        for (int i = 0; i < counter; i++) {
            g.drawLine(x1.get(i), y1.get(i), x2.get(i), y2.get(i));
        }
    }

    public class Lines implements Runnable {
        @Override
        public void run() {
            while (true) {
                repaint();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class MousePressHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (counter < 3) {
                x1.add(e.getX());
                y1.add(e.getY());
                x2.add(x1.get(counter));
                y2.add(y1.get(counter));
                isDragging = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (counter < 3) {
                x2.add(e.getX());
                y2.add(e.getY());
                isDragging = false;
                counter++;
            }
        }
    }

    public class MouseDragReleaseHandler extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (counter < 3) {
                x2.set(counter, e.getX());
                y2.set(counter, e.getY());
                Thread thread = new Thread(new Lines());
                ThreadsContainer.add(thread);
                thread.start();
            }
        }
    }
}
