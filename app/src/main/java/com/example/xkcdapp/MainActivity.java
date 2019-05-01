package com.example.xkcdapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.example.xkcdapp.urlReader.readJsonFromUrl;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;



public class MainActivity extends AppCompatActivity {
    private String url = "";
    private JSONObject jsonUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final WebView myWebView = findViewById(R.id.xkcdwebpage);
        Button button = findViewById(R.id.search);
        final TextView txtURL = findViewById(R.id.txtURL);
        final TextView txtDate = findViewById(R.id.txtDate);
        final TextView txtName = findViewById(R.id.txtName);
        final EditText myEditText = findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 String value = myEditText.getText().toString();
                 url = "https://xkcd.com/" + value + "/info.0.json";
                 try {
                     jsonUrl = readJsonFromUrl(url);
                 } catch(JSONException ex) {

                 } catch(IOException dx) {

                 }
                //JsonParser json = new JsonParser();
                 txtURL.setText(urlReader(url));
                 txtDate.setText(postDate(jsonUrl));
            }
        });
    }
    private static String postDate(JSONObject url) {
        String day;
        String month;
        String year;
        Gson x = new GsonBuilder().setPrettyPrinting().create();
        try {
            JsonParser json = new JsonParser();
            JsonElement main = json.parse("hello");
            String test = x.toJson(main);
            day = url.getString("day");
            month = url.getString("month");
            year = url.getString("year");
            return month + "/" + day + "/" + year;
        } catch (Exception e) {
            return "Error for month day year.";
        }
    }

    public static String urlReader(String url) {
        try {
            JSONObject main = new JSONObject(url);
            return main.getString("img");
        } catch (Exception e) {
            return "Oops, looks like something went wrong";
        }
    }
    //public static String changeImage(String link) throws JSONException, IOException {
        //JSONObject json = urlReader(link);
      //  Object img = json.get("img");
       // String returnLink = img.toString();
        //return returnLink;
    //}
}
