package com.example.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView textView1;
    Switch switch1;
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    ImageView imageView1;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        switch1 = (Switch) findViewById(R.id.switch1);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        imageView1 = (ImageView) findViewById(R.id.imageView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    radioGroup1.setVisibility(View.VISIBLE);

                } else {
                    radioGroup1.setVisibility(View.GONE);
                    imageView1.setVisibility(View.GONE);
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:imageView1.setImageResource(R.drawable.jellybean); imageView1.setVisibility(View.VISIBLE); break;
                    case R.id.radioButton2:imageView1.setImageResource(R.drawable.kitkat); imageView1.setVisibility(View.VISIBLE); break;
                    case R.id.radioButton3:imageView1.setImageResource(R.drawable.lollipop); imageView1.setVisibility(View.VISIBLE); break;
                    default: imageView1.setVisibility(View.GONE); break;
                }

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                radioGroup1.setVisibility(View.GONE);
                radioGroup1.clearCheck();
                imageView1.setVisibility(View.GONE);
                switch1.setChecked(false);

            }
        });


    }

}
