package com.example.xkcdapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = (WebView) findViewById(R.id.xkcdwebpage);
        myWebView.loadUrl("https://imgs.xkcd.com/comics/modified_bayes_theorem_2x.png");
    }
}
