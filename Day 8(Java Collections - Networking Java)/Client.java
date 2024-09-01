import java.net.*;
import java.util.*;
import java.io.*;


public class Client
{
    public static void main(String[]args)
    {
        new Client();
    }


    private Socket client;
    private DataInputStream in;
    private PrintStream out;

    public Client()
    {
        try
        {
            client = new Socket("localhost", 1999);
            in = new DataInputStream(System.in);
            out = new PrintStream(client.getOutputStream());
            out.println(in.readLine());
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {   
            try{
                client.close();
                in.close();
                out.close();
            }catch(Exception E)
            {
                E.printStackTrace();
            }
        }

    }
}
