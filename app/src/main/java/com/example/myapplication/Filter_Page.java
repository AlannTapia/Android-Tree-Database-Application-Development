package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Filter_Page extends AppCompatActivity {
    EditText name, email, age;
    Button Filter_1,Filter_2, Filter_3, Filter_4, Filter_5,Filter_6;
    int filter_mode = 0;

    //
    //Button Entry_Page;
    //
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_filter_page);
        Filter_1 = findViewById(R.id.btnFilter1);
        Filter_2 = findViewById(R.id.btnFilter2);
        Filter_3 = findViewById(R.id.btnFilter3);
        Filter_4 = findViewById(R.id.btnFilter4);
        Filter_5 = findViewById(R.id.btnFilter5);
        Filter_6 = findViewById(R.id.btnFilter6);

        DB = new DBHelper(this);
        /*
        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        age = findViewById(R.id.age);

        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        viewUser = findViewById(R.id.btnUserView);
        delete = findViewById(R.id.btnDelete);
        //
        Entry_Page = findViewById(R.id.btnInsertEntry);
        //
        DB = new DBHelper(this);


         */
        Filter_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 1;
                //startActivity(new Intent(Filter_Page.this, Treelist.class));
                Intent myIntent = new Intent(Filter_Page.this, Treelist.class);
                myIntent.putExtra("filter_mode", 1);
                startActivity(myIntent);
            }
        });
        Filter_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 2;
                //startActivity(new Intent(Filter_Page.this, Treelist.class));
                Intent myIntent = new Intent(Filter_Page.this, Treelist.class);
                myIntent.putExtra("filter_mode", 2);
                startActivity(myIntent);
            }
        });
        Filter_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 3;
                //startActivity(new Intent(Filter_Page.this, Treelist.class));
                Intent myIntent = new Intent(Filter_Page.this, Treelist.class);
                myIntent.putExtra("filter_mode", 3);
                startActivity(myIntent);
            }
        });
        Filter_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 4;
                //startActivity(new Intent(Filter_Page.this, Treelist.class));
                Intent myIntent = new Intent(Filter_Page.this, Userlist.class);
                myIntent.putExtra("filter_mode", 4);
                startActivity(myIntent);
            }
        });
        Filter_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 5;
                //startActivity(new Intent(Filter_Page.this, Userlist.class));
                Intent myIntent = new Intent(Filter_Page.this, Userlist.class);
                myIntent.putExtra("filter_mode", 5);
                startActivity(myIntent);
            }
        });
        Filter_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filter_mode = 6;
                //startActivity(new Intent(Filter_Page.this, Userlist.class));
                Intent myIntent = new Intent(Filter_Page.this, Treelist.class);
                myIntent.putExtra("filter_mode", 6);
                startActivity(myIntent);
            }
        });
    }// end of onCreate
}// end of class