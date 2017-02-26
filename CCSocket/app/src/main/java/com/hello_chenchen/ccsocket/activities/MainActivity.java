package com.hello_chenchen.ccsocket.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
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

    private void send(String string) {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent, 0);
        mBuilder.setContentIntent(pendingIntent);// 设置通知栏点击意图

        mBuilder.setContentTitle("标题");// 设置通知栏标题

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//悬挂式Notification，5.0后显示

            mBuilder.setContentText(string + "点击查看。").setFullScreenIntent(pendingIntent, true);
            mBuilder.setCategory(NotificationCompat.CATEGORY_MESSAGE);
            mBuilder.setSmallIcon(R.drawable.notification_icon);// 设置通知小ICON（5.0必须采用白色透明图片）

        }else{

            mBuilder.setSmallIcon(R.drawable.notification_icon);// 设置通知小ICON
            mBuilder.setContentText(string);

        }

        mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon));// 设置通知大ICON

        mBuilder.setTicker(string + "有警报！"); // 通知首次出现在通知栏，带上升动画效果的

        mBuilder.setWhen(System.currentTimeMillis());// 通知产生的时间，会在通知信息里显示，一般是系统获取到的时间

        mBuilder.setPriority(NotificationCompat.PRIORITY_MAX); // 设置该通知优先级

        mBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);//在任何情况下都显示，不受锁屏影响。

        mBuilder.setAutoCancel(true);// 设置这个标志当用户单击面板就可以让通知将自动取消

        mBuilder.setOngoing(false);// ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
        // 向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用NotificationCompat.DEFAULT_ALL属性，可以组合
        mBuilder.setVibrate(new long[] { 0, 100, 500, 100 });//振动效果需要振动权限

//        mBuilder.setSound(Uri.parse("android.resource://" + getPackageName()//声音
//                + "/" + R.raw.notification_alarm));

        mBuilder.setDefaults(NotificationCompat.DEFAULT_LIGHTS);//闪灯

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //Notification notification = mBuilder.getNotification();//API 11

        Notification notification = mBuilder.build();//API 16

        mNotificationManager.notify(1, notification);
    }

    private void sendNotification() {
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                //设置小图标
            builder.setSmallIcon(R.mipmap.ic_launcher)
                //设置通知标题
//                .setContentTitle("最简单的Notification")
            .setTicker("cccc");
                //设置通知内容
//                .setContentText("只有小图标、标题、内容");
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        notifyManager.notify(1, builder.build());
    }

    private void statusBarNitify() {

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My Notification")
                        .setContentText("Hello World!")
                        .setTicker("notification is displayed !!");

        int mNotificationId = 001;

        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button connect_btn = (Button)findViewById(R.id.connect_btn);
        final Button notification_btn = (Button)findViewById(R.id.notification_btn);
//        final NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        notification_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "默认Toast样式",
                        Toast.LENGTH_SHORT).show();
                sendNotification();
//                send("hello_chenchen");
//                sendNotification();
//                statusBarNitify();

//                Notification notification = new Notification(
//                        android.R.drawable.stat_sys_warning,  //Icon to use
//                        "Hello World!", //Text
//                        System.currentTimeMillis() //When to display - i.e. now
//                );

//
//                notification.flags |= Notification.FLAG_NO_CLEAR
//                        | Notification.FLAG_ONGOING_EVENT;
//
//                NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//                builder.setSmallIcon(R.mipmap.ic_launcher)
//                        //设置通知标题
//                        .setContentTitle("CCC")
//                        //设置通知内容
////                    .setContentText("只有小图标、标题、内容");
//                        //设置通知时间，默认为系统发出通知的时间，通常不用设置
//                        .setWhen(System.currentTimeMillis());
//                //通过builder.build()方法生成Notification对象,并发送通知,id=1
//                notifyManager.notify(1, notification);

//                Notification notification = new Notification(R.drawable.your_app_icon,
//                        R.string.name_of_your_app,
//                        System.currentTimeMillis());
//                notification.flags |= Notification.FLAG_NO_CLEAR
//                        | Notification.FLAG_ONGOING_EVENT;
//                NotificationManager notifier = (NotificationManager)
//                        context.getSystemService(Context.NOTIFICATION_SERVICE);
//                notifyManager.notify(1, notification);
//                GameTime = new GameTime(notifyManager, builder);
//                GameTime gameTime = new GameTime(notifyManager, builder);


            }
        });
//        notification_btn.setOnClickListener(new View.OnClickListener() {
//
////                onClick();
////                Toast.makeText(getApplicationContext(), "默认Toast样式",
////                        Toast.LENGTH_SHORT).show();
//////                GameTime = new GameTime(notifyManager, builder);
////                GameTime = new GameTime(notifyManager, builder);
////                sendNotification();
//
//            }
//        });

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
