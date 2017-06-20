package com.example.rishabh.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private EditText mValueField;
    private EditText mKey;
    private Button mSendData;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adding data to firebase
        //refering to our database
        mKey=(EditText) findViewById(R.id.key);
        mRef=new Firebase("https://fireapp-75812.firebaseio.com/Users");
        mSendData=(Button)findViewById(R.id.addString);
        mValueField=(EditText)findViewById(R.id.editText);
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key=mKey.getText().toString();
                String value=mValueField.getText().toString();
                //adding child to database object using reference mref
                Firebase mRefChild=mRef.child(key);
                mRefChild.setValue(value);

            }
        });
    }
}
