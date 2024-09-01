import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.plaf.basic.BasicMenuUI;

public class ChatServer
{
    public static void main(String[] args) {
        new ChatServer();
    }

    ServerSocket server;

    public ChatServer()
    {
        try{
            server = new ServerSocket(1999);

            while (true) {
                Socket serverClient = server.accept();
                System.out.println("Chat begins");
                new ChatThreads(serverClient);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static class ChatThreads extends Thread
    {
        static Vector <ChatThreads> ClientVector = new Vector<ChatThreads>();
        DataInputStream in;
        PrintStream out;

        public ChatThreads(Socket cs)
        {   
            try{
                in = new DataInputStream(cs.getInputStream());
                out = new PrintStream(cs.getOutputStream());
                ClientVector.add(this);
                start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public void run()
        {
            try{
                while(true){
                    String msg = in.readLine();
                    for (int i = 0; i < ClientVector.size(); i++) {
                        ClientVector.get(i).out.println(msg);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}