package com.example.whatsapphesam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.example.whatsapphesam.databinding.ActivityPVBinding;
import com.google.android.material.snackbar.Snackbar;

public class PVActivity extends AppCompatActivity {

    ActivityPVBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPVBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Intent intent = getIntent();
        if (intent ==null){
            finish();
            return;
        }

        int imgProfile = intent.getIntExtra("imgProfile",0);
        String tvname = intent.getStringExtra("tvname");

        binding.imgprofileChat.setImageResource(imgProfile);
        binding.nameProfileChat.setText(tvname);

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PVActivity.this, CallingActivity.class);
                intent.putExtra("tvname",tvname);
                intent.putExtra("imgProfile",imgProfile);
                startActivity(intent);
            }
        });
        binding.imgVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PVActivity.this, CallingActivity.class);
                intent.putExtra("tvname",tvname);
                intent.putExtra("imgProfile",imgProfile);
                startActivity(intent);
            }
        });
        binding.imgsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Send Message",Snackbar.LENGTH_SHORT).show();

            }
        });
        binding.imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Camera",Snackbar.LENGTH_SHORT).show();

            }
        });
        binding.imgEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Emoji",Snackbar.LENGTH_SHORT).show();

            }
        });
        binding.imdAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Attach your file...",Snackbar.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pv_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Snackbar.make(binding.toolbar , item.getTitle(), Snackbar.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}