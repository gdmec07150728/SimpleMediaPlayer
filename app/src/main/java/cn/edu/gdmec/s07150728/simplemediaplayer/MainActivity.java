package cn.edu.gdmec.s07150728.simplemediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String mp;
    private MediaPlayer mediaPlayer;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        mp = uri.getPath();
        if(intent.getType().contains("audio")){
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(mp);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(intent.getType().contains("video")){
            videoView = new VideoView(this);
            videoView.setVideoURI(uri);
            videoView.setMediaController(new MediaController(this));
            videoView.start();
            setContentView(videoView);
        }
    }
}
