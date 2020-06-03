package com.example.alumnimanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
    }

    public void signIn_click(View view)
    {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }
}
