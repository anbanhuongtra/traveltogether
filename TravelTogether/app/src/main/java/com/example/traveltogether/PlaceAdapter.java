package com.example.traveltogether;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Place> placesList;

    public PlaceAdapter(Context context, int layout, ArrayList<Place> placesList) {
        this.context = context;
        this.layout = layout;
        this.placesList = placesList;
    }

    public class ViewHolder
    {
        TextView txtName ;
        TextView txtProvince ;
        ImageView img ;

    }

    @Override
    public int getCount() {
        return placesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.txtName = view.findViewById(R.id.txtName);
            viewHolder.txtProvince = view.findViewById(R.id.txtProvince);
            viewHolder.img = view.findViewById(R.id.imageView);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final Place place = placesList.get(i);

        viewHolder.txtName.setText(place.getName());
        viewHolder.txtProvince.setText(place.getProvince());
        viewHolder.img.setImageResource(place.getImg());
        return view;
    }
}
