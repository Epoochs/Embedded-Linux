import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class MoveText extends Applet
{

    int x = 50;
    int y = 50;
    

    @Override
    public void init()
    {
        addKeyListener(new KeyListenerHandler());
        setBackground(Color.WHITE);
        setSize(800, 800);

        /* Applet screen must be focused for the keys to be listened
         *  1: Why is this necessary?
         * As the OS and Java need to know where to send the keys' events. So when the screen is focused the key events are sent to the active screen that is Applet.
        */
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawString("Ahmed Sherif" + x + " " + y, x, y);
    }

    public class KeyListenerHandler extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                x -= 10;
                break;
                case KeyEvent.VK_RIGHT:
                x += 10;
                break;
                case KeyEvent.VK_UP:
                y -= 10;
                break;
                case KeyEvent.VK_DOWN:
                y += 10;
                break;
                default:
                break;
            }
            repaint();
        }
    }
}