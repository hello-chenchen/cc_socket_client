package com.hello_chenchen.ccsocket.base;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Handler;

/**
 * Created by root on 17-1-30.
 * author: hello_chenchen
 */

public class SocketClient extends Thread {

    private String ipAdress;    //socket连接ip
    private int port;           //socket连接port
    private Socket clientSocket;    //客户端socket
    private Handler handler;
    private boolean blIsConnected;

    /**
     * @param IpAdress
     * @param Port
     */
    public SocketClient(String IpAdress, int Port){
        super();
        this.ipAdress = IpAdress;
        this.port   = Port;

        try {
            clientSocket = new Socket(this.ipAdress, this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.start();
    }

    public void SetHandler(Handler handler)
    {
        this.handler = handler;
    }

    public boolean IsConnected()
    {

        if(clientSocket.isConnected())
        {
            blIsConnected = true;
        }
        else
        {
            blIsConnected = false;
        }

        return blIsConnected;

    }

    public boolean WriteBuffer()
    {
        return true;
    }

    @Override
    public void run() {


    }

//    private void ReceiveMsg(Socket socket)
//    {
//        DataInputStream input;
//
//        try {
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (true){
//
//        }
//    }

}
