package com.example.hansung101_56.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.example.hansung101_56.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btn_go, btn_back;
    EditText edit_url;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = (Button) findViewById(R.id.btn_go);
        btn_back = (Button) findViewById(R.id.btn_back);
        webView = (WebView) findViewById(R.id.webView);
        edit_url = (EditText) findViewById(R.id.edit_url);


        webView.setWebViewClient(new CookWebViewClient());
        WebSettings webSet = webView.getSettings();
        webSet.setBuiltInZoomControls(true);

        btn_go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = edit_url.getText().toString();

                if (!url.substring(0, 7).equals("http://") || !url.substring(0, 7).equals("HTTP://")) {
                    url = "http://" + url;
                    edit_url.setText(url);
                }


                webView.loadUrl(url);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.goBack();
            }
        });

    }
    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            edit_url.setText(url);
        }
    }

}
