package edu.self.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    private String googleApiKey = "AIzaSyBsos9jaTZy6ci9KA45n5YmB-9VmS2QWKg";
    private String youtubeVideoId = "JM7bZoGywoA";
    private String youtubePlaylist = "PLeuYZVoGHXoTkL8Rn1LILqDC-DzLkgNzY";

    private Button btnPlayVideo;
    private Button btnPlayPlaylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlayPlaylist = (Button) findViewById(R.id.btnPlaylist);
        btnPlayVideo.setOnClickListener(this);
        btnPlayPlaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, googleApiKey, youtubeVideoId);
                break;

            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, googleApiKey, youtubePlaylist);
                break;

            default:
                break;
        }

        if (intent != null) {
            startActivity(intent); // fire off the new activity!
        }
    }
}
