package com.mediaplayerdemo;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextureView.SurfaceTextureListener {

//    private SurfaceView surfaceView;
    private TextureView textureView;
//    private VideoView videoView;
    private Button button_play;
    private Button button_pause;
    private Button button_stop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        surfaceView = (SurfaceView) findViewById(R.id.mysurface);
        textureView = (TextureView) findViewById(R.id.mytextureview);
        textureView.setSurfaceTextureListener(this);

//        videoView = (VideoView) findViewById(R.id.myvideoview);
        button_play = (Button) findViewById(R.id.button_play);
        button_play.setOnClickListener(this);
        button_stop = (Button) findViewById(R.id.button_stop);
        button_stop.setOnClickListener(this);
        button_pause = (Button) findViewById(R.id.button_pause);
        button_pause.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_play:
//                videoView.start();
                mediaPlayer.start();
                break;
            case R.id.button_pause:
//                videoView.pause();
                mediaPlayer.pause();
                break;
            case R.id.button_stop:
//                videoView.stopPlayback();
                mediaPlayer.stop();
                break;
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        String path = Environment.getExternalStorageDirectory() + "/Video/VID_test.mp4";
//        videoView.setVideoPath(path);
//        Uri parse = Uri.parse(path);
        mediaPlayer = new MediaPlayer();
        try {
//            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            mediaPlayer.setDataSource(path);

//            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            mediaPlayer.setSurface(new Surface(surface));
            mediaPlayer.prepare();
//
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
