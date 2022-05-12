package com.example.helloworld.adapters;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Entities.Contact;
import com.example.helloworld.R;

import java.util.List;

public class ContacAdapter extends RecyclerView.Adapter<ContacAdapter.ContactViewHolder> {
    List<Contact> contacts;


    public ContacAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {
        Contact contact = contacts.get(position);
        TextView tvContactName = vh.itemView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = vh.itemView.findViewById(R.id.tvContactNumber);
        View ly = vh.itemView.findViewById(R.id.lyBase);
        View view = vh.itemView;


        tvContactName.setText(contact.name);
        tvContactNumber.setText(contact.number);

        Button btnSms = view.findViewById(R.id.idSms);
        Button btnCall = view.findViewById(R.id.idCall);


        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("APP_VJ20202", "click en el elemento" + contact.id);
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri sms_uri = Uri.parse("smsto: +51987654321");
                Intent sms_intetnt = new Intent(Intent.ACTION_SEND, sms_uri);
                sms_intetnt.putExtra("cuerpo","mensaje");
                view.getContext().startActivity(sms_intetnt);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
