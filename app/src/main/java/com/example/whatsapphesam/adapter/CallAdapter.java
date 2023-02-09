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
import com.example.whatsapphesam.entity.Calls;
import com.example.whatsapphesam.entity.Chats;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Calls> arrayList;

    public CallAdapter(Context context, ArrayList<Calls> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_call, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Calls calls = arrayList.get(position);

        holder.imgProfileCall.setImageResource(calls.getImgProfileCall());
        holder.tvnameCall.setText(calls.getTvnameCall());
        holder.tvtimeCall.setText(calls.getTvtimeCall());

        if (calls.getStateCall().equals("1")){
            holder.callmade.setVisibility(View.INVISIBLE);
            holder.callrecevie.setVisibility(View.VISIBLE);
        }
        if (calls.getStateCall().equals("0")){
            holder.callmade.setVisibility(View.VISIBLE);
            holder.callrecevie.setVisibility(View.INVISIBLE);
        }
        if (calls.getStateVideoOrCall().equals("1")){
            holder.imgVideo.setVisibility(View.VISIBLE);
            holder.imgcalling.setVisibility(View.INVISIBLE);
        }
        if (calls.getStateVideoOrCall().equals("0")){
            holder.imgVideo.setVisibility(View.INVISIBLE);
            holder.imgcalling.setVisibility(View.VISIBLE);
        }
        holder.imgProfileCall.setOnClickListener(new View.OnClickListener() {
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
                imgProfilee.setImageResource(calls.getImgProfileCall());

                alertDialog.show();

                imgProfilee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PicActivity.class);
                        intent.putExtra("tvname",calls.getTvnameCall());
                        intent.putExtra("imgProfile",calls.getImgProfileCall());
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
                        intent.putExtra("tvname",calls.getTvnameCall());
                        intent.putExtra("imgProfile",calls.getImgProfileCall());
                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgcall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",calls.getTvnameCall());
                        intent.putExtra("imgProfile",calls.getImgProfileCall());
                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgvideo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",calls.getTvnameCall());
                        intent.putExtra("imgProfile",calls.getImgProfileCall());
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
        holder.imgcalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CallingActivity.class);
                intent.putExtra("tvname",calls.getTvnameCall());
                intent.putExtra("imgProfile",calls.getImgProfileCall());
                context.startActivity(intent);

            }
        });
        holder.imgVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CallingActivity.class);
                intent.putExtra("tvname",calls.getTvnameCall());
                intent.putExtra("imgProfile",calls.getImgProfileCall());
                context.startActivity(intent);
            }
        });
        holder.linearCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v , "Info "+calls.getTvnameCall(), Snackbar.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfileCall , callrecevie , callmade , imgVideo , imgcalling;
        TextView tvnameCall , tvtimeCall;
        ConstraintLayout linearCall;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfileCall = itemView.findViewById(R.id.imgProfileCall);
            tvnameCall = itemView.findViewById(R.id.tvnameCall);
            tvtimeCall = itemView.findViewById(R.id.tvtimeCall);
            linearCall = itemView.findViewById(R.id.linearCall);
            callmade = itemView.findViewById(R.id.callmade);
            callrecevie = itemView.findViewById(R.id.callrecevie);
            imgVideo = itemView.findViewById(R.id.imgVideo);
            imgcalling = itemView.findViewById(R.id.imgcalling);





        }
    }
}
