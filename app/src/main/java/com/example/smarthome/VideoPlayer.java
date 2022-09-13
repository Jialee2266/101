package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    private String value = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(value);
        VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView2);
        Resources res = this.getResources();
        int soundId = res.getIdentifier(value, "raw", this.getPackageName());
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + soundId));
        MediaController mediaController = new MediaController(this);

        simpleVideoView.start();
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                simpleVideoView.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(VideoPlayer.this, MainActivity2.class);
                intent.putExtra("key", value);
                startActivity(intent);;
            }
        });


    }
}