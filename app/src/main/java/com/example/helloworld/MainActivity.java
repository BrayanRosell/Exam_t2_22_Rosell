package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloworld.Entities.Contact;
import com.example.helloworld.adapters.ContacAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = getContacts();
        ContacAdapter adapter = new ContacAdapter(contacts);

        RecyclerView rv = findViewById(R.id.rvContacts);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }
    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1,"Quintina Straughan","542-590-6572"));
        contacts.add(new Contact(2,"Yoshi Smillie","103-593-1880"));
        contacts.add(new Contact(3,"Alan Houndson","435-440-2851"));
        contacts.add(new Contact(4,"Udell Tole","572-705-6101"));
        contacts.add(new Contact(5,"Amelita Diggell","543-296-9061"));
        contacts.add(new Contact(6,"Clint Tranckle","267-342-8794"));
        contacts.add(new Contact(7,"Cherie Henken","778-359-4226"));
        contacts.add(new Contact(8,"Fan Langrick","597-338-7011"));
        contacts.add(new Contact(9,"Suzette Ivanaev","932-661-1183"));
        contacts.add(new Contact(100,"Angele Dessant","746-3564190"));
        return contacts;
    }
}