package com.example.traveltogether;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    PlaceAdapter placeAdapter;
    ArrayList<Place> placeArrayList;
    ListView listPlace;
    androidx.appcompat.widget.Toolbar  toolbar;
    DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listPlace = findViewById(R.id.listPlace);

        placeArrayList = new ArrayList<>();
        toolbar =  findViewById(R.id.toolbarBottom);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button btnOption =toolbar.findViewById(R.id.option);

        placeArrayList.add(new Place("Taj Mahal","Agra",R.drawable.tajmahal));
        placeArrayList.add(new Place("Vạn lý trường thành","Hoài Nhu - Bắc Kinh",R.drawable.vltt));
        placeArrayList.add(new Place("Tháp Eiffel","Thành phố Paris",R.drawable.eiffel_tower));
        placeArrayList.add(new Place("Biển Kỳ Co","Thành phố Quy Nhơn",R.drawable.kyco));


        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        placeAdapter = new PlaceAdapter(this,R.layout.information_place,placeArrayList);
        listPlace.setAdapter(placeAdapter);

        listPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = placeArrayList.get(i);
                Intent intent = new Intent(ListActivity.this,DetailActivity.class);
                intent.putExtra("data",place);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
