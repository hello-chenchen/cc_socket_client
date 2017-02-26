package com.hello_chenchen.ccsocket.business;

import android.app.NotificationManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.Display;

import com.hello_chenchen.ccsocket.activities.R;
import com.hello_chenchen.ccsocket.common.ICommonDefine;

/**
 * Created by hello_chenchen on 2017/2/26.
 */

public class GameTime extends Thread implements ICommonDefine {

    private NotificationCompat.Builder builder;
    private NotificationManager notifyManager;
    private PowerManager powerManager;

//    public GameTime(NotificationManager notifyManager, NotificationCompat.Builder builder, PowerManager powerManager)
    public GameTime(Context context)
    {
        super();
        this.notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        this.builder = new NotificationCompat.Builder(context);
        this.notifyManager = notifyManager;
        this.builder = builder;
        this.powerManager = powerManager;
        this.start();
    }

    @Override
    public void run() {
        int iCount = CC_INIT;
        String strCount = "";
        boolean isScreenOn = false;//如果为true，则表示屏幕“亮”了，否则屏幕“暗”了。
//        ScreenBroadcastReceiver screenBroadcastReceiver = new ScreenBroadcastReceiver();

        while (true)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                isScreenOn = powerManager.isInteractive();
            }
            else
            {
                isScreenOn = powerManager.isScreenOn();
            }
//            isScreenOn =  powerManager.isInteractive();
//            isScreenOn = screenBroadcastReceiver.IsScreenOn();
            while (isScreenOn)
            {
                strCount = Integer.toString(iCount);
                //设置小图标
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        //设置通知标题
                        .setContentTitle("手机使用总时间")
                        //设置通知内容
                        .setContentText(strCount);
                //设置通知时间，默认为系统发出通知的时间，通常不用设置
                //通过builder.build()方法生成Notification对象,并发送通知,id=1
                notifyManager.notify(0, builder.build());
                try {
                    Thread.sleep(CC_SLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                iCount++;
            }
        }

    }
}
