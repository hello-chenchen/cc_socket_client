package com.hello_chenchen.ccsocket.util;

import com.hello_chenchen.ccsocket.base.ICommonDefine;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Handler;

/**
 * Created by root on 17-1-30.
 * author: hello_chenchen
 */

public class SocketClient implements Runnable {

    private String ipAdress;    //socket连接ip
    private int port;           //socket连接port

    Handler handler;

    public SocketClient(String ipAdress, int port){
        this.ipAdress = ipAdress;
        this.port   = port;
    }

    @Override
    public void run() {

        try {
            Socket clientSocket = new Socket(ipAdress, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
