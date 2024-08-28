import java.awt.*;
import java.awt.Font;
import java.applet.*;
import java.awt.Toolkit;

public class Fonty extends Applet
{
    private int line;

    @Override
    public void paint(Graphics g)
    {
        /* We use this class cause the (getFont) method is depricated*/
        GraphicsEnvironment t = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] s = t.getAvailableFontFamilyNames();

      for(int i = 0; i < 5; i++)
      {
        g.setFont(new Font(s[i],Font.PLAIN,12));
        g.drawString(s[i], 10, line+=20);
      }

    }
}