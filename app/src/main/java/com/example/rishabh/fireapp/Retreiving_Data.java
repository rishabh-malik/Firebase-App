package com.example.rishabh.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.realtime.util.StringListReader;

import java.util.Map;

public class Retreiving_Data extends AppCompatActivity {
    private Firebase mRef;
    private TextView mValueName;
    private TextView mValueAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreiving__data);

        Firebase.setAndroidContext(this);
        mValueName=(TextView)findViewById(R.id.textView);
        mValueAge=(TextView)findViewById(R.id.textView2);
        mRef=new Firebase("https://fireapp-75812.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            //whenever the value is changed
            public void onDataChange(DataSnapshot dataSnapshot) {
                //used to retreive multiple value
                Map<String ,String> map=dataSnapshot.getValue(Map.class);
                String name=map.get("Name");
                String age=map.get("Age");
                mValueName.setText(name);
                mValueAge.setText(age);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
