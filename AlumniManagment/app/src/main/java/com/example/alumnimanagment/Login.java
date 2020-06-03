package com.example.alumnimanagment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login_signUp_click(View view)
    {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
        finish();
    }

    public void signInButton_Click(View view)
    {
        Intent i = new Intent(this,MainScreen.class);
        startActivity(i);
        finish();

        final String loginUrl = "http://10.0.2.2:8080/token";
        final String registrationNo = ((TextView)findViewById(R.id.login_RegistrationNo)).toString();
        final String password = ((TextView)findViewById(R.id.login_Password)).toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        try {
            StringRequest arrayRequest = new StringRequest(
                    Request.Method.GET,
                    loginUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //Log.i("success2",response.toString());
                            Toast.makeText(Login.this,"success",Toast.LENGTH_LONG).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("error2",error.toString());
                            Toast.makeText(Login.this,"fail",Toast.LENGTH_LONG).show();
                        }
                    }
            );//{
//                @Override
//                protected Map<String,String> getParams(){
//                    Map<String,String> params = new HashMap<String, String>();
//                    params.put("grant_type","password");
//                    params.put("username",registrationNo);
//                    params.put("password", password);
//
//                    return params;
//                }
//
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                    Map<String,String> params = new HashMap<String, String>();
//                    params.put("Content-Type","application/x-www-form-urlencoded");
//                    return params;
//                }
//            };
            requestQueue.add(arrayRequest);
        }
        catch (Exception e)
        {
            Log.i("exception2",e.getMessage());
        }

    }
}