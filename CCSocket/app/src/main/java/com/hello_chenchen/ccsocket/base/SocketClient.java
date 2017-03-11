package com.hello_chenchen.ccsocket.base;

import android.os.Handler;
import android.os.Message;

import com.hello_chenchen.ccsocket.common.ICommonDefine;

import java.io.DataOutputStream;
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

    public void SendMsg(String strMsg) throws IOException {
        DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());

        dOut.writeByte(1);
        dOut.writeUTF(strMsg);
        dOut.flush(); // Send off the data

// Send the exit message
        dOut.writeByte(-1);
        dOut.flush();

        dOut.close();
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
            msg.what = CC_MAIN_TO_CLIENT_ACTIVITY;
            handler.sendMessage(msg);
        }

    }

}
