package com.example.sayedsalah.happit_tracker;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context myContext = null;
    private ArrayList<Contact> myData = null;

    public CustomAdapter(Context myContext, ArrayList<Contact> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.contact_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = myData.get(position);
        holder.nameTextView.setText(contact.getContactName());
        holder.phoneNumberTextView.setText(String.valueOf(contact.getPhoneNumber()));
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView phoneNumberTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            phoneNumberTextView = (TextView) itemView.findViewById(R.id.phoneNumberTextView);
        }
    }
}
