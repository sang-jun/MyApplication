package com.example.hansung101_56.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    String num1,num2;
    TextView result;
    Button btnNum[];
    Button btnOper[];
    int numButtonIds[] = {R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9,};
    int operButtonIds[] = {R.id.button_add,R.id.button_sub,R.id.button_mul,R.id.button_div};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        result = (TextView) findViewById(R.id.textView_result);

        btnNum = new Button[10];
        btnOper = new Button[4];

        for(int i = 0 ; i < btnNum.length ; i++) {
            final int index;
            index = i;
            btnNum[i] = (Button) findViewById(numButtonIds[i]);

            btnNum[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                        num1 = edit1.getText().toString() + index;
                        edit1.setText(num1);
                    }else if(edit2.isFocused()) {
                        num2 = edit2.getText().toString() + index;
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        for(int i = 0 ; i < btnOper.length; i++) {
            btnOper[i] = (Button) findViewById(operButtonIds[i]);
        }



    }



    public void operClicked(View v) {
        float n1 = Float.parseFloat(num1);
        float n2 = Float.parseFloat(num2);

        if (num1.equals("") || num2.equals(""))
            Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
        else {
            switch (v.getId()) {
                case R.id.button_add:  result.setText("계산 결과 : " + (n1+n2));
                    break;
                case R.id.button_sub: result.setText("계산 결과 : " + (n1-n2));
                    break;
                case R.id.button_mul: result.setText("계산 결과 : " + (n1*n2));
                    break;
                case R.id.button_div: result.setText("계산 결과 : " + (n1/n2));
                    break;
            }
        }
    }
}
