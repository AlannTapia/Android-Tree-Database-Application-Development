package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class Treelist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> tree_name, tree_height, user_name, trunk_color,
    trunk_diameter,leaf_color,leaf_shape,env_nation, env_region, hs_has_seeds_bool;
    DBHelper DB;
    MyAdapter2 adapter2;
    int filter_mode = 0;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treelist);

        Intent mIntent = getIntent();
        filter_mode = mIntent.getIntExtra("filter_mode", 0);


        DB = new DBHelper(this);
        tree_name = new ArrayList<>();
        tree_height = new ArrayList<>();
        user_name = new ArrayList<>();
        trunk_color = new ArrayList<>();
        trunk_diameter = new ArrayList<>();

        leaf_color = new ArrayList<>();
        leaf_shape = new ArrayList<>();
        env_nation = new ArrayList<>();
        env_region = new ArrayList<>();
        hs_has_seeds_bool = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview2);
        adapter2 = new MyAdapter2(this, tree_name, tree_height, user_name,trunk_color,trunk_diameter
                ,leaf_color,leaf_shape,env_nation, env_region, hs_has_seeds_bool);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {

        if(filter_mode == 0) {
            cursor = DB.getdata2();
        }
        if(filter_mode == 1) {
            cursor = DB.get_data_filter1();
        }
        if(filter_mode == 2) {
            cursor = DB.get_data_filter2();
        }
        if(filter_mode == 3) {
            cursor = DB.get_data_filter3();
        }
        if(filter_mode == 6) {
            cursor = DB.get_data_filter6();
        }
        /*
        if(filter_mode == 4) {
            cursor = DB.get_data_filter4();
        }

         */
            if(cursor.getCount()==0) {
                Toast.makeText(Treelist.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                return;
            }// end of if
            else {
                while(cursor.moveToNext()) {
                    tree_name.add(cursor.getString(0));
                    tree_height.add(cursor.getString(1));
                    user_name.add(cursor.getString(2));
                    trunk_color.add(cursor.getString(3));
                    trunk_diameter.add(cursor.getString(4));

                    leaf_color.add(cursor.getString(5));
                    leaf_shape.add(cursor.getString(6));
                    env_nation.add(cursor.getString(7));
                    env_region.add(cursor.getString(8));
                    hs_has_seeds_bool.add(cursor.getString(9));

                }// end of while
            }// end of else

    }// end of displaydata
}
