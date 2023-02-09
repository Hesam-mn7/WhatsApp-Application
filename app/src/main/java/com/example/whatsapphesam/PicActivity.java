package com.example.whatsapphesam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.whatsapphesam.databinding.ActivityPVBinding;
import com.example.whatsapphesam.databinding.ActivityPicBinding;

public class PicActivity extends AppCompatActivity {

    ActivityPicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBackPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent ==null){
            finish();
            return;
        }

        int imgProfile = intent.getIntExtra("imgProfile",0);
        String tvname = intent.getStringExtra("tvname");

        binding.imgPic.setImageResource(imgProfile);
        binding.tvnamePic.setText(tvname);
    }
}