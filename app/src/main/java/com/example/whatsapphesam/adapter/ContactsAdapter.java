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
import com.example.whatsapphesam.entity.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Contact> arrayList;

    public ContactsAdapter(Context context, ArrayList<Contact> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contactrecycleview, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Contact contact = arrayList.get(position);
        holder.imgProfileContact.setImageResource(contact.getImgProfileContact());
        holder.tvnameContact.setText(contact.getTvnameContact());
        holder.tvBio.setText(contact.getTvBio());

        holder.imgProfileContact.setOnClickListener(new View.OnClickListener() {
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
                imgProfilee.setImageResource(contact.getImgProfileContact());

                alertDialog.show();

                imgProfilee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PicActivity.class);
                        intent.putExtra("tvname",contact.getTvnameContact());
                        intent.putExtra("imgProfile",contact.getImgProfileContact());
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
                        intent.putExtra("tvname",contact.getTvnameContact());
                        intent.putExtra("imgProfile",contact.getImgProfileContact());
                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgcall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",contact.getTvnameContact());
                        intent.putExtra("imgProfile",contact.getImgProfileContact());
                        context.startActivity(intent);
                        alertDialog.dismiss();

                    }
                });
                allerimgvideo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CallingActivity.class);
                        intent.putExtra("tvname",contact.getTvnameContact());
                        intent.putExtra("imgProfile",contact.getImgProfileContact());
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

        holder.linearContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PVActivity.class);
                intent.putExtra("tvname",contact.getTvnameContact());
                intent.putExtra("imgProfile",contact.getImgProfileContact());
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfileContact;
        TextView tvnameContact , tvBio;
        ConstraintLayout linearContact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfileContact = itemView.findViewById(R.id.imgProfileContact);
            tvnameContact = itemView.findViewById(R.id.tvnameContact);
            tvBio = itemView.findViewById(R.id.tvBio);
            linearContact = itemView.findViewById(R.id.linearContact);

        }
    }
}
