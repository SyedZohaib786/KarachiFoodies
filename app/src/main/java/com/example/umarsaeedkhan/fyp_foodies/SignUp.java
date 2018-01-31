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


public class SignUp extends AppCompatActivity {
    private static String TAG = SignUp.class.getSimpleName();
    Button register, goBackLogin;
    EditText firstName, lastName, Email, Password, Cell, DOB;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = (EditText) findViewById(R.id.etFname);
        lastName = (EditText) findViewById(R.id.etLname);
        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPwd);
        Cell = (EditText) findViewById(R.id.etMobile);
        DOB = (EditText) findViewById(R.id.etDob);


        register = (Button) findViewById(R.id.btnSignUp);
        goBackLogin = (Button) findViewById(R.id.btnbackToLogin);

        goBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBackToLogin = new Intent(SignUp.this, MainActivity.class);
                startActivity(goBackToLogin);
            }
        });

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        register = (Button) findViewById(R.id.btnSignUp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(firstName.getText().toString().trim().length() == 0){
                        Toast.makeText(getApplicationContext(), "Kindly fill all the fiels", Toast.LENGTH_LONG).show();
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
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Ngrok.url + "/AndroidWebservices/public/"
                + "reg?fname=" + firstName.getText().toString()
                + "&lname=" + lastName.getText().toString()
                + "&email=" + Email.getText().toString()
                + "&dob=" + DOB.getText().toString()
                + "&cell=" + Cell.getText().toString()
                + "&pwd=" + Password.getText().toString(),null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    Intent nextActivity = new Intent(SignUp.this, MainActivity.class);
                    startActivity(nextActivity);
                    Toast.makeText(getApplication(), "You are now registered with Karachi Foodies!! " + firstName.getText()
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
                        "Sorry Not Registered!!", Toast.LENGTH_SHORT).show();
//                clearText();
                // hide the progress dialog
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
