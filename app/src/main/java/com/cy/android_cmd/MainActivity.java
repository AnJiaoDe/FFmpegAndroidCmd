package com.cy.android_cmd;

import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cy.androidcmd.CmdCommandList;
import com.cy.androidcmd.JniUtils;
import com.cy.ffmpegandroidcmd.R;
import com.cy.permission.PermissionActivity;

public class MainActivity extends PermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_run_cmd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
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
                                JniUtils.runCmd(new CmdCommandList().append("ffmpeg")
                                        .append("-y")
                                        .append("-i")
                                        .append(Environment.getExternalStorageDirectory() +"/FFmpegDemo/video.mp4")
                                        .append("-i")
                                        .append(Environment.getExternalStorageDirectory() +"/FFmpegDemo/logo.png")
//                                        .append("-filter_complex")
                                        .append("[1:v]scale=300:300[logo];[0:v][logo]overlay=x=0:y=0")
                                        .append(Environment.getExternalStorageDirectory() + "/FFmpegDemo/video_filtered.mp4").build());

                            }

                            @Override
                            public void onPermissionRefuse() {
                            }

                            @Override
                            public void onPermissionRefuseNoAsk() {

                            }
                        });

                    }
                }).start();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
