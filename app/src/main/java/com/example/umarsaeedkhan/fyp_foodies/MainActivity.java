package com.example.umarsaeedkhan.fyp_foodies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import app.AppController;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    Button Login, btnSignUp;
    private ProgressDialog progressDialog;
    EditText Email, Password;
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPwd);
        Login = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnRegister);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gotoSignup = new Intent(MainActivity.this, SignUp.class);
                startActivity(gotoSignup);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(Email.getText().toString().trim().length() == 0 || Password.getText().toString().trim().length() == 0){
                        Toast.makeText(getApplicationContext(), "Fill the Fields", Toast.LENGTH_LONG).show();
                    }else
                   makeJsonObjectRequestAgent();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void makeJsonObjectRequestAgent() throws JSONException {
        showpDialog();
       final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Ngrok.url + "/AndroidWebservices/public/"
                + "login?email=" + Email.getText().toString()
                + "&pwd=" + Password.getText().toString(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String userID = response.getString("id");
                    String getUser = "";
                    getUser = userID;
                    Intent nextActivity = new Intent(MainActivity.this, MainScreen.class);
                    nextActivity.putExtra("id", getUser);
                    startActivity(nextActivity);
                    Toast.makeText(getApplication(), "LoggedIn.. "
                            , Toast.LENGTH_SHORT).show();



//                    clearText();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Wrong Credentials, or Check Your Network Connection!!", Toast.LENGTH_SHORT).show();
//                clearText();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
    private void showpDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hidepDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
    public void clearText()
    {
        Email.setText("");
        Password.setText("");
    }

}
