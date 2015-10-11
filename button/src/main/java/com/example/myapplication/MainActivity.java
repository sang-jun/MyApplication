package com.example.myapplication;

import android.app.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button1);
        Button button3 = (Button) findViewById(R.id.button1);
        Button button4 = (Button) findViewById(R.id.button1);


    }


    public void button_onclick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com")));
                break;
            case R.id.button2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:911")));
                break;
            case R.id.button3:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, 0);
                break;
            case R.id.button4:
                finish();
                break;
        }
    }
}
