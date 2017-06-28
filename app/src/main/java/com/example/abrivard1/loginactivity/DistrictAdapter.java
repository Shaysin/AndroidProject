package com.example.abrivard1.loginactivity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by roth on 19/05/2017.
 */
public class DistrictAdapter extends ArrayAdapter<District> implements Filterable {

    public ArrayList<District> items;
    public ArrayList<District> originalItems;
    private Activity activity;
    private int itemResourceId;


    public DistrictAdapter(Activity activity, int itemResourceId, ArrayList<District> items) {
        super(activity, itemResourceId,items);
        this.items=items;
        this.activity=activity;
        this.itemResourceId=itemResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View layout=convertView;
        if(convertView == null){
            LayoutInflater inflater = ((this.activity).getLayoutInflater());
            layout=inflater.inflate(this.itemResourceId,parent,false);
        }

        ImageView imageItem=(ImageView)layout.findViewById(R.id.image_item_district);
        imageItem.setImageResource(items.get(position).getImageResourceId());
        TextView txtItem=(TextView) layout.findViewById(R.id.text_item_district);
        txtItem.setText(items.get(position).getName());
        TextView numberItem=(TextView) layout.findViewById(R.id.number_item_district);
        numberItem.setText(Integer.toString(items.get(position).getId()));



        return layout;
    }

    @Nullable
    @Override
    public District getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public android.widget.Filter getFilter() {
        android.widget.Filter filter =new android.widget.Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results= new FilterResults();
                ArrayList<District> FilteredArrList = new ArrayList<District>();

                if (originalItems == null){
                    originalItems=new ArrayList<District>(items);
                }

                if(constraint == null || constraint.length() ==0){
                    results.count=originalItems.size();
                    results.values=originalItems;
                } else {
                    constraint=constraint.toString().toLowerCase();
                    for(int i=0;i<originalItems.size();i++){
                        District data = originalItems.get(i);
                        if(data.toString().toLowerCase().startsWith(constraint.toString())){
                            FilteredArrList.add(data);
                        }
                    }
                    results.count=FilteredArrList.size();
                    results.values=FilteredArrList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                items = (ArrayList<District>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

}
