package com.example.whatsapphesam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapphesam.ContactActivity;
import com.example.whatsapphesam.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class StatusFragment extends Fragment {

    ConstraintLayout linearMyStatus , linearStatus;
    FloatingActionButton fabCamera;
    ImageView fabEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status , null);

        linearMyStatus = view.findViewById(R.id.linearMyStatus);
        linearMyStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"My status...",Snackbar.LENGTH_SHORT).show();

            }
        });
        linearStatus = view.findViewById(R.id.linearStatus);
        linearStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Bruno status...",Snackbar.LENGTH_SHORT).show();

            }
        });

        fabCamera = view.findViewById(R.id.fabCamera);
        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Camera...",Snackbar.LENGTH_SHORT).show();
            }
        });
        fabEdit = view.findViewById(R.id.fabEdit);
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Edit...",Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
