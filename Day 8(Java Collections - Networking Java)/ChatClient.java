import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.plaf.basic.BasicMenuUI;

public class ChatClient
{
    public static void main(String[] args) {
        new ChatClient();
    }

    Socket client;
    DataInputStream in;
    PrintStream out;

    public ChatClient()
    {
        try{
            client = new Socket("localhost",1999);
            in = new DataInputStream(client.getInputStream());
            out = new PrintStream(client.getOutputStream());

            new ClientListens().start();

            BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
            String msg;

            while (true) {
                msg = text.readLine();
                out.println(msg);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public class ClientListens extends Thread
    {
        public void run()
        {
            try{
                while (true) {
                    String serverMsg = in.readLine();
                    System.out.println(serverMsg);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


}