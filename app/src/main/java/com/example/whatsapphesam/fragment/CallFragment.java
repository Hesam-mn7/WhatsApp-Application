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
import com.example.whatsapphesam.adapter.CallAdapter;
import com.example.whatsapphesam.adapter.ChatsAdapter;
import com.example.whatsapphesam.entity.Calls;
import com.example.whatsapphesam.entity.Chats;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CallFragment extends Fragment {

    RecyclerView recycleViewCall;
    FloatingActionButton fabCall;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calls , null);

        recycleViewCall = view.findViewById(R.id.recycleViewCall);
        recycleViewCall.setLayoutManager(new LinearLayoutManager(getActivity()));
        CallAdapter callAdapter = new CallAdapter(getActivity(),databaseCalls());
        recycleViewCall.setAdapter(callAdapter);

        fabCall = view.findViewById(R.id.fabCall);
        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private ArrayList<Calls> databaseCalls()
    {
        ArrayList<Calls> result = new ArrayList<>();
        result.add(new Calls(R.drawable.girl,"Kiana" , "Today, 09:24","0","0"));
        result.add(new Calls(R.drawable.ronaldo,"Cristiano Ronaldo" , "Yesterday, 19:39","0","1"));
        result.add(new Calls(R.drawable.ronaldo,"Cristiano Ronaldo" , "(2) Yesterday, 19:27","1","1"));
        result.add(new Calls(R.drawable.armin,"Armin" , "June 22, 20:01","0","0"));
        result.add(new Calls(R.drawable.iconperson,"Meysam" , "(4) June 22, 13:27","1","1"));
        result.add(new Calls(R.drawable.girl,"Kiana" , "June 20, 23:27","0","1"));
        result.add(new Calls(R.drawable.armin,"Armin" , "(3) June 19, 12:11","1","0"));
        result.add(new Calls(R.drawable.ronaldo,"Cristiano Ronaldo" , "June 16, 18:57","0","0"));
        result.add(new Calls(R.drawable.hideperson,"Ali" , "June 11, 12:28","0","1"));
        result.add(new Calls(R.drawable.alone,"Soheil" , "(3) June 05, 9:17","1","1"));
        result.add(new Calls(R.drawable.bruno,"Bruno" , "June 01, 2:57","0","0"));
        result.add(new Calls(R.drawable.bruno,"Bruno" , "May 28, 13:57","1","1"));
        result.add(new Calls(R.drawable.girl,"Kiana" , "May 26, 18:14","0","0"));
        result.add(new Calls(R.drawable.alone2,"Arian" , "(3) May 19, 12:11","0","0"));




        return result;

    }
}
