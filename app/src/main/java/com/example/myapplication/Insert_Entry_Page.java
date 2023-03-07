package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Insert_Entry_Page extends AppCompatActivity {
    //Tree(tree_id TEXT primary key, tree_type TEXT, tree_color TEXT, tree_height TEXT)");
    EditText username, tree_name, tree_height;
    EditText trunk_color, trunk_diameter;
    EditText leaf_color, leaf_shape;
    EditText env_nation, env_region;
    EditText hs_has_seeds_bool;

    Button insert2, view2, delete2, viewUser2;

    //
    //Button Entry_Page;
    //
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_entry_page);

        username = findViewById(R.id.username);
        tree_name= findViewById(R.id.tree_name);
        tree_height = findViewById(R.id.tree_height);

        trunk_color = findViewById(R.id.trunk_color);
        trunk_diameter = findViewById(R.id.trunk_diameter);

        leaf_color = findViewById(R.id.leaf_color);
        leaf_shape = findViewById(R.id.leaf_shape);

        env_nation = findViewById(R.id.nation);
        env_region = findViewById(R.id.region);

        hs_has_seeds_bool = findViewById(R.id.seeds);


        insert2 = findViewById(R.id.btnInsert2);
        //viewUser = findViewById(R.id.btnUserView);
        delete2 = findViewById(R.id.btndelete2);
        //
        //Entry_Page = findViewById(R.id.btnInsertEntry);
        //
        DB = new DBHelper(this);

        insert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tree_id, tree_type, tree_color, tree_height;
                String tree_nameTXT = tree_name.getText().toString();
                String tree_heightTXT = tree_height.getText().toString();
                String usernameTXT = username.getText().toString();

                String trunk_colorTXT = trunk_color.getText().toString();

                Boolean checkinsertdata  = DB.insert_tree_data(tree_nameTXT,tree_heightTXT,usernameTXT,trunk_colorTXT,
                trunk_diameter.getText().toString(),leaf_color.getText().toString(),leaf_shape.getText().toString(), env_nation.getText().toString(),
                env_region.getText().toString(), hs_has_seeds_bool.getText().toString());

                if(checkinsertdata==true)
                {
                    Toast.makeText(Insert_Entry_Page.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Insert_Entry_Page.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tree_nameTXT = tree_name.getText().toString();

                Boolean checkdeletedata  = DB.delete_tree_data(tree_nameTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(Insert_Entry_Page.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Insert_Entry_Page.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}