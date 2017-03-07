package com.hello_chenchen.ccsocket.activities;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hello_chenchen.ccsocket.base.SocketClient;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Handler;

public class ClientActivity extends AppCompatActivity implements Serializable {

    private SocketClient clientSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        this.clientSocket = (SocketClient) getIntent().getSerializableExtra("clientSocket");


        Button clientSend_btn = (Button)findViewById(R.id.sendMsgBtn);

        clientSend_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                String content = "chen";

                try {
                    clientSocket.SendMsg(content);
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
