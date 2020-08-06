package com.myapplicationdev.android.p11_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerAdapter extends ArrayAdapter<String> {
    private ArrayList<String> drawer;
    private Context context;
    private TextView tv;
    private ImageView iv;

    public DrawerAdapter(Context context, int resource, ArrayList<String> objects){
        super(context, resource, objects);
        this.drawer = objects;
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tv = (TextView) rowView.findViewById(R.id.tvDrawer);
        iv = (ImageView) rowView.findViewById(R.id.ivDrawer);


       String currentModule = drawer.get(position);
       tv.setText(currentModule);
        // Set the TextView to show the food
        if(currentModule.equalsIgnoreCase("Bio")){
            iv.setImageResource(R.drawable.ic_baseline_info_24);
        }else if(currentModule.equalsIgnoreCase("Vaccination")){
            iv.setImageResource(R.drawable.ic_baseline_edit_24);
        }else if(currentModule.equalsIgnoreCase("Anniversary")){
            iv.setImageResource(R.drawable.ic_baseline_calendar_today_24);
        }
        else if(currentModule.equalsIgnoreCase("About Us")){
            iv.setImageResource(R.drawable.ic_baseline_star_24);
        }
        return rowView;
    }
}
