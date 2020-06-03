package com.example.alumnimanagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class EventsListRecyclerAdapter extends RecyclerView.Adapter<EventsListRecyclerAdapter.DataViewHolder>{

    Context context;
    IRecyclerViewItemClickListner clickListner;
    ArrayList<HashMap<String ,String>> data;
    LayoutInflater layoutInflater;
    ArrayList<Integer> selectedIndex;

    public EventsListRecyclerAdapter(Context context, ArrayList<HashMap<String,String>> data)
    {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);

        selectedIndex = new ArrayList<Integer>();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.events_list_view, parent ,false);
        return  new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        HashMap<String, String> currentRowData = data.get(position);
        holder.title.setText(currentRowData.get("Title"));
        holder.price.setText(currentRowData.get("Price"));
        holder.startDate.setText(currentRowData.get("StartDate"));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setRecyclerViewClickListner(IRecyclerViewItemClickListner clickListner)
    {
        this.clickListner = clickListner;
    }

    public ArrayList<Integer> getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(ArrayList<Integer> selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView title;
        TextView price;
        TextView startDate;
        LinearLayout container;

        public DataViewHolder(@NonNull View itemView)
        {
            super(itemView);

            container = (LinearLayout)itemView;
            title = itemView.findViewById(R.id.eventTitle);
            startDate = itemView.findViewById(R.id.eventStartDate);
            price = itemView.findViewById(R.id.eventPrice);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            clickListner.onRecyclerViewItemClick(view, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            selectedIndex.add(getAdapterPosition());
            clickListner.onRecyclerViewItemLongClick(view, getAdapterPosition());
            return true;
        }
    }

    public interface IRecyclerViewItemClickListner{

        void onRecyclerViewItemClick(View view, int position);
        void onRecyclerViewItemLongClick(View view, int position);
    }
}
