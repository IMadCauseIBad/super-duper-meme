package com.example.xkcdapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

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
                 txtURL.setText(urlReader(url));
                 txtDate.setText(postDate(url));

            }
        });
    }
    private static String postDate(String url) {
        String day;
        String month;
        String year;
        try {
            JSONObject main = new JSONObject(url);
            day = main.getString("day");
            month = main.getString("month");
            year = main.getString("year");
            return month + "/" + day + "/" + year;
        } catch (Exception e) {
            return null;
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
