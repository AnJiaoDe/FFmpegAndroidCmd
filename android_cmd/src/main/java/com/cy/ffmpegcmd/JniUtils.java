package com.cy.ffmpegcmd;

public class JniUtils {
    private JniUtils(){}
    private CmdListener cmdListener;
    static {
        System.loadLibrary("ffmpegcmd");
    }

    public static native void runCmd(String[] commands);


    private void onProgress(int hour,int min,int secs,int totalSecs) {

        LogUtils.log("onProgress", hour+":"+min+":"+secs+"__________"+totalSecs);
    }
    private void onFail(){
        LogUtils.log("onFail");
    }

    private void onSuccess() {
        LogUtils.log("onSuccess");
    }
}
