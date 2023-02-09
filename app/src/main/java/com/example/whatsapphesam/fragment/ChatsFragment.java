package com.example.whatsapphesam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapphesam.ContactActivity;
import com.example.whatsapphesam.R;
import com.example.whatsapphesam.adapter.ChatsAdapter;
import com.example.whatsapphesam.entity.Chats;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatsFragment extends Fragment {

    RecyclerView rcvChats;
    FloatingActionButton fabChat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats , null);

        rcvChats = view.findViewById(R.id.rcvChats);
        rcvChats.setLayoutManager(new LinearLayoutManager(getActivity()));
        ChatsAdapter chatsAdapter = new ChatsAdapter(getActivity(),databaseChats());
        rcvChats.setAdapter(chatsAdapter);

        fabChat = view.findViewById(R.id.fabChat);
        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }



    private ArrayList<Chats> databaseChats()
    {
        ArrayList<Chats> result = new ArrayList<>();
        result.add(new Chats(R.drawable.erenn,"Eren" , "Ok bye","21:02"));
        result.add(new Chats(R.drawable.iconperson,"Maman" , "کجایی ؟","19:57"));
        result.add(new Chats(R.drawable.ronaldo,"Cristiano Ronaldo" , "See you soon bro","17:50"));
        result.add(new Chats(R.drawable.alone2,"Arian" , ":))))))))","14:33"));
        result.add(new Chats(R.drawable.mikasa,"Mikasa" , "Nice","09:46"));
        result.add(new Chats(R.drawable.alone,"Soheil" , "دمت گرمممم","00:20"));
        result.add(new Chats(R.drawable.iconperson,"Parham" , "ایول فردا پیداش میکنم","Yesterday"));
        result.add(new Chats(R.drawable.girl,"Kiana" , "Mrc","Yesterday"));
        result.add(new Chats(R.drawable.hideperson,"Ali" , "khube","Yesterday"));
        result.add(new Chats(R.drawable.iconperson,"Meysam" , "عا","Yesterday"));
        result.add(new Chats(R.drawable.bruno,"Bruno" , "Hi","6/22/21"));
        result.add(new Chats(R.drawable.olee,"Ole gunner Soskjaer " , "How are you?","6/22/21"));
        result.add(new Chats(R.drawable.iconperson,"Ostad" , "موفق باشید","6/21/21"));
        result.add(new Chats(R.drawable.levai,"Livai" , "See you tomorrow","6/15/21"));
        result.add(new Chats(R.drawable.armin,"Armin" , "حله پس","5/30/21"));




        return result;

    }

}
