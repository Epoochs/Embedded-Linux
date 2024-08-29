import java.net.*;
import java.util.*;
import java.io.*;



public class Client {

    Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;


    public static void main(String[]args)
    {
        new Client();
    }


    public Client()
    {
        try{
        clientSocket = new Socket("127.0.0.1",1999);
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        out.writeBytes("Hello Server" + "\n");

        String msg = in.readLine();
        System.out.println("Server says:" + msg);


        }catch(IOException ex)
        {
            ex.printStackTrace();
        }finally
        {
            try {
                in.close();
                out.close();
                clientSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }



}
