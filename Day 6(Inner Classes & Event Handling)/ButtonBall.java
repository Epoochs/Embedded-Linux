import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ButtonBall extends Applet
{
	private int x;
	private int y;
	private Button pauseB;
    private Button startB;
    private boolean isSuspend;
	private boolean isStart;
    Thread t;

	@Override
	public void init()
	{
        startB = new Button("start");
        pauseB = new Button("pause");
        t = new Thread(new Ball());

        startB.addActionListener(new ButtonHandler());
        pauseB.addActionListener(new ButtonHandler());

        add(startB);
        add(pauseB);
	}
	@Override
	public void paint(Graphics g)
	{
		g.fillOval(x, y, 50, 50);
	}

	public class Ball implements Runnable
	{
	    private boolean flagX = true;
	    private boolean flagY = true;

	    @Override
	    public void run()
	    {
	        while(true)
	        {
	            try{
	/* -------------------------------------(X-Coordinates)------------------------------------------------------ */
	                if(flagX)
	                {
	                    x++;
	                }
	                else{
	                    x--;
	                }
	                if(x == 350)
	                {
	                    flagX = false;
	                }
	                if(x == 0)
	                {
	                    flagX = true;
	                }
	/* -------------------------------------(Y-Coordinates)------------------------------------------------------ */
	                if(flagY)
	                {
	                    y++;
	                }
	                else
	                {
	                    y--;
	                }
	                if(y == 300)
	                {
	                    flagY = false;
	                }
	                if(y == 0)
	                {
	                    flagY = true;
	                }
	/* --------------------------------(Implementation of Thread)------------------------------------------------- */
	                Thread.sleep(10);
	                repaint();
	                }catch(InterruptedException e)
	                {
	                    e.printStackTrace();
	                }
	        }
	    }
	}

	class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent b1)
        {
			if(b1.getSource() == startB)
			{
				if(!isStart)
        		{
        			t.start();
        			isStart = true;
        		}
        		else
        		{
        			if(isSuspend)
        			{
        				t.resume();
        				isSuspend = false;
        			}
        		}
			}
			else
			{
				if(!isSuspend && isStart)
        		{
        			t.suspend();
        			isSuspend = true;
        		}
        		else
        		{
        			// Nothing
        		}
			}
        }
    }
}