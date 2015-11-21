package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private RadioButton rBtn_add, rBtn_sub, rBtn_mul, rBtn_div;
    private Button btn_result;
    private RadioGroup rGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        rBtn_add = (RadioButton) findViewById(R.id.radioButton);
        rBtn_sub = (RadioButton) findViewById(R.id.radioButton2);
        rBtn_mul = (RadioButton) findViewById(R.id.radioButton3);
        rBtn_div = (RadioButton) findViewById(R.id.radioButton4);
        btn_result = (Button) findViewById(R.id.button);
        rGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btn_result.setOnClickListener(new View.OnClickListener() {
            private int num1,num2;
            private char oper;

            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(edit1.getText().toString());
                num2 = Integer.parseInt(edit2.getText().toString());
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton : oper = '+'; break;
                    case R.id.radioButton2 :oper = '-'; break;
                    case R.id.radioButton3 :oper = '*'; break;
                    case R.id.radioButton4 :oper = '/'; break;
                }

                Intent intent = new Intent(getApplicationContext(),secondActivity.class);
                intent.putExtra("oper",oper);
                intent.putExtra("num1",num1);
                intent.putExtra("num2",num2);

                startActivityForResult(intent,0);

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int result = data.getIntExtra("result",0);

        Toast.makeText(MainActivity.this, "결과 : "+result, Toast.LENGTH_SHORT).show();
    }
}
