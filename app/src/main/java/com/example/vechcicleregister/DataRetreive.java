package com.example.vechcicleregister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DataRetreive extends AppCompatActivity {


    TextView a,b,c,d;
    Button btn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retreive);


        a = (TextView) findViewById(R.id.vec_reg);
        b = (TextView) findViewById(R.id.vec_number);
        c = (TextView) findViewById(R.id.vec_types);
        d = (TextView) findViewById(R.id.vec_colors);
        btn = (Button)findViewById(R.id.btnshow);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reff = FirebaseDatabase.getInstance().getReference().child("DataUsers").child("Users");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String reg_num  = dataSnapshot.child("reg_num").getValue().toString();
                        String vec_num  = dataSnapshot.child("vec_num").getValue().toString();
                        String vec_type  = dataSnapshot.child("vec_type").getValue().toString();
                        String vec_color  = dataSnapshot.child("vec_color").getValue().toString();

                        a.setText(reg_num);
                        b.setText(vec_num);
                        c.setText(vec_type);
                        d.setText(vec_color);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
