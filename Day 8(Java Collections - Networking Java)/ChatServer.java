import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.plaf.basic.BasicMenuUI;


public class ChatServer 
{
    ServerSocket myServerSocket;


    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer()
    {
        try
        {
            myServerSocket = new ServerSocket(1999);

            while (true) { 
                Socket  mySocket = myServerSocket.accept();
                new ChatHandler();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static class ChatHandler extends Thread
    {
        DataInputStream in;
        DataOutputStream out;
        static Vector<ChatHandler> chaterConnects = new Vector<ChatHandler>();

        public ChatHandler(Socket chater)
        {
                try
                {
                    in = new DataInputStream(chater.getInputStream());
                    out = new DataOutputStream(chater.getOutputStream());
                    chaterConnects.add(this);
                    start();
                }catch(IOException ex)
                {
                    ex.printStackTrace();
                }

            public void run()
            {
                while (true) {
                    try
                    {
                        String msg = "";
                        msg = in.readLine();

                        for(int i = 0; i < chaterConnects.size(); i++)
                        {
                            chaterConnects[i].out.writeBytes(msg);
                        }


                    }catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}