import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.plaf.basic.BasicMenuUI;


public class Server 
{
    ServerSocket myServerSocket;
    Socket server;
    DataInputStream in;
    PrintStream out;


    public static void main(String[] args) {
        new Server();
    }

    public Server()
    {
        try
        {
            System.out.println("Connecting...");
            myServerSocket = new ServerSocket(1999);
            server = myServerSocket.accept();
            System.out.println("Connection established successfully");
            in = new DataInputStream(server.getInputStream());
            out = new PrintStream(server.getOutputStream());

            System.out.println("Message is: " + in.readLine());
            
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                myServerSocket.close();
                server.close();
                in.close();
                out.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}