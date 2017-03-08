package com.hello_chenchen.ccsocket.activities;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

//        final String strIndex = getIntent().getStringExtra("index");
        clientSocket = (SocketClient) getIntent().getSerializableExtra("SocketClient");

        Button clientSend_btn = (Button)findViewById(R.id.sendMsgBtn);

        clientSend_btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

//                Toast.makeText(getApplicationContext(), strIndex, Toast.LENGTH_SHORT).show();

                String content = "chen";

                try {
                    clientSocket.SendMsg(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                try {
//                    clientSocket.SendMsg(content);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Message msg = new Message();
//                msg.what = 0x123;
//                msg.obj = content;
//                handler.sendMessage(msg);

            }
        });
    }
}
