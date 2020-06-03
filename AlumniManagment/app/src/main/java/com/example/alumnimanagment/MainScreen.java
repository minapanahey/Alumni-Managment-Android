package com.example.alumnimanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void eventsList_button_click(View view) {
        Intent i = new Intent(this, EventsList.class);
        startActivity(i);
    }

    public void registeredEvents_button_click(View view) {
        Intent i = new Intent(this, RegisteredEvents.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}