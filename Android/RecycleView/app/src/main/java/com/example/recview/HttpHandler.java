package com.example.recview;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {

    public String getConnect(String urlIn){
        String res = "";

        try {
            /* Connect to the webSite */
            URL url = new URL(urlIn);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            /* Reading the Streams that connection had
            * BufferedInputStreams: we use it to save the streams into an internal buffer which, in returns, make the reading happends on the buffer not the original source
            * This is safe if the connection to the internet is not stable or secured
            * */
            InputStream in = new BufferedInputStream(connection.getInputStream());

            /* Converting the streams to Strings */
            res = convertStreamToString(in);

            /* Closing Stream and Disconnect to the server */
            in.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }



    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter("Desktop");
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }
}
