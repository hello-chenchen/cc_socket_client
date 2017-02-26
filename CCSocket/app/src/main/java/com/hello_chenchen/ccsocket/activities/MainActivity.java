package com.hello_chenchen.ccsocket.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toast;

import com.hello_chenchen.ccsocket.business.GameTime;
import com.hello_chenchen.ccsocket.common.ICommonDefine;
import com.hello_chenchen.ccsocket.base.SocketClient;

/**
 * author: hello_chenchen
 */

public class MainActivity extends AppCompatActivity implements ICommonDefine{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_btn = (Button)findViewById(R.id.connect_btn);
        final Button notification_btn = (Button)findViewById(R.id.notification_btn);
        final NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        final PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        final Context context = this;

        GameTime gameTime = new GameTime(context);

        notification_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "默认Toast样式",
                        Toast.LENGTH_SHORT).show();
                GameTime gameTime = new GameTime(context);
            }
        });

        connect_btn.setOnClickListener(new View.OnClickListener() {
            String ipAdress = null;
            int port = CC_INIT;

            @Override
            public void onClick(View v) {
                onInit();

                SocketClient client = new SocketClient(ipAdress, port);
                Thread clientThread = new Thread(client);
                clientThread.start();

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
