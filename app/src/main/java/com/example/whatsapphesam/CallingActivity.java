package com.example.whatsapphesam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.whatsapphesam.databinding.ActivityCallingBinding;
import com.example.whatsapphesam.databinding.ActivityPVBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class CallingActivity extends AppCompatActivity {

    ActivityCallingBinding binding;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.internal_ring);
        mediaPlayer.start();

        Intent intent = getIntent();
        if (intent ==null){
            finish();
            return;
        }

        int imgProfile = intent.getIntExtra("imgProfile",0);
        String tvname = intent.getStringExtra("tvname");

        binding.imgprofileCallung.setImageResource(imgProfile);
        binding.callingName.setText(tvname);

        binding.volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                else {
                    mediaPlayer.start();
                }
            }
        });
        binding.video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Video Calling",Snackbar.LENGTH_SHORT).show();

            }
        });
        binding.muted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Muted",Snackbar.LENGTH_SHORT).show();

            }
        });

        binding.imgendcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();

            }
        });

    }
}