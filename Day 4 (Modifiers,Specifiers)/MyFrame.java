import java.applet.Applet;
import java.awt.*; 

 
public class MyFrame extends Applet { 

    public void paint(Graphics g)
    {
        // Drawing the hat
        g.setColor(Color.YELLOW);
        g.fillOval(150, 50, 100, 50);
        g.setColor(Color.BLACK);
        g.drawLine(150, 75, 130, 170);
        g.drawLine(250, 75, 270, 170);
        g.drawArc(130, 143, 140, 50, 0, -180);

        // Decoration
        g.setColor(Color.YELLOW);
        g.fillOval(140, 110, 30, 50);
        g.fillOval(230, 110, 30, 50);
        g.fillOval(175, 110, 50, 70);

        // Drawing the base
        g.setColor(Color.BLACK);
        g.drawLine(220, 193, 240, 220);
        g.drawLine(180, 193, 160, 220);
        g.drawRoundRect(140, 220, 120, 20, 0, -45);

    }
    public static void main(String[] args) 
    { 
    } 
}