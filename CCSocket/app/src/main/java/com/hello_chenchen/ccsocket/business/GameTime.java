package com.hello_chenchen.ccsocket.business;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import com.hello_chenchen.ccsocket.activities.R;
import com.hello_chenchen.ccsocket.common.ICommonDefine;

/**
 * Created by hello_chenchen on 2017/2/26.
 */

public class GameTime extends Thread implements ICommonDefine {

    private NotificationCompat.Builder builder;
    private NotificationManager notifyManager;

    public GameTime(NotificationManager notifyManager, NotificationCompat.Builder builder)
    {
        super();
        this.notifyManager = notifyManager;
        this.builder = builder;
        this.start();
    }

    @Override
    public void run() {
        int iCount = CC_INIT;
        String strCount = "";

        while (true)
        {
            strCount = Integer.toString(iCount);
            //设置小图标
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    //设置通知标题
                    .setContentTitle(strCount)
                    //设置通知内容
//                    .setContentText("只有小图标、标题、内容");
            //设置通知时间，默认为系统发出通知的时间，通常不用设置
            .setWhen(System.currentTimeMillis());
            //通过builder.build()方法生成Notification对象,并发送通知,id=1
            notifyManager.notify(1, builder.build());
            try {
                Thread.sleep(CC_SLEEPTIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iCount++;
        }

    }
}
