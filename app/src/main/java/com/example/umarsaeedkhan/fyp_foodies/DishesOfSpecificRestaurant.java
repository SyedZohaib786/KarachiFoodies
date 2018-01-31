package com.example.umarsaeedkhan.fyp_foodies;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

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

import app.AppController;

public class DishesOfSpecificRestaurant extends Activity {
    ArrayList<DishData> dishList;
    AdapterDish adapter;
    public static String pos = null;
    public static String get = null;
    public static String getOrderID = null;
    public static String getDishID ;
    public static String getDishPrice ;
    public static int quan = 1;
    public int text= R.array.numbers;


    Button btCheckOut;
    Spinner quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes_of_specific_restaurant);
        btCheckOut = (Button) findViewById(R.id.btnCheckOut);

         quantity = (Spinner)findViewById(R.id.spQuantity);
         //text = quantity.getSelectedItem().toString();



        Intent intent = getIntent();
        pos = intent.getStringExtra("position");
        get = intent.getStringExtra("id");

        dishList = new ArrayList<DishData>();
        new JSONAsyncTask().execute(Ngrok.url + "/AndroidWebservices/public/dish/" + pos);

        final ListView listview = (ListView) findViewById(R.id.listDishes);
        adapter = new AdapterDish(getApplicationContext(), R.layout.disheslist, dishList);
        listview.setAdapter(adapter);
        listview.setId(listview.getId());

            btCheckOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(DishesOfSpecificRestaurant.this, CheckOutDetails.class);
                    startActivity(in);
                }
            });
        }


    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(DishesOfSpecificRestaurant.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting...");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONArray jarray = new JSONArray(data);

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        DishData dish = new DishData();

                        dish.setDishName(object.getString("dish_name"));
                        dish.setDishPrice(object.getString("dish_price"));

                        getDishID = object.getString("dish_id");
                        getDishPrice = object.getString("dish_price");
                        dishList.add(dish);
                    }
                    return true;
                }

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
            if (result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();
        }
    }
    public void addTOCART() {
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Ngrok.url + "/AndroidWebservices/public/"
                + "order?user=" + get
                + "&rest=" + pos
                + "&oid=" + 1
                + "&did=" + getDishID
                + "&q=" + 1
                + "&p=" + getDishPrice
                , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                try {
//                   String gOrderID = response.getString("order_id");
//                   getOrderID = gOrderID;
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(Tag, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Sorry Something Went Wrong, Please Check Your Network Connection And Try Again!!", Toast.LENGTH_LONG).show();
//                clearText();
                // hide the progress dialog
//                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}



