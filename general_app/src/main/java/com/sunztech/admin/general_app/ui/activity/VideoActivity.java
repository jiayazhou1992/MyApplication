package com.sunztech.admin.general_app.ui.activity;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.utils.utils1.LogUtils;

import java.io.IOException;

public class VideoActivity extends AppCompatActivity {

    private SurfaceView surfaceView,surfaceView2;
    private Button button_bf,button_sp,button_qh;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        button_bf= (Button) findViewById(R.id.bofang);
        button_sp= (Button) findViewById(R.id.stop);
        button_qh= (Button) findViewById(R.id.change);

        surfaceView= (SurfaceView) findViewById(R.id.video);
        surfaceView2= (SurfaceView) findViewById(R.id.video2);
        surfaceView.getHolder().setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new MySurfaceHolder());
        surfaceView2.getHolder().setKeepScreenOn(true);
        surfaceView2.getHolder().addCallback(new MySurfaceHolder());

        button_bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.setDisplay(surfaceView.getHolder());
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
        });
        button_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
        button_qh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.setDisplay(surfaceView2.getHolder());
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
        });
    }

    private class MySurfaceHolder implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            initMediePlayer();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            mediaPlayer.stop();
        }
    }

    private void initMediePlayer(){
        try {
            mediaPlayer=new MediaPlayer();
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            AssetFileDescriptor assetFileDescriptor=this.getAssets().openFd("22723696726378419228237002150.mp4");
            LogUtils.e(this.getClass().getName(),assetFileDescriptor.getLength());
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(),assetFileDescriptor.getLength());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mediaPlayer!=null)
            mediaPlayer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
