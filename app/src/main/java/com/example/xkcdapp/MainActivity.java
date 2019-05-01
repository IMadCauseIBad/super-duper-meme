package com.example.xkcdapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;





public class MainActivity extends AppCompatActivity {
    private String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView myWebView = findViewById(R.id.xkcdwebpage);
        Button button = (Button)findViewById(R.id.search);
        final EditText myEditText = findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 String value = myEditText.getText().toString();
                 url = "https://xkcd.com/" + value;
                 myWebView.loadUrl(url);
            }
        });
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public static String urlReader(String url) {
        try {
            JSONObject main = new JSONObject(url);
            return main.getString("img");
        } catch (Exception e) {
            return null;
        }
    }
    //public static String changeImage(String link) throws JSONException, IOException {
        //JSONObject json = urlReader(link);
      //  Object img = json.get("img");
       // String returnLink = img.toString();
        //return returnLink;
    //}
}
