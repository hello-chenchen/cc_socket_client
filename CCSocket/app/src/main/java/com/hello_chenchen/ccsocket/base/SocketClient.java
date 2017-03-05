package com.hello_chenchen.ccsocket.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.activities.ClientActivity;
import com.hello_chenchen.ccsocket.activities.MainActivity;
import com.hello_chenchen.ccsocket.common.ICommonDefine;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

/**
 * Created by root on 17-1-30.
 * author: hello_chenchen
 */

public class SocketClient extends Thread implements Serializable,ICommonDefine {

    private String ipAdress;    //socket连接ip
    private int port;           //socket连接port
    private Socket clientSocket;    //客户端socket
    private Handler handler;
    private boolean blIsConnected;

    /**
     * @param IpAdress
     * @param Port
     */
    public SocketClient(String IpAdress, int Port, Handler handler){
        super();
        this.ipAdress = IpAdress;
        this.port   = Port;
        this.handler = handler;

        this.start();
    }

    public void SetHandler(Handler handler)
    {
        this.handler = handler;
    }

    public boolean IsSocketConnected()
    {
        return blIsConnected;
    }

    public boolean WriteBuffer()
    {
        return true;
    }

    @Override
    public void run() {
        try {
            clientSocket = new Socket(this.ipAdress, this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(clientSocket.isConnected())
        {
            System.out.print(true);
            Message msg = new Message();
            msg.what = 0x001;
            handler.sendMessage(msg);
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
