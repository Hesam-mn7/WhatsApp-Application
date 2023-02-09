package com.example.whatsapphesam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.whatsapphesam.adapter.MyViewPagerAdapter;
import com.example.whatsapphesam.databinding.ActivityHomeBinding;
import com.example.whatsapphesam.databinding.ActivityPVBinding;
import com.example.whatsapphesam.entity.Contact;
import com.example.whatsapphesam.fragment.StatusFragment;
import com.example.whatsapphesam.fragment.ChatsFragment;
import com.example.whatsapphesam.fragment.CallFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "Search", Snackbar.LENGTH_SHORT).show();

            }
        });

        Map<String , Fragment> map=new HashMap<>();
        map.put("CHATS" , new ChatsFragment());
        map.put(" STATUS" , new StatusFragment());
        map.put("CALLS" , new CallFragment());

        adapter=new MyViewPagerAdapter(getSupportFragmentManager() , map);

        binding.viewPager.setAdapter(adapter);

        binding.tab.setupWithViewPager(binding.viewPager);

    }

    int counter = 0;
    @Override
    public void onBackPressed() {

        if (counter == 0)
        {
            binding.tab.getTabAt(0).select();
            counter ++;
            return;
        }

        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_newgroup:
                Intent intent = new Intent(HomeActivity.this , ContactActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Snackbar.make(binding.toolbar , "Settings", Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(binding.toolbar , item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}