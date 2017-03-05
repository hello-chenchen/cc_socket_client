package com.hello_chenchen.ccsocket.common;

/**
 * Created by root on 17-1-27.
 * author: hello_chenchen
 */

public interface ICommonDefine {

    /**
     * 公共变量标识
     */
    int CC_INIT       = 0;   //初始化
    int CC_SUCCESS    = 0;    //成功
    int CC_FAIL       = 1;    //失败

    int CC_SLEEPTIME = 1000;    //睡眠时间

    int CC_MAIN_TO_CLIENT_ACTIVITY = 0x001; //主界面跳转到ClientActivity

}
