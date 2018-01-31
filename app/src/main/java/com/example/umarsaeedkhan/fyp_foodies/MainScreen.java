package com.example.umarsaeedkhan.fyp_foodies;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    private String txtSpinner;
    ArrayList<String> listItems=new ArrayList<>();
    static ArrayList<LocationArray> list;
    ArrayAdapter<String> adapter;
    Spinner sp;
    private Button btn;
    String defaultValue = "Select Your Area";
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Intent i = getIntent();
        final String get = i.getStringExtra("id");

        String[] city_list = new String[]{"Choose Your Area"};


        btn = (Button) findViewById(R.id.btnViewAllRestaurants);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainScreen.this, Restaurants.class);
                next.putExtra("id", get);
                startActivity(next);
            }
        });

        sp = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.locationspinner_layout,R.id.txt, listItems);
        sp.setAdapter(adapter);
        sp.setId(sp.getId());


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    String arrayLocationName = list.get(position).name;
                    String arrayLocationID = list.get(position).id;
                    txtSpinner = arrayLocationName;

                    Toast.makeText(getApplication(), "You Selected " + arrayLocationName, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainScreen.this, AreaWiseRestaurants.class);
                    i.putExtra("location", arrayLocationID);
                    startActivity(i);
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    ///For spinner
    public void onStart() {
        super.onStart();
        BackTaskForLocations bt = new BackTaskForLocations();
        bt.execute();

    }

    private class BackTaskForLocations extends AsyncTask<Void, Void, Void> {


        protected void onPreExecute() {
            super.onPreExecute();
            list = new ArrayList<>();
        }

        protected Void doInBackground(Void... params) {
            InputStream is = null;
            String result = "";
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpGet httppost = new HttpGet(Ngrok.url + "/AndroidWebservices/public/loc");
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                // Get our response as a String.
                is = entity.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //convert response to string
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                is.close();
                //result=sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // parse json data
            try {
                JSONArray jArray = new JSONArray(result);
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject jsonObject = jArray.getJSONObject(i);

                    LocationArray item = new LocationArray();
                    item.name = jsonObject.getString("loc_name");
                    item.id = jsonObject.getString("loc_id");
                    list.add(item);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {

            for (int a=0;a<list.size();a++) {
                listItems.add(list.get(a).name);
            }

            adapter.notifyDataSetChanged();
        }

    }
}
