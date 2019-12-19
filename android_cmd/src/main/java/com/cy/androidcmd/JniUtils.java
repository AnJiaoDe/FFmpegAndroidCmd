package com.cy.androidcmd;

public class JniUtils {
    static {
        System.loadLibrary("ffmpegcmd");
    }
    public static native void runCmd(String[] commands);

    public static void onFinish(int ret)
    {
        LogUtils.log("onFinish",ret);

//        if (sOnCmdExecListener != null)
//        {
//            if (ret == 0)
//            {
//                sOnCmdExecListener.onProgress(sDuration);
//                sOnCmdExecListener.onSuccess();
//            }
//            else
//            {
//                sOnCmdExecListener.onFailure();
//            }
//        }
    }

    public static void onProgress(float progress)
    {
        LogUtils.log("porgress",progress);
//        if (sOnCmdExecListener != null)
//        {
//            if (sDuration != 0)
//            {
//                sOnCmdExecListener.onProgress(progress / (sDuration / 1000) * 0.95f);
//            }
//        }
    }
}
