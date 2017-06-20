package com.example.rishabh.fireapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploading_images extends AppCompatActivity {

    private Button mSelectImage;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT=2;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading_images);

        mSelectImage=(Button)findViewById(R.id.button);
        mStorage= FirebaseStorage.getInstance().getReference();
        mProgressDialog=new ProgressDialog(this);
        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_PICK);
                i.setType("image/w");
                startActivityForResult(i, GALLERY_INTENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_INTENT && requestCode==RESULT_OK){
            mProgressDialog.setMessage("Uploading....");
            mProgressDialog.show();
            Uri uri=data.getData();
            StorageReference filePath=mStorage.child("Photos").child(uri.getLastPathSegment());
            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(uploading_images.this,"Upload done",Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                }
            });
        }

    }
}
