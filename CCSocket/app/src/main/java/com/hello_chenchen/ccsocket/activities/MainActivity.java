package com.hello_chenchen.ccsocket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.common.ICommonDefine;
import com.hello_chenchen.ccsocket.base.SocketClient;

import java.io.Serializable;
import java.net.Socket;

/**
 * author: hello_chenchen
 * jdk_version:1.8_0111
 */

public class MainActivity extends AppCompatActivity implements Serializable,ICommonDefine{
    private SocketClient clientSocket;    //客户端socket
    private Handler handler;

    private void Main2ClientActivity()
    {
                Intent intent=new Intent(this,ClientActivity.class);
                intent.putExtra("SocketClient", clientSocket);
//                intent.putExtra("index", "1");
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("clientSocket", (SocketClient) clientSocket);
                startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_btn = (Button)findViewById(R.id.connect_btn);

        connect_btn.setOnClickListener(new View.OnClickListener() {
            String ipAdress = null;
            int port = CC_INIT;
//            SocketClient clientSocket;

            @Override
            public void onClick(View v) {
                onInit();
//                final Handler handler;
                handler = new Handler() {

                    @Override
                    public void handleMessage(Message msg){
                        switch(msg.what)
                        {
                            case CC_MAIN_TO_CLIENT_ACTIVITY:
                                Main2ClientActivity();
                                break;
                            default:
                                break;
                        }
                    }
                };

                clientSocket = new SocketClient(ipAdress, port, handler);
                Toast.makeText(getApplicationContext(), "ccc", Toast.LENGTH_SHORT).show();

            }

            private void onInit()
            {
                EditText ipAdress_edt = (EditText)findViewById(R.id.ipAddress);
                EditText port_edt = (EditText)findViewById(R.id.port);

                ipAdress = ipAdress_edt.getText().toString();
                String portTemp = port_edt.getText().toString();
                port = Integer.parseInt(portTemp);
            }
        });
    }
}
