//David Kenny 15761
package com.example.eireog.dkdubbikes;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;




public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        DownloadTask task = new DownloadTask();
        task.execute("https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=090219beb9eddd610924ac169c74736ab9c0eb9f"};

        public class DownloadTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... urls) {

                String result = "";
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(urls[0]);

                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader reader = new InputStreamReader(in);

                    int data = reader.read();

                    while (data != -1) {

                        char current = (char) data;

                        result += current;

                        data = reader.read();

                    }

                    return result;

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);

                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    ListView myListView = (ListView)findViewById(R.id.myListView);
                    final ArrayList<String> StationList = new ArrayList<String>()

                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, stations);
                    myListView.setAdapter(arrayAdapter);
                int i;
                for (i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonPart = jsonArray.getJSONObject(i);
                        StationList.add(jsonPart.getString("name");


                } catch (JSONException) {

                    Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);

                }



            }
        } }
}
