package com.hello_chenchen.ccsocket.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hello_chenchen.ccsocket.base.ICommonDefine;
import com.hello_chenchen.ccsocket.util.SocketClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_btn = (Button)findViewById(R.id.connect_btn);

        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EditText ipAdress_edt = (EditText)findViewById(R.id.ipAddress);
//                final String ipAdress = ipAdress_edt.toString();
//                EditText port_edt = (EditText)findViewById(R.id.port);
//                String portTemp = port_edt.toString();
//        String demo = "23344";
//        int age = Integer.parseInt(demo);
//                final int port = Integer.parseInt(portTemp);

                Toast.makeText(getApplicationContext(), "1",
                        Toast.LENGTH_SHORT).show();
                SocketClient client = new SocketClient();
                Toast.makeText(getApplicationContext(), "2",
                        Toast.LENGTH_SHORT).show();
                int ret = client.Connect("192.168.1.102", 5000);
                Toast.makeText(getApplicationContext(), "" + ret,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
