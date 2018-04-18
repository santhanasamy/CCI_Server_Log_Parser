package com.santhana.logger.remote;

import java.io.*;
import java.net.*;

public class RemoteSocketClient {


    /*private static final int TIME_OUT = 2000;
    private static final String SERVER = "10.101.130.4";//"ftpserver";
    private static final int PORT = 5555;

    private Socket mSocket;
    private String filename = "C:/Users/dsadmin/AppData/Local/CCiServer/log/CCiServer.log";
    private String command = "tail -50 " + filename + "\n";

    public static void main(String[] args) {
        new RemoteSocketClient();
    }

    public RemoteSocketClient() {
        openSocket();
        try {
            // write to socket
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            wr.write(command);
            wr.flush();

            // read from socket
            BufferedReader rd = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            String str;
            while ((str = rd.readLine()) != null) {
                System.out.println(str);
            }
            rd.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void openSocket() {
        try {
            InetSocketAddress lAddress = new InetSocketAddress(SERVER, PORT);
            mSocket = new Socket();
            mSocket.connect(lAddress, TIME_OUT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
