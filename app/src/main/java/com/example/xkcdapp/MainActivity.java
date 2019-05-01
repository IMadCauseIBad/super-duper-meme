package com.example.xkcdapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


//import org.json.JSONObject;
//import org.json.JSONException;
//import org.json.JSONArray;
import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


public class MainActivity extends AppCompatActivity {

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
                 String sentUrl = "https://xkcd.com/" + value + "/info.0.json";
                 try {
                      myWebView.loadUrl(changeImage(sentUrl));
                 } catch (IOException ex) {

                 } catch (JSONException dx) {

                 }

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
    public static JSONObject urlReader(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    public static String changeImage(String link) throws JSONException, IOException {
        JSONObject json = urlReader(link);
        Object img = json.get("img");
        String returnLink = img.toString();
        return returnLink;
    }
}
