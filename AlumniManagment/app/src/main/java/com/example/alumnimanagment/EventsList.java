package com.example.alumnimanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class EventsList extends AppCompatActivity implements EventsListRecyclerAdapter.IRecyclerViewItemClickListner{
    ArrayList<HashMap<String,String>> dataList = new ArrayList<HashMap<String,String>>();
    HashMap<String,String> data = new HashMap<String, String>();

    RecyclerView recyclerView;
    EventsListRecyclerAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        data = new HashMap<String,String>();
        data.put("Title","30% Presentation");
        data.put("StartDate","16/12/2019");
        data.put("Price","4 Gpa");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","30% asd");
        data.put("StartDate","16/12/2019");
        data.put("Price","4 Gpa");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","Rahat AL AIn");
        data.put("StartDate","21/2/2019");
        data.put("Price","1000");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","Marwa");
        data.put("StartDate","21/2/2019");
        data.put("Price","1500");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","Mina");
        data.put("StartDate","21/2/2019");
        data.put("Price","1500");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","Event Five");
        data.put("StartDate","21/2/2019");
        data.put("Price","1500");

        //ArrayList
        dataList.add(data);

        data = new HashMap<String,String>();
        data.put("Title","Event Six");
        data.put("StartDate","21/2/2019");
        data.put("Price","1500");

        //ArrayList
        dataList.add(data);


        layoutManager = new GridLayoutManager(this,2);

        adapter = new EventsListRecyclerAdapter(this,dataList);

        // TO use it implements
        // EventsListRecyclerAdapter.IRecyclerViewItemClickListner
        adapter.setRecyclerViewClickListner(this);


        recyclerView = findViewById(R.id.recyclerViewEventList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRecyclerViewItemClick(View view, int position) {
        //deleteSelectedItems();
        Intent i = new Intent(this,SingleEvent.class);
        i.putExtra("index",position);
        startActivity(i);
    }

    @Override
    public void onRecyclerViewItemLongClick(View view, int position) {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.settings)
        {
            Intent i = new Intent(this,Settings.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
