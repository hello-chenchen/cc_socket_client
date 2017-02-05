package com.hello_chenchen.ccsocket.util;

import com.hello_chenchen.ccsocket.base.ICommonDefine;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by root on 17-1-30.
 */

public class SocketClient implements ICommonDefine {

    public int Connect(String ipAdress, int port)
    {
        try {
            Socket clientSocket = new Socket(ipAdress, port);
        } catch (IOException e) {
            e.printStackTrace();
            return CC_FAIL;
        }

        return CC_SUCCESS;
    }
}
