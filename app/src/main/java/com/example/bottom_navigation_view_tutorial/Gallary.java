package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Gallary extends AppCompatActivity {

    private final int camera_req_code = 1 ;

    Button uploadImageBtn ;
    ImageView imageViewId ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        uploadImageBtn = findViewById(R.id.uploadImageBtn) ;
        imageViewId = findViewById(R.id.imageViewId) ;

        uploadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try
                {
                    //when I need to go to new Activity and bring some data from it
                    //then we will use startActivityForResult .
                    startActivityForResult(takePictureIntent,camera_req_code);
                }
                catch (ActivityNotFoundException e)
                {
                    Log.d("camera_intent","Error to open camera : " + e) ;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK )
        {
            if(requestCode == camera_req_code)
            {
                // for camera ;
                // convert the data into bitmap .
                Bitmap bm = (Bitmap) data.getExtras().get("data") ;
                imageViewId.setImageBitmap(bm);

            }

        }
    }
}