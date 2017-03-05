package com.hello_chenchen.ccsocket.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.common.ICommonDefine;
import com.hello_chenchen.ccsocket.base.SocketClient;

/**
 * author: hello_chenchen
 * jdk_version:1.8_0111
 */

public class MainActivity extends AppCompatActivity implements ICommonDefine{
//    private Socket clientSocket;    //客户端socket
//    private Handler handler;

    private void Main2ClientActivity()
    {
                Intent intent=new Intent(MainActivity.this,ClientActivity.class);
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

            @Override
            public void onClick(View v) {
                onInit();
                final Handler handler;
                handler = new Handler() {

                    @Override
                    public void handleMessage(Message msg){
                        switch(msg.what)
                        {
                            case 0x001:
                                Main2ClientActivity();
                                break;
                            default:
                                break;
                        }
                    }
                };

                SocketClient clientSocket = new SocketClient(ipAdress, port, handler);

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
