package com.cy.android_cmd;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import com.cy.ffmpegcmd.CmdCallback;
import com.cy.ffmpegcmd.CmdCommandList;
import com.cy.ffmpegcmd.JniUtils;
import com.cy.ffmpegandroidcmd.R;
import com.cy.permission.PermissionActivity;

public class MainActivity extends PermissionActivity {
    private int index_1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_run_cmd).setOnClickListener(this);
        findViewById(R.id.btn_run_cmd2).setOnClickListener(this);
        findViewById(R.id.btn_cancel_1).setOnClickListener(this);
        findViewById(R.id.btn_cancle_2).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_run_cmd:
                checkPermissionWRITE_EXTERNAL_STORAGE(new OnPermissionRequestListener() {
                    @Override
                    public void onPermissionHave() {
                        Log.e("getExternalS", Environment.getExternalStorageDirectory() + "/FFmpegDemo/video.mp4");
                        //先取得读写权限
//                        Log.e("issuccess?", "" + JniUtils.remuxe(Environment.getExternalStorageDirectory() + "/FFmpegDemo/video.mp4",
//                                Environment.getExternalStorageDirectory() + "/FFmpegDemo/video.mkv"));
//                        ffmpeg -i C:\Users\Administrator\Desktop\袋熊.mp4
//                                -i F:\表情包\JB`~O0J_SH{U{VA0U{3%X~I.gif
//-filter_complex "[1:v]scale=300:300[logo];[0:v][logo]overlay=x=0:y=0"
//C:\Users\Administrator\Desktop\filtered_video.mp4
//
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {


                                index_1 = JniUtils.getInstance().cmdAsync(new CmdCommandList().append("ffmpeg")
                                                .append("-y")
                                                .append("-i")
                                                .append(Environment.getExternalStorageDirectory() + "/FFmpegDemo/video.mp4")
                                                .append("-i")
                                                .append(Environment.getExternalStorageDirectory() + "/FFmpegDemo/logo.png")
                                                .append("-filter_complex")
                                                .append("[1:v]scale=300:300[logo];[0:v][logo]overlay=x=0:y=0")
                                                .append(Environment.getExternalStorageDirectory() + "/FFmpegDemo/video_filtered.mp4").build(),
                                        new CmdCallback() {

                                            @Override
                                            public void onProgress(int hour, int min, int secs, long totalSecs) {
                                                LogUtils.log("onProgress");

                                            }

                                            @Override
                                            public void onSuccess() {
                                                LogUtils.log("onSuccess");

                                            }

                                            @Override
                                            public void onCancel() {

                                            }

                                            @Override
                                            public void onFail() {
                                                LogUtils.log("onFail");

                                            }
                                        });
//                            }
//                        }).start();

                    }

                    @Override
                    public void onPermissionRefuse() {
                    }

                    @Override
                    public void onPermissionRefuseNoAsk() {

                    }
                });
                break;
            case R.id.btn_run_cmd2:
                break;
            case R.id.btn_cancel_1:
                LogUtils.log("cancle-1");
                JniUtils.getInstance().cancel(index_1);
                break;
            case R.id.btn_cancle_2:
                break;
        }
    }
}
