package com.example.com.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tvName,tvEmail;
    Button button1;
    EditText dlgEditName, dlgEditEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName= (EditText) findViewById(R.id.textView_name);
        tvEmail = (EditText) findViewById(R.id.textView_email);
        button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);

                dlgEditName = (EditText) dialogView.findViewById(R.id.dialog_edit1);
                dlgEditEmail = (EditText) dialogView.findViewById(R.id.dialog_edit2);

                dlgEditName.setText(tvName.getText().toString());
                dlgEditEmail.setText(tvEmail.getText().toString());

                dlg.setTitle("사용자 정보 입력");
                //
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        tvName.setText(dlgEditName.getText().toString());
                        tvEmail.setText(dlgEditEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());

                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this,R.layout.toast1,null);
                        toastText=(TextView) toastView.findViewById(R.id.toast1_tv);
                        toastText.setText("취소했습니다.");
                        toast.setGravity(Gravity.TOP | Gravity.LEFT,xOffset,yOffset);
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });

    }
}
