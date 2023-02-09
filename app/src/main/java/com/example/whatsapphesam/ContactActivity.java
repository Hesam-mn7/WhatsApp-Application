package com.example.whatsapphesam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.whatsapphesam.adapter.ContactsAdapter;
import com.example.whatsapphesam.databinding.ActivityContactBinding;
import com.example.whatsapphesam.entity.Contact;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.linearNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "New group", Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.linearNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                startActivity(intent);
            }
        });

        binding.imgSearchContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "Search", Snackbar.LENGTH_SHORT).show();

            }
        });

        binding.recycleContact.setLayoutManager(new LinearLayoutManager(this));
        ContactsAdapter contactsAdapter = new ContactsAdapter(this,databaseContact());
        binding.recycleContact.setAdapter(contactsAdapter);
    }

    private ArrayList<Contact> databaseContact()
    {
        ArrayList<Contact> result = new ArrayList<>();
        result.add(new Contact(R.drawable.hideperson,"Ali" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.iconperson,"Alipour" , "Available"));
        result.add(new Contact(R.drawable.armin,"Armin" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.alone2,"Arian" , "At work"));
        result.add(new Contact(R.drawable.iconperson,"Baba" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.bruno,"Bruno" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.ronaldo,"Cristiano Ronaldo" , "Portuguese footballer"));
        result.add(new Contact(R.drawable.eren,"Hesam" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.iconperson,"Ehsan" , "Available"));
        result.add(new Contact(R.drawable.erenn,"Eren" , "Hi Im Eren Yager"));
        result.add(new Contact(R.drawable.iconperson,"Iman" , "Busy"));
        result.add(new Contact(R.drawable.girl,"Kiana" , "Available"));
        result.add(new Contact(R.drawable.alone,"Soheil" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.iconperson,"Parham" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.iconperson,"Ostad" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.olee,"Ole gunner Solskjaer" , "Norwegian football manager"));
        result.add(new Contact(R.drawable.iconperson,"Maman" , "Hey there! I am using WhatsApp."));
        result.add(new Contact(R.drawable.iconperson,"Meysam" , ":|"));
        result.add(new Contact(R.drawable.mikasa,"Mikasa" , "Busy"));

        return result;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.invite:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"invite...."
                );
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.contacts:
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                startActivity(intent);
                break;

            case R.id.refresh:
                finish();
                startActivity(getIntent());
                break;

            default:
                Snackbar.make(binding.toolbar , item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}