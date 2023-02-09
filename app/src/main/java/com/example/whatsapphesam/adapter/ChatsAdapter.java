package com.example.whatsapphesam.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapphesam.CallingActivity;
import com.example.whatsapphesam.PVActivity;
import com.example.whatsapphesam.PicActivity;
import com.example.whatsapphesam.R;
import com.example.whatsapphesam.entity.Chats;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.MyViewHolder>   {
    private Context context;
    private ArrayList<Chats> arrayList;

    public ChatsAdapter(Context context, ArrayList<Chats> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chatlistrecycleview, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Chats chats = arrayList.get(position);

        holder.imgProfile.setImageResource(chats.getImgProfile());
        holder.tvtext.setText(chats.getTvtext());
        holder.tvname.setText(chats.getTvname());
        holder.tvTime.setText(chats.getTvTime());

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;
                View alert= LayoutInflater.from(context).inflate(R.layout.allerdialogpic,null);
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setView(alert);
                builder.setCancelable(true);
                alertDialog=builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.trans)));

                ImageView imgProfilee = alert.findViewById(R.id.imgProfilee);
                imgProfilee.setImageResource(chats.getImgProfile());

                alertDialog.show();

                imgProfilee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PicActivity.class);
                        intent.putExtra("tvname",chats.getTvname());
                        intent.putExtra("imgProfile",chats.getImgProfile());
                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });

                ImageView allerimgmessage = alert.findViewById(R.id.allerimgmessage);
                ImageView allerimgcall = alert.findViewById(R.id.allerimgcall);
                ImageView allerimgvideo = alert.findViewById(R.id.allerimgvideo);
                ImageView allerimginfo = alert.findViewById(R.id.allerimginfo);
                allerimgmessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PVActivity.class);
                        intent.putExtra("tvname",chats.getTvname());
                        intent.putExtra("imgProfile",chats.getImgProfile());

                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgcall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",chats.getTvname());
                        intent.putExtra("imgProfile",chats.getImgProfile());

                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgvideo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",chats.getTvname());
                        intent.putExtra("imgProfile",chats.getImgProfile());

                        context.startActivity(intent);
                        alertDialog.dismiss();
                    }
                });
                allerimginfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "info", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

            }
        });

        holder.linearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PVActivity.class);
                intent.putExtra("tvname",chats.getTvname());
                intent.putExtra("imgProfile",chats.getImgProfile());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile ;
        TextView tvname , tvtext , tvTime;
        ConstraintLayout linearText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvname = itemView.findViewById(R.id.tvname);
            tvtext = itemView.findViewById(R.id.tvtext);
            tvTime = itemView.findViewById(R.id.tvTime);
            linearText = itemView.findViewById(R.id.linearText);



        }
    }
}
