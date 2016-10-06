package com.example.koko3.naishi_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    private VideoView vidView;
    private MediaController vidControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);

        vidView=(VideoView)findViewById(R.id.myVideo);

        Uri vidUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro);
        vidView.setVideoURI(vidUri);
        vidView.start();

        vidView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer arg0)
            {
                jmpToMenu();
            }
        });
    }

    public void jmpToMenu(){
        setContentView(R.layout.main_layout);
        Button button=(Button)findViewById(R.id.button);
        TextView textView=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.this.finish();
            }
        });
    }
}
