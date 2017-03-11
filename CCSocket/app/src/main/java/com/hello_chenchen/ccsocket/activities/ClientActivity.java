package com.hello_chenchen.ccsocket.activities;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.base.SocketClient;
import com.hello_chenchen.ccsocket.base.SocketManage;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Handler;

public class ClientActivity extends AppCompatActivity implements Serializable {

    private SocketManage socketManage;
//    private SocketClient socketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        String strSocketIndex = getIntent().getStringExtra("clientSocket");

        Toast.makeText(getApplication(), strSocketIndex, Toast.LENGTH_SHORT).show();

        int socketIndex = Integer.parseInt(strSocketIndex);

        socketManage = (SocketManage)getApplication();
        final SocketClient socketClient = socketManage.GetSocketClient(socketIndex);


        Button clientSend_btn = (Button)findViewById(R.id.sendMsgBtn);

        clientSend_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                String content = "chen";

                try {
                    socketClient.SendMsg(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                Message msg = new Message();
//                msg.what = 0x123;
//                msg.obj = content;
//                handler.sendMessage(msg);

            }
        });
    }
}
