package com.hello_chenchen.ccsocket.base;

import android.app.Application;

import com.hello_chenchen.ccsocket.base.SocketClient;

import java.util.HashMap;

/**
 * Created by root on 17-2-15.
 * jdk_versio:1.8
 */
public class SocketManage extends Application {

    private HashMap<Integer , SocketClient> socketMamageMap;

    public SocketManage()
    {
        socketMamageMap = new HashMap<Integer, SocketClient>();
    }

    public void AddSocketClient(int key, SocketClient socketClient)
    {
        SocketClient clientSocket = socketClient;

        Integer itKey = new Integer(key);
        socketMamageMap.put(itKey, socketClient);
    }

    public SocketClient GetSocketClient(int key)
    {
        Integer itKey = new Integer(key);
        SocketClient ret = socketMamageMap.get(itKey);
        return ret;
    }
}
