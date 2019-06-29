package com.example.vechcicleregister;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String UserId;

    EditText reg_num, vec_num, vec_type, vec_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_num = (EditText) findViewById(R.id.vec_reg);
        vec_num = (EditText) findViewById(R.id.vec_number);
        vec_type = (EditText) findViewById(R.id.vec_types);
        vec_color = (EditText) findViewById(R.id.vec_colors);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("DataUsers");
        UserId = mFirebaseDatabase.push().getKey();
    }

    public void addUser(String reg_num, String vec_num, String vec_type, String vec_color) {
        User users = new User(reg_num, vec_num, vec_type, vec_color);
        mFirebaseDatabase.child("Users").child(UserId).setValue(users);
    }

    public void insertData(View view) {
        addUser(reg_num.getText().toString().trim(), vec_num.getText().toString().trim(), vec_type.getText().toString().trim(), vec_color.getText().toString().trim());
    }
}