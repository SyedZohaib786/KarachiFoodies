package com.example.umarsaeedkhan.fyp_foodies;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Restaurants extends Activity {
    ArrayList<RestaurantsData> restList;
    AdapterRestaurants adapter;
    String getid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Intent i = getIntent();
        getid = i.getStringExtra("id");

        restList = new ArrayList<RestaurantsData>();
        new JSONAsyncTask().execute(Ngrok.url + "/AndroidWebservices/public/getdes");


        final ListView listview = (ListView)findViewById(R.id.List);
        adapter = new AdapterRestaurants(getApplicationContext(), R.layout.restaurantslist, restList);
        listview.setAdapter(adapter);
        listview.setId(listview.getId());

        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position,
                                    long id) {
                // TODO Auto-generated method stub
                String arrayRestaurantName = restList.get(position).getRestName();
                String arrayRestaurantID = restList.get(position).getRestID();
                Toast.makeText(getApplicationContext(),  arrayRestaurantName, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Restaurants.this, DishesOfSpecificRestaurant.class);
                intent.putExtra("position", arrayRestaurantID);
                intent.putExtra("Restaurant", arrayRestaurantName);
                intent.putExtra("id", getid);
                startActivity(intent);
            }
        });
    }
    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Restaurants.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting...");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONArray jarray = new JSONArray(data);

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        RestaurantsData rest = new RestaurantsData();

                        rest.setRestID(object.getString("rest_id"));
                        rest.setRestName(object.getString("rest_name"));
                        rest.setRestDesc(object.getString("rest_descr"));
                        rest.setDeliveryTime(object.getString("delivery_time"));
                        rest.setRestImage(object.getString("rest_image"));

                        restList.add(rest);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }
}
