package com.cy.androidcmd;

public class JniUtils {
    private JniUtils(){}
    static {
        System.loadLibrary("ffmpegcmd");
    }

    public static native void runCmd(String[] commands);

    private void onFinish(int ret) {
        LogUtils.log("onFinish", ret);

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

    private void onProgress(int hour,int min,int secs,int totalSecs) {

        LogUtils.log("onProgress", hour+":"+min+":"+secs+"__________"+totalSecs);
//        if (sOnCmdExecListener != null)
//        {
//            if (sDuration != 0)
//            {
//                sOnCmdExecListener.onProgress(progress / (sDuration / 1000) * 0.95f);
//            }
//        }
    }
    private void onFailed(String msg){
        LogUtils.log("onFailed", msg);
    }
}
