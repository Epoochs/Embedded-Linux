import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ButtonHandler extends Applet{

    private int counter;
    private Button button1;
    private Button button2;


    @Override
    public void init(){
        button1 = new Button("+");
        button2 = new Button("-");

        button1.addActionListener(new ButtonListener1());
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent b2)
            {
                counter--;
                repaint();
            }
        });

        add(button1);
        add(button2);
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawString(""+counter, 50, 100);
    }

    class ButtonListener1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent b1)
        {
            counter++;
            repaint();
        }
    }
}