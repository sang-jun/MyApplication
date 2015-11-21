package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 상준 on 2015-11-21.
 */
public class secondActivity extends Activity{
    public secondActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        char oper = intent.getCharExtra("oper", '+');
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        int result = 0;

        switch (oper) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }

        Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);

        outIntent.putExtra("result",result);
        setResult(RESULT_OK,outIntent);
        finish();
    }
}
